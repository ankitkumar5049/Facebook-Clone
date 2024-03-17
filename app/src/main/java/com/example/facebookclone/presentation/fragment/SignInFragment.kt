package com.example.facebookclone.presentation.fragment

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.facebookclone.R
import com.example.facebookclone.databinding.FragmentSignInBinding
import com.example.facebookclone.presentation.base.BaseFragment
import com.google.android.gms.auth.api.credentials.Credential
import com.google.android.gms.auth.api.credentials.Credentials
import com.google.android.gms.auth.api.credentials.CredentialsClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    private lateinit var auth: FirebaseAuth
    private lateinit var credentialClient: CredentialsClient
    val launcher = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val credential: Credential? = it.data?.getParcelableExtra(Credential.EXTRA_KEY)

            credential.apply {
                val phoneNumber = this?.id?.substring(3)
                binding.editTextUsername.setText(phoneNumber)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        credentialClient = Credentials.getClient(requireContext())
        auth = Firebase.auth
        initAction()
        showLog("Sign in frag")
        launchPhoneHint()
    }

    private fun launchPhoneHint() {
        val intent = getPhoneHintIntent(activity as FragmentActivity)
        launcher.launch(IntentSenderRequest.Builder(intent).build())
    }

    private fun initAction() {
        binding.buttonLogin.setOnClickListener {
            userSignIn()
        }
        binding.buttonCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

    }

    private fun userSignIn(){
        auth.signInWithEmailAndPassword(binding.editTextUsername.text.toString(), binding.editTextPassword.text.toString())
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_signInFragment_to_newsFeedFragment)
                    // Sign in success, update UI with the signed-in user's information
                    showLog("signInWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    showLog("signInWithEmail:failure")
                    showToast("Authentication failed.")
                }
            }
    }
}