package com.example.hotelku

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.app.Activity
import kotlin.random.Random
import androidx.databinding.DataBindingUtil
import com.example.hotelku.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var resultNumber: TextView
    private lateinit var randButton: Button
    private lateinit var diceImg: ImageView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        resultNumber = findViewById<TextView>(R.id.result_number)
        randButton = findViewById<Button>(R.id.random_button)
        diceImg = findViewById<ImageView>(R.id.dice_img)

        binding.randomButton.setOnClickListener {
            randNumber()
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
        diceImg.setImageResource(resourceDiceImg)
        resultNumber.text = randomNum.toString()
    }
}