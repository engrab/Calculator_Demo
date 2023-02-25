package com.example.calculatordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatordemo.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.cos

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

     private fun calculateTip() {

        val costStr = binding.costOfService?.text.toString()
        val cost = costStr.toDoubleOrNull()
         if (cost == null || cost == 0.0){
             displayTip(0.0)
             return
         }
         val percent = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15

        }
        var result = cost * percent


        if (binding.roundUpSwitch.isChecked){
            result = kotlin.math.ceil(result)
        }

        displayTip(result)
    }

    private fun displayTip(tip : Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}