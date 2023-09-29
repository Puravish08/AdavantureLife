package com.example.adventerlife.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adventerlife.ModelClass.HomeModel
import com.example.adventerlife.R
class AdapterClass(
    private val homeFragment: Context,
    private var originalList: List<HomeModel>,
    var onItemClick:(place:String, price:String, img:String, key:String) -> Unit
) : RecyclerView.Adapter<AdapterClass.MyViewHolder>(), Filterable {

    private var filteredList: List<HomeModel> = originalList

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val place: TextView = itemView.findViewById(R.id.palce)
        val price: TextView = itemView.findViewById(R.id.txtlocation)
        val img: ImageView = itemView.findViewById(R.id.img)
        val fullcard: CardView = itemView.findViewById(R.id.fullcard)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_file, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = filteredList[position]
        holder.place.text = item.palce
        holder.price.text = item.price

        Glide.with(homeFragment)
            .load(item.ImageUri)
            .into(holder.img)

        holder.fullcard.setOnClickListener {


            onItemClick.invoke(
                originalList[position].palce,
                originalList[position].price,
                originalList[position].ImageUri,
                originalList[position].key,
            )

        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString().toLowerCase().trim()
                val results = FilterResults()

                if (query.isEmpty()) {
                    results.values = originalList
                } else {
                    val filtered = originalList.filter { item ->
                        item.palce.toLowerCase().contains(query) ||
                                item.price.toLowerCase().contains(query)
                        // Add more conditions as needed for searching other fields
                    }
                    results.values = filtered
                }

                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<HomeModel>
                notifyDataSetChanged()
            }
        }
    }

    fun setData(newData: List<HomeModel>) {
        originalList = newData
        filteredList = newData
        notifyDataSetChanged()
    }
}
