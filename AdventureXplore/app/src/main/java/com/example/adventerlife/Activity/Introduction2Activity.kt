package com.example.adventerlife.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adventerlife.Fragment.HomeFragment
import com.example.adventerlife.databinding.ActivityIntroduction2Binding

class Introduction2Activity : AppCompatActivity() {
    lateinit var  binding: ActivityIntroduction2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroduction2Binding.inflate(layoutInflater)

        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.cardNext2.setOnClickListener {
            var  i = Intent(this, Introduction3Activity::class.java)
            startActivity(i)

        }

        binding.skip.setOnClickListener {
            var  i = Intent(this, HomeFragment::class.java)
            startActivity(i)
        }




    }
}