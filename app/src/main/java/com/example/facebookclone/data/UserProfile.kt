package com.example.facebookclone.data

data class UserName(
    var first: String = "",
    var last: String = ""
) {
    val full: String
        get() {
            return ("${first.trim()} ${last.trim()}")
        }

    var fullName: String = full
}

data class UserProfile(
    var name: UserName = UserName(),
    var birthDate: String = "",
    var gender: String = "",
    var email: String = "",
    var mobileNumber: String = ""
)