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
        binding.btnRoll.setOnClickListener{
            rollDice(binding.diceNumber1Txt)
            rollDice(binding.diceNumber1Txt2)
            if (binding.diceNumber1Txt.text.trim() == binding.diceNumber1Txt2.text.trim()){
                Toast.makeText(this,"Vous avez gagné, Félicitation",Toast.LENGTH_LONG).show()
                MediaPlayer.create(this, R.raw.plucky).start();
            }
        }
    }
}

private fun rollDice(diceTxtView : TextView ) {
    val dice = Dice(6)
    val diceRoll = dice.roll()
    diceTxtView.text = diceRoll.toString()
}

