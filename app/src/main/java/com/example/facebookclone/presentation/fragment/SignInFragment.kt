package com.example.facebookclone.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.facebookclone.R
import com.example.facebookclone.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var mBinding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSignInBinding.inflate(inflater, container, false)
        mBinding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAction()
    }

    private fun initAction() {
        mBinding.buttonCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

    }
}