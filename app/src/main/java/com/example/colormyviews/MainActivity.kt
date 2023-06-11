package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickListener()
    }

    private fun onClickListener() {
        val viewList: List<View>?

        binding.apply {
            viewList = listOf(
                boxOne,
                boxTwo,
                boxThree,
                boxFour,
                boxFive,
                constraintLayout,
                yellowButton,
                redButton,
                greenButton
            )
        }

        viewList!!.forEach { view ->
            view.setOnClickListener {
                changeColor(it)
            }
        }
    }

    private fun changeColor(view: View) {
        when (view.id) {
            R.id.box_one -> view.setBackgroundColor(Color.BLUE)
            R.id.box_two -> view.setBackgroundColor(Color.RED)
            R.id.box_three -> view.setBackgroundColor(Color.YELLOW)
            R.id.box_four -> view.setBackgroundColor(Color.CYAN)
            R.id.box_five -> view.setBackgroundColor(Color.MAGENTA)
            R.id.red_button -> binding.boxThree.setBackgroundResource(R.color.red)
            R.id.yellow_button -> binding.boxFour.setBackgroundResource(R.color.yellow)
            R.id.green_button -> binding.boxFive.setBackgroundResource(R.color.green)
            else -> {
                view.setBackgroundColor(Color.WHITE)
                binding.apply {
                    tutorial.setTextColor(Color.BLACK)
                    explain.setTextColor(Color.BLACK)
                }
            }
        }
    }


}