package com.example.calculatordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatordemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    private fun calculateTip() {

        val costStr = binding.costOfService?.text.toString()
        val cost = costStr.toDouble()
        val buttonId = binding.tipOptions.checkedRadioButtonId
        val percent = when (buttonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15

        }
        var result = cost * percent

        val checked = binding.roundUpSwitch.isChecked
        if (checked){
            result = kotlin.math.ceil(result)
        }

        binding.tipResult.text= result.toString()
    }
}