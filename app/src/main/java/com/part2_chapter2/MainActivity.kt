package com.part2_chapter2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.part2_chapter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        val height = binding.heightEditText
        val weight = binding.weightEditText
        binding.resultButton.setOnClickListener {
            Log.d("MainActivity", "ResultButton 이 클릭됨")

            if (height.text.isEmpty() || weight.text.isEmpty()) {
                Log.d("MainActivity", "빈값잇습")
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = height.text.toString().toInt()
            val weight: Int = weight.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height",height)
            intent.putExtra("weight",weight)

            startActivity(intent)
        }

        setContentView(view) // activity_main을 viewbinding으로 설정하겠다는 의미
    }
}