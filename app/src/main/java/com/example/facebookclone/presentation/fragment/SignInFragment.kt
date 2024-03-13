package com.example.facebookclone.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.facebookclone.R
import com.example.facebookclone.databinding.FragmentSignInBinding
import com.example.facebookclone.presentation.base.BaseFragment

class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAction()
        showLog("Sign in frag")
    }

    private fun initAction() {
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_newsFeedFragment)
        }
        binding.buttonCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

    }
}