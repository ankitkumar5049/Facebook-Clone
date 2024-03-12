package com.example.facebookclone.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.facebookclone.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var mBinding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        mBinding = fragmentBinding
        return fragmentBinding.root
    }

}