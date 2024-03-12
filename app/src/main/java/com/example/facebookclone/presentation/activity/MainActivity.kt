package com.example.facebookclone.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.facebookclone.R
import com.example.facebookclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.title = getString(R.string.facebook)
        supportActionBar?.show()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}