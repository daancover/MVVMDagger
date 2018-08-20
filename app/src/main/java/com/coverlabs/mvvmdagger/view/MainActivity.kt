package com.coverlabs.mvvmdagger.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.coverlabs.mvvmdagger.R
import com.coverlabs.mvvmdagger.di.DaggerMVVMDaggerComponent
import com.coverlabs.mvvmdagger.model.User
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMVVMDaggerComponent.create().inject(this)
        tvName.text = "${mUser.name} ${mUser.age}"
    }
}
