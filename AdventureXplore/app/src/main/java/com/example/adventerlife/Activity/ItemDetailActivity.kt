package com.example.adventerlife.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.adventerlife.R
import com.example.adventerlife.databinding.ActivityItemDetailBinding

class ItemDetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityItemDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {



        if (intent != null) {

            var key = intent.getStringExtra("key").toString()
            var place = intent.getStringExtra("place").toString()
            var price = intent.getStringExtra("price").toString()
            var img = intent.getStringExtra("img").toString()
//            var key = intent.getStringExtra("key").toString()

            binding.palce.text = place
            binding.txtmap.text = price



            Glide.with(baseContext).load(img).into(binding.img)

        }




    }
}