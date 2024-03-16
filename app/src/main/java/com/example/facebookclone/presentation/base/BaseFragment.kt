package com.example.facebookclone.presentation.base

import android.app.PendingIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.google.android.gms.auth.api.credentials.Credentials
import com.google.android.gms.auth.api.credentials.CredentialsOptions
import com.google.android.gms.auth.api.credentials.HintRequest
import com.google.android.material.snackbar.Snackbar


open class BaseFragment<VBinding : ViewBinding>(
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> VBinding
) : Fragment() {

    private var _binding: VBinding? = null
    val binding: VBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateMethod.invoke(inflater, container, false)
        return binding.root

    }

    open fun getPhoneHintIntent(activity: FragmentActivity): PendingIntent {
        val hintRequest = HintRequest.Builder()
            .setPhoneNumberIdentifierSupported(true)
//            .setEmailAddressIdentifierSupported(true)
            .build()
        val options = CredentialsOptions.Builder()
            .forceEnableSaveDialog()
            .build()
        return Credentials.getClient(activity, options).getHintPickerIntent(hintRequest)
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    fun showSnackbar(view: View, message: String) {
        Snackbar.make(requireContext(), view, message, Snackbar.LENGTH_SHORT).show()
    }

    fun showLog(message: String) {
        Log.i("DEV", "showLog: $message")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
