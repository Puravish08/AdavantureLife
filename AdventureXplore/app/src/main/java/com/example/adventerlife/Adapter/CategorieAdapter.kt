package com.example.adventerlife.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adventerlife.Activity.CategoryActivity
import com.example.adventerlife.ModelClass.MountainModal
import com.example.adventerlife.R

class CategorieAdapter(var categoryActivity: CategoryActivity, var list: ArrayList<MountainModal>,
                       var onItemClick:(place:String,Location : String,Price:String,Rate : String,Image:String,Key:String)->Unit):
    RecyclerView.Adapter<CategorieAdapter.MyviewHolder>() {
    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var place:TextView=itemView.findViewById(R.id.txtplace)
        var Location:TextView=itemView.findViewById(R.id.txtLocation)
        var Price:TextView=itemView.findViewById(R.id.txtPrice)
        var Rate:TextView=itemView.findViewById(R.id.txtRate)
        var img:ImageView=itemView.findViewById(R.id.img_beach)
        var Book_time:AppCompatButton=itemView.findViewById(R.id.Book_time)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var View=LayoutInflater.from(parent.context).inflate(R.layout.categorie_item_file,parent,false)
        return MyviewHolder(View)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.place.text=list[position].palce
        holder.Location.text=list[position].Location
        holder.Price.text=list[position].Price
        holder.Rate.text=list[position].Rate
        Glide.with(categoryActivity).load(list[position].ImageUri).into(holder.img)


        holder.Book_time.setOnClickListener {

            onItemClick.invoke(
                list[position].palce,
                list[position].Location,
                list[position].Price,
                list[position].Rate,
                list[position].ImageUri,
                list[position].key,

            )

        }

    }
}