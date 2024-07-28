package ht.mbds.solutions.rollldice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ht.mbds.solutions.rollldice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRoll.setOnClickListener{
            binding.diceNumber1.text = "2"
            Toast.makeText(this,"Dice have been rolled",Toast.LENGTH_LONG).show()
        }
    }
}