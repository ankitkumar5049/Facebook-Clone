package com.example.facebookclone.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.facebookclone.R
import com.example.facebookclone.databinding.ActivityMainBinding
import com.example.facebookclone.presentation.fragment.SignInFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = SignInFragment()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }
}