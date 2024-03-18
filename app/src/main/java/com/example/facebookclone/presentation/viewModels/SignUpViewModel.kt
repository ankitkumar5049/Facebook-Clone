package com.example.facebookclone.presentation.viewModels

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import com.example.facebookclone.data.UserProfile

class SignUpViewModel : ViewModel() {
    var updatedUserData = UserProfile()

    fun isDetailsCompleted(): Boolean {
        return updatedUserData.name.first.isNotEmpty() &&
                updatedUserData.name.first.isNotBlank() &&
                updatedUserData.name.last.isNotEmpty() &&
                updatedUserData.name.last.isNotBlank() &&
                updatedUserData.birthDate.isNotEmpty() &&
                updatedUserData.birthDate.isNotBlank() &&
                updatedUserData.gender.isNotEmpty() &&
                updatedUserData.gender.isNotBlank() &&
                updatedUserData.email.isNotEmpty() &&
                updatedUserData.email.isNotBlank() &&
                updatedUserData.mobileNumber.isNotEmpty() &&
                updatedUserData.mobileNumber.isNotBlank()
    }

    fun validatePhoneNumber(): Boolean {
        val mobileNumber = updatedUserData.mobileNumber
        val isAllDigits = mobileNumber.all {
            it.isDigit()
        }
        return (mobileNumber.length == 10) && isAllDigits
    }

    fun validateEmailAddress():Boolean{
        val email = updatedUserData.email
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}