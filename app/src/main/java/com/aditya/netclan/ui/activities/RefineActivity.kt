package com.aditya.netclan.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.aditya.netclan.R
import com.aditya.netclan.databinding.ActivityRefineBinding
import java.util.Locale

class RefineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRefineBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefineBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //selecting/deselecting purposes
        binding.coffeeBG.setOnClickListener {
            applyCustomBackground(binding.coffeeBG, binding.coffeTV)
        }
        binding.businessBG.setOnClickListener {
            applyCustomBackground(binding.businessBG, binding.businessTV)
        }
        binding.hobbiesBG.setOnClickListener {
            applyCustomBackground(binding.hobbiesBG, binding.hobbiesTV)
        }
        binding.friendshipBG.setOnClickListener {
            applyCustomBackground(binding.friendshipBG, binding.friendshipTV)
        }
        binding.moviesBG.setOnClickListener {
            applyCustomBackground(binding.moviesBG, binding.moviesTV)
        }
        binding.dinningBG.setOnClickListener {
            applyCustomBackground(binding.dinningBG, binding.dinningTV)
        }
        binding.datingBG.setOnClickListener {
            applyCustomBackground(binding.datingBG, binding.datingTV)
        }
        binding.matrimonyBG.setOnClickListener {
            applyCustomBackground(binding.matrimonyBG, binding.matrimonyTV)
        }


        binding.save.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

        val items = arrayOf(
            "Available | Hey Let us Connect",
            "Away | Stay Discrete And Watch",
            "Busy | Do Not Disturb | Will Catch Up Later",
            "SOS | Emergecy! Need Assistance! HELP"
        )

        val autoCompleteTxt = findViewById<AutoCompleteTextView>(R.id.auto_complete_txt)
        val adapterItems = ArrayAdapter<String>(this, R.layout.list_item, items)
        autoCompleteTxt.setAdapter(adapterItems)

        autoCompleteTxt.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
        }



        val editText = findViewById<EditText>(R.id.roundedEditText)
        val characterCount = findViewById<TextView>(R.id.characterCount)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for character count
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed for character count
            }
            override fun afterTextChanged(s: Editable?) {
                // Update character count
                val count = s?.length ?: 0
                characterCount.text = "$count/250" // Show current count and maximum limit
            }
        })
        editText.text?.let { text ->
            val charCount = text.length
            characterCount.text = "$charCount/250"
        }



        //it will set the slider's initial value to 20 in the starting of this Activity
        binding.root.post {

            binding.slider.values = listOf(20f)
            binding.slider.setLabelFormatter { value ->
                // Format the value as an integer
                val tooltipText = String.format(Locale.US, "%.0f", value).toInt().toString()
                tooltipText
            }
        }

    }




    private fun applyCustomBackground(view: View, textView: TextView) {
        val customBackgroundId = R.drawable.colordtext_purpose_bg
        val defaultCustomBackgroundId = R.drawable.text_purpose_bg

        if (view.background.constantState == ContextCompat.getDrawable(view.context, defaultCustomBackgroundId)?.constantState) {
            view.setBackgroundResource(customBackgroundId)
            textView.setTextColor(ContextCompat.getColor(view.context, R.color.white))
        } else {
            view.setBackgroundResource(defaultCustomBackgroundId)
            textView.setTextColor(ContextCompat.getColor(view.context, R.color.background))
        }
    }

}