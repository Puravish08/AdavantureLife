package com.example.adventerlife.Fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adventerlife.Activity.ForestActivity
import com.example.adventerlife.Activity.HimalayActivity
import com.example.adventerlife.Activity.LoginActivity
import com.example.adventerlife.Activity.MountainActivity
import com.example.adventerlife.Activity.SeaActivity
import com.example.adventerlife.Activity.AdaminActivity
import com.example.adventerlife.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    lateinit var profileBinding: FragmentProfileBinding
    lateinit var firebaseDatabase: DatabaseReference
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        profileBinding = FragmentProfileBinding.inflate(layoutInflater)
        auth = Firebase.auth
        firebaseDatabase = FirebaseDatabase.getInstance().getReference()

        sharedPreferences =
            requireActivity().getSharedPreferences("MySharedPref", AppCompatActivity.MODE_PRIVATE)
        workingClass()
        return profileBinding.root
    }

    private fun workingClass() {

        profileBinding.btnLogOut.setOnClickListener {

            var myEdit: SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()
            auth.signOut()
            var intent = Intent(context, LoginActivity::class.java)
            Toast.makeText(context, "Successfully Logged Out", Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }

        profileBinding.txtAdmin.setOnClickListener {

            var intent = Intent(context, AdaminActivity::class.java)
            startActivity(intent)
        }
        profileBinding.txtMountain.setOnClickListener {
            var i=Intent(context,MountainActivity::class.java)
            startActivity(i)
        }
      profileBinding.txtForest.setOnClickListener {
            var i=Intent(context,ForestActivity::class.java)
            startActivity(i)
        }
      profileBinding.txtHimalay.setOnClickListener {
            var i=Intent(context,HimalayActivity::class.java)
            startActivity(i)
        }
      profileBinding.txtSea.setOnClickListener {
            var i=Intent(context,SeaActivity::class.java)
            startActivity(i)
        }


        auth.currentUser?.let {
            firebaseDatabase.child("user").child(it.uid)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var name = snapshot.child("name").value.toString()
                        var address = snapshot.child("address").value.toString()
                        var age = snapshot.child("age").value.toString()
                        var city = snapshot.child("city").value.toString()
                        var phone = snapshot.child("phone").value.toString()
                        var email = snapshot.child("email").value.toString()

                        var image = snapshot.child("images").value.toString()

                        Log.e("USERRR", "onDataChange: " + image)
//                        profileBinding.txtname.setText(name)
//                        profileBinding.txtPhone.setText(phone)
//                        profileBinding.txtAddress.setText(address)
//                        profileBinding.txtCity.setText(city)
//                        profileBinding.txtEmail.setText(email)
//                        Glide.with(this@ProfileFragment).load(image).into(profileBinding.imgImage)

                    }

                    override fun onCancelled(error: DatabaseError) {
                    }
                })
        }


    }

}