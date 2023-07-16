package com.example.dicerollapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.dicerollapp.databinding.ActivityMainBinding
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var currentplayer:Int=1
    private var player1score=0
    private var player2score=0
    private var winscore=30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rollbutton.setOnClickListener {
            val random= Random.nextInt(6)+1
            val dice=when(random){
                1->R.drawable.dice1
                2->R.drawable.dice2
                3->R.drawable.dice3
                4->R.drawable.dice4
                5->R.drawable.dice5

                else -> {
                   R.drawable.dice6
                }


            }
            binding.dicceimage.setImageResource(dice)
            if(currentplayer==1){
                player1score+=random
                currentplayer=2
            binding.playeroncscore.text=player1score.toString()
            }
            else
            {
                player2score+=random

                binding.playertwoscore.text=player2score.toString()
                currentplayer=1
            }
            if(player1score>=winscore){
                binding.winner.text="Player one won"
                binding.rollbutton.text="Play Again"
                binding.animationView.visibility=View.VISIBLE


                MotionToast.createToast(this,
                    "Hurray success 😍",
                    "Player One Win",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular))

                if(binding.rollbutton.text.toString().equals("Play Again")){
                    binding.rollbutton.setOnClickListener {
                        recreate()
                    }

                }

            }else if (player2score>=winscore) {
                binding.winner.text = "Player two won"
                binding.rollbutton.text="Play Again"
                binding.animationView.visibility=View.VISIBLE

                MotionToast.createToast(this,
                    "Hurray success 😍",
                    "Player Second Won",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular))

                if(binding.rollbutton.text.toString().equals("Play Again")){
                    binding.rollbutton.setOnClickListener {
                        recreate()
                    }

                }
            }
            binding.currentplayer.text="Current player : $currentplayer"


        }
    }
}