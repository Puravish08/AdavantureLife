package com.example.adventerlife.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.adventerlife.R
import com.example.adventerlife.databinding.ActivitySameDetalisBinding

class SameDetalisActivity : AppCompatActivity() {

    private val binding : ActivitySameDetalisBinding by lazy {
        ActivitySameDetalisBinding.inflate(layoutInflater)
    }
    lateinit var data  :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {

        if (intent != null) {

            var key = intent.getStringExtra("key").toString()
            var Location = intent.getStringExtra("Location").toString()
            var place = intent.getStringExtra("place").toString()
            var price = intent.getStringExtra("price").toString()
            var Rate = intent.getStringExtra("Rate").toString()
            var img = intent.getStringExtra("img").toString()
            var Book_beach = intent.getStringExtra("Book_beach").toString()
            

            Glide.with(baseContext).load(img).into(binding.imgBeach)


            binding.txtLocation.text = Location
            binding.txtName.text = place
            binding.txtRating.text = Rate
            binding.txtAmount.text = price


        }





    }
}