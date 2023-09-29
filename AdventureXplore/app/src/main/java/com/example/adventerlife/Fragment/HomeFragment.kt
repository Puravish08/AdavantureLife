package com.example.adventerlife.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adventerlife.Activity.CategoryActivity
import com.example.adventerlife.Activity.ItemDetailActivity
import com.example.adventerlife.Adapter.AdapterClass
import com.example.adventerlife.ModelClass.HomeModel
import com.example.adventerlife.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    private var Binding: FragmentHomeBinding? = null
    private lateinit var auth: FirebaseAuth
    private val binding get() = Binding
    var list = arrayListOf<Int>()

    private lateinit var firebaseDatabase: DatabaseReference
    private lateinit var dataList: ArrayList<HomeModel>
    private lateinit var adapter: AdapterClass

    private val databaseReference = FirebaseDatabase.getInstance().getReference("AllDataTb")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding?.root


        firebaseDatabase = FirebaseDatabase.getInstance().getReference()
        auth = Firebase.auth


        Admin()
        initview()
        return view
    }

    private fun Admin() {
        var refrence = FirebaseDatabase.getInstance().reference
        var list = ArrayList<HomeModel>()

        refrence.root.child("AllDataTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: HomeModel? = child.getValue(HomeModel::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                dataList = ArrayList()
                 adapter = AdapterClass(requireContext(), ArrayList())
                { place: String, Price: String, img: String, key: String ->

                    var i = Intent(context, ItemDetailActivity::class.java)

                    i.putExtra("place", place)
                    i.putExtra("price", Price)
                    i.putExtra("img", img)
                    i.putExtra("key", key)
                    startActivity(i)

                }
                var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding?.rcv?.layoutManager = manager
                binding?.rcv?.adapter = adapter

//                adapter = AdapterClass(requireContext(), ArrayList()){ place, price, img, key ->
//
//                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })



        val searchView: SearchView? = binding?.searchhome
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle search query submission here
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Filter the data based on the search query and update the RecyclerView
                val query = newText?.toLowerCase().toString()
                val filteredList = dataList.filter { item -> item.palce.contains(query, ignoreCase = true) }
                adapter.setData(filteredList)
                return true
            }
        })

        // Fetch data from Firebase
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataList.clear()

                for (snapshot in dataSnapshot.children) {
                    val dataItem = snapshot.getValue(HomeModel::class.java)
                    dataItem?.let {
                        dataList.add(it)
                    }
                }

                adapter.setData(dataList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error here
            }
        })


    }

    private fun initview() {

        Binding?.imgMountain?.setOnClickListener {

            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("puravish", "mountain")
            startActivity(i)
        }
        Binding?.imgsea?.setOnClickListener {

            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("puravish", "sea")
            startActivity(i)
        }
        Binding?.imghmalay?.setOnClickListener {

            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("puravish", "himalay")
            startActivity(i)
        }
        Binding?.imgforast?.setOnClickListener {

            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("puravish", "forast")
            startActivity(i)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Binding = null
    }
}
