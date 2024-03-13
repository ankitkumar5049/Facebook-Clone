package com.example.facebookclone.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.facebookclone.databinding.FragmentSignUpBinding
import com.example.facebookclone.presentation.base.BaseFragment
import com.example.facebookclone.util.GeneralUtils

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAction()
    }

    private fun initAction() {
        binding.apply {
            tvDob.setOnClickListener {
                GeneralUtils.showDatePickerDialog(requireContext(),tvDob)
            }

        }
    }

}