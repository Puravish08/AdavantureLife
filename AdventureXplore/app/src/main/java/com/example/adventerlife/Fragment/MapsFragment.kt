package com.example.adventerlife.Fragment

import android.location.Address
import android.location.Geocoder
import androidx.fragment.app.Fragment

import androidx.appcompat.widget.SearchView
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adventerlife.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.io.IOException

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var searchView:     SearchView
    private var addedMarker: Marker? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_maps, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View?) {

        // Initializing our search view.
        searchView = view?.findViewById(R.id.idSearchView)!!

        // Obtain the SupportMapFragment and get notified
        // when the map is ready to be used.
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        // Adding a query listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val location = searchView.query.toString()
                var addressList: List<Address>? = null

                if (location != null || location == "") {
                    val geocoder = Geocoder(requireContext())
                    try {
                        addressList = geocoder.getFromLocationName(location, 1)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                    if (!addressList.isNullOrEmpty()) {
                        val address = addressList[0]
                        val latLng = LatLng(address.latitude, address.longitude)

                        Log.e(
                            "TAG",
                            "latitude:-  " + address.latitude + " " + "longitude:- " + address.longitude
                        )

                        addedMarker?.remove()
                        addedMarker = mMap.addMarker(MarkerOptions().position(latLng).title(location))
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))
                    }
                }

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                addedMarker?.remove()
                return false
            }
        })

        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {

        mMap = p0!!
    }

}