package com.example.facebookclone.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.facebookclone.R
import com.example.facebookclone.databinding.FragmentSignUpBinding
import com.example.facebookclone.presentation.base.BaseFragment
import com.example.facebookclone.util.GeneralUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    private lateinit var auth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        initAction()
    }

    private fun initAction() {
        binding.apply {
            tvDob.setOnClickListener {
                GeneralUtils.showDatePickerDialog(requireContext(),tvDob)
            }

            btnSignUp.setOnClickListener {
                if(validate()) {
                    userAuth()
                }
            }

        }
    }


    private fun validate(): Boolean{
        if(binding.edtEmail.text.toString().isEmpty()){
            showToast("Enter email address")
            return false
        }
        else if(binding.edtPassword.text.toString().isEmpty() || binding.edtPassword.text.toString()!=binding.edtConfirmPassword.text.toString()){
            showToast("Enter valid password")
            return false
        }
        return true
    }

    private fun userAuth(){
        auth.createUserWithEmailAndPassword(binding.edtEmail.text.toString(), binding.tvPassword.text.toString())
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    showLog("createUserWithEmail:success")
                    findNavController().navigate(R.id.action_signUpFragment_to_newsFeedFragment)
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    showLog(binding.edtEmail.toString())
                    showLog("createUserWithEmail:failure")
                    showToast("Authentication failed.")
                }
            }
    }

}