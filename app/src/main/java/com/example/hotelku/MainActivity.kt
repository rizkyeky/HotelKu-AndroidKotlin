package com.example.hotelku

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
import android.app.Activity
import android.view.View
import kotlin.random.Random
import androidx.databinding.DataBindingUtil
import com.example.hotelku.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        "Hello World ".repeat(100).also { binding.textScroll.text = it }
        binding.randomButton.setOnClickListener {
            randNumber()
            setResultType()
        }
    }

    private fun randNumber() {
        val randomNum: Int = Random.nextInt(6) + 1
        val resourceDiceImg = when(randomNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        if (binding.diceImg.visibility == View.INVISIBLE) {
            binding.diceImg.visibility = View.VISIBLE
        }
        binding.diceImg.setImageResource(resourceDiceImg)
        binding.resultNumber.text = randomNum.toString()
    }

    private fun setResultType() {
        binding.resultType.text = binding.typeField.text
    }
}