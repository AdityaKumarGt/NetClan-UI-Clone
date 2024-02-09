package com.aditya.netclan.utils.bottom_sheets

import android.app.Dialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.aditya.netclan.R
import com.aditya.netclan.databinding.FragmentBusinessBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.slider.LabelFormatter
import com.google.android.material.slider.RangeSlider


class BusinessBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBusinessBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusinessBottomSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val experienceSlider = binding.experienceSlider
        experienceSlider.setValues(1.0f, 80.0f)
        experienceSlider.labelBehavior = LabelFormatter.LABEL_GONE

        val scoreSlider = binding.scoreSlider
        scoreSlider.setValues(1.0f, 100.0f)
        scoreSlider.labelBehavior = LabelFormatter.LABEL_GONE

        // Set up a listener for value changes
        experienceSlider.addOnChangeListener { _, _, _ ->
            updateExperienceSliderValues(experienceSlider)
        }
        scoreSlider.addOnChangeListener { _, _, _ ->
            updateScoreSliderValues(scoreSlider)
        }

        experienceSlider.addOnChangeListener { _, _, _ ->
            val values = experienceSlider.values
            if (values[1] - values[0] < 5) {
                // If the difference is less than 5, adjust the values
                values[0] = maxOf(values[1] - 5, scoreSlider.valueFrom)
                values[1] = values[0] + 5
                experienceSlider.values = values
            }
        }
        scoreSlider.addOnChangeListener { _, _, _ ->
            val values = scoreSlider.values
            if (values[1] - values[0] < 5) {
                // If the difference is less than 5, adjust the values
                values[0] = maxOf(values[1] - 5, scoreSlider.valueFrom)
                values[1] = values[0] + 5
                scoreSlider.values = values
            }
        }


        val items = arrayOf(
            "Business Services",
            "Utility Services",
            "Government Services",
            "Medical Services",
            "Religious Services",
            "Academics",
            "Educational Services",
            "Defence Services",
            "Banking Services",
            "Social Volunteer",
            "Other"

        )

        val autoCompleteTxt = binding.autoCompleteTxt
        val adapterItems = ArrayAdapter<String>(requireContext(), R.layout.list_item, items)
        autoCompleteTxt.setAdapter(adapterItems)

        autoCompleteTxt.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
        }



        binding.closeDialog.setOnClickListener {
            dismiss()
        }
        binding.apply.setOnClickListener {
            dismiss()
        }

        return root
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener { dialog ->
                val bottomSheetDialog = dialog as BottomSheetDialog
                val bottomSheet =
                    bottomSheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
                BottomSheetBehavior.from(bottomSheet!!).state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val bottomSheet =
            (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
        val behavior = BottomSheetBehavior.from(bottomSheet!!)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        // Set bottom sheet height manually
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
        behavior.isDraggable = false

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Handle state changes if needed
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // Prevent collapsing when swiping down
                if (slideOffset < 0) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }
        })

    }


    private fun updateExperienceSliderValues(slider: RangeSlider) {
        val sliderValues = slider.values
        val minValue = sliderValues[0]
        val maxValue = sliderValues[1]
        binding.yearsOfExperience.text = "${minValue.toInt()}-${maxValue.toInt()}"
    }
    private fun updateScoreSliderValues(slider: RangeSlider) {
        val sliderValues = slider.values
        val minValue = sliderValues[0]
        val maxValue = sliderValues[1]
        binding.profileCompletionScore.text = "${minValue.toInt()}-${maxValue.toInt()}"
    }



}