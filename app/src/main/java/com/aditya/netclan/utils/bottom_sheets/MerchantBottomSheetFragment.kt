package com.aditya.netclan.utils.bottom_sheets

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import com.aditya.netclan.R
import com.aditya.netclan.databinding.FragmentMerchantBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.LabelFormatter
import com.google.android.material.slider.RangeSlider

class MerchantBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentMerchantBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMerchantBottomSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val slider = binding.scoreSlider
        slider.setValues(1.0f, 100.0f)
        slider.labelBehavior = LabelFormatter.LABEL_GONE

        // Set up a listener for value changes
        slider.addOnChangeListener { _, _, _ ->
            updateSliderValues(slider)
        }

        slider.addOnChangeListener { _, _, _ ->
            val values = slider.values
            if (values[1] - values[0] < 5) {
                // If the difference is less than 5, adjust the values
                values[0] = maxOf(values[1] - 5, slider.valueFrom)
                values[1] = values[0] + 5
                slider.values = values
            }
        }


        val items = arrayOf(
            "Wine Shops",
            "restaurants & Coffee Shops",
            "Shoes & Accessories",
            " Jewellers",
            " Sallons",
            "Gymnasium",
            "Chemists Y Drugists",
            "Automobile Dealers",
            "Movie Theaters",
            "Home Appliances",
            "Mobile Phones Accessories",
            "Hospital",
            "Nursing Home",
            "Hardware & Paint Shop",
            "Home Depot",
            "Sports Equipment",
            "Wedding Planner",
            "Printers",
            "Temple",
            "Hotels",
            "Villa",
            "Home Stay",
            "Beauty Parlors",
            "SPA",
            "Wellness and Health",
            "School",
            "College",
            "Tuition & Coaching Centers",
            "Meat Shops",
            "Doctors",
            "Paramedic Services",
            "Travel & Tour Operators",
            "VISA consultancy",
            " ATM's",
            "Street food Kiosks",
            "Security Agency"
        )

        val autoCompleteTxt = binding.autoCompleteTxt
        val adapterItems = ArrayAdapter<String>(requireContext(), R.layout.list_item, items)
        autoCompleteTxt.setAdapter(adapterItems)

        autoCompleteTxt.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
        }


        //to close this bottom sheet
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


    private fun updateSliderValues(slider: RangeSlider) {
        val sliderValues = slider.values
        val minValue = sliderValues[0]
        val maxValue = sliderValues[1]

        binding.profileCompletionScore.text = "${minValue.toInt()}-${maxValue.toInt()}"
    }


}