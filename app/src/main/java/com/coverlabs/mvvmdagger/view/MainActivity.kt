package com.coverlabs.mvvmdagger.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.coverlabs.mvvmdagger.R
import com.coverlabs.mvvmdagger.di.DaggerMVVMDaggerComponent
import com.coverlabs.mvvmdagger.model.User
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMVVMDaggerComponent.create().inject(this)

        val db = FirebaseFirestore.getInstance()

        val user = HashMap<String, Any>()
        user["name"] = mUser.name
        user["age"] = mUser.age

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference -> Log.d("MainActivity", "DocumentSnapshot added with ID: " + documentReference.id) }
                .addOnFailureListener { e -> Log.w("MainActivity", "Error adding document", e) }
    }
}
