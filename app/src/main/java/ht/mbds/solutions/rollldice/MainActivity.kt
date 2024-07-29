package ht.mbds.solutions.rollldice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
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
        var thisActivity : Context = this
        validation(thisActivity)
        binding.btnRoll.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice() {
        val dice1 = rollDice(binding.diceNumber1Txt)
        val dice2 = rollDice(binding.diceNumber1Txt2)
        val total = dice1 + dice2
        /*if (binding.diceNumber1Txt.text.trim() == binding.diceNumber1Txt2.text.trim()){
            Toast.makeText(this,"Vous avez gagné, Félicitation",Toast.LENGTH_LONG).show()
            MediaPlayer.create(this, R.raw.plucky).start();
        }*/
        if (total== binding.entryNumberTxt.text.trim().toString().toInt()){
            Toast.makeText(this,"Vous avez gagné, Félicitation",Toast.LENGTH_LONG).show()
            MediaPlayer.create(this, R.raw.plucky).start();
        }
    }
    private fun validation(thisActivity: Context) {
        binding.entryNumberTxt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val enteredText: String = s.toString()
                if (enteredText.isNullOrEmpty()){
                    binding.btnRoll.isEnabled = false
                    Toast.makeText(thisActivity,"Veuillez entre un nombre entre 1 à 18",Toast.LENGTH_LONG).show()
                }else{
                    if (enteredText.toLong() <1 || enteredText.toLong() >18){
                        binding.btnRoll.isEnabled = false
                        Toast.makeText(thisActivity,"nombre doit etre superieur à 0 et inferieur à 19",Toast.LENGTH_LONG).show()
                    }else{
                        binding.btnRoll.isEnabled = true
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}

private fun rollDice(diceTxtView : TextView ) : Int {
    val dice = Dice(6)
    val diceRoll = dice.roll()
    diceTxtView.text = diceRoll.toString()
    return diceRoll
}



