package com.example.adventerlife.Adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.adventerlife.R

import java.util.*

class ImageAdapter (var images:List<Int>): PagerAdapter() {
    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }

    @SuppressLint("MissingInflatedId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view =LayoutInflater.from(container.context).inflate(R.layout.image_item_file,container,false)
        var imageview=view.findViewById<ImageView>(R.id.imgview)
        imageview.setImageResource(images[position])
        container.addView(view)
        return view
    }
}