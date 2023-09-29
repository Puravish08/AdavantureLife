package com.example.adventerlife.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adventerlife.Fragment.HomeFragment
import com.example.adventerlife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.cardNext1.setOnClickListener {
            var  i = Intent(this, Introduction2Activity::class.java)
            startActivity(i)

        }
       binding.skip.setOnClickListener {
            var  i = Intent(this, HomeFragment::class.java)
            startActivity(i)
        }

    }
}