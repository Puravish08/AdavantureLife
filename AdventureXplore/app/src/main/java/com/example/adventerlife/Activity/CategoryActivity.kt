package com.example.adventerlife.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adventerlife.Adapter.CategorieAdapter
import com.example.adventerlife.ModelClass.MountainModal
import com.example.adventerlife.databinding.ActivityCategorieBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CategoryActivity : AppCompatActivity() {

    lateinit var binding:ActivityCategorieBinding
    var reference = FirebaseDatabase.getInstance().reference

    var list = ArrayList<MountainModal>()
    lateinit var categoryName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCategorieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {


        if (intent!=null){
            categoryName = intent.getStringExtra("puravish").toString()
           binding.txttext.text = categoryName
            if (categoryName == "mountain"){
                mountain()
            }
            else if (categoryName == "forast"){
                forast()
            }
            else if (categoryName == "himalay"){
                himalay()
            }
            else if (categoryName == "sea"){
                sea()
            }

        }

    }

    private fun sea() {


        reference.root.child("SeaTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModal? = child.getValue(MountainModal::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategoryActivity,list, onItemClick = {
                    place: String, Location: String, Price: String, Rate: String, Image: String, Key: String ->
                    var i = Intent(this@CategoryActivity,SameDetalisActivity::class.java)
                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",Image)
                    i.putExtra("key",Key)

                    startActivity(i)
                })

                var manager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })



    }

    private fun himalay() {



        reference.root.child("HimalyTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModal? = child.getValue(MountainModal::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategoryActivity,list, onItemClick = {
                        place: String, Location: String, Price: String, Rate: String, Image: String, Key: String ->

                    var i = Intent(this@CategoryActivity,SameDetalisActivity::class.java)

                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",Image)
                    i.putExtra("key",Key)

                    startActivity(i)
                })
                var manager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })




    }

    private fun forast() {


        reference.root.child("ForestTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModal? = child.getValue(MountainModal::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategoryActivity,list, onItemClick = {
                        place: String, Location: String, Price: String, Rate: String, Image: String, Key: String ->

                    var i = Intent(this@CategoryActivity,SameDetalisActivity::class.java)
                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",Image)
                    i.putExtra("key",Key)
                    startActivity(i)
                })
                var manager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }

    private fun mountain() {

        reference.root.child("MountainTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModal? = child.getValue(MountainModal::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategoryActivity,list, onItemClick = {
                        place: String, Location: String, Price: String, Rate: String, Image: String, Key: String ->

                    var i = Intent(this@CategoryActivity,SameDetalisActivity::class.java)

                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",Image)
                    i.putExtra("key",Key)

                    startActivity(i)
                })
                var manager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}