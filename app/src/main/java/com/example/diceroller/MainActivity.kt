package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //best practice to make my app more faster and reduce lags by calling the findViewById method many times.
    //lateinit keyword promises the kotlin compiler that this variable will not be null at any point.
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //old way of referencing a view on layout xml to an activity
        val rollButton:Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()

        }
        diceImage = findViewById(R.id.dice_image)
        //uses Toast library to show popups
        //rollButton.setOnClickListener{
        //    Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        //}
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1

        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        //diceImage is now a field and can be accessed directly
        diceImage.setImageResource(drawableResource)

    }
}