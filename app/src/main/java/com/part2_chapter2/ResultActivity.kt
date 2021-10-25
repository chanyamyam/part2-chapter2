package com.part2_chapter2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.part2_chapter2.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity","height:${height},weight:${weight}")

        val bmi = weight / (height / 100.0).pow(2.0)

        val resultText = when {
            bmi >= 35.0 ->"고도 비만"
            bmi >= 30.0 ->"중정도 비만"
            bmi >= 25.0 ->"경도 비만"
            bmi >= 23.0 ->"과체중"
            bmi >= 18.5 ->"정상체중"
            else -> "저체중"
        }

        binding.bmiText.text = bmi.toString()
        binding.resultText.text = resultText

        setContentView(view)
    }
}