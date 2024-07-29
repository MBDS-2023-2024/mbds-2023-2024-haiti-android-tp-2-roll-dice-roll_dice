package ht.mbds.solutions.rollldice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import ht.mbds.solutions.rollldice.classes.Dice
import ht.mbds.solutions.rollldice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRoll.setOnClickListener{ rollDice(binding.diceNumber1Txt) }
    }
}

private fun rollDice(diceTxtView : TextView ) {
    val dice = Dice(6)
    val diceRoll = dice.roll()
    diceTxtView.text = diceRoll.toString()
}