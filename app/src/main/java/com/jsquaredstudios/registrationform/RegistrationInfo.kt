package com.jsquaredstudios.registrationform

import java.io.Serializable

data class RegistrationInfo(
    val title: String,
    val firstName: String,
    val lastName: String,
    val contactNumber: String,
    val email: String,
    val password: String
) : Serializable {

    fun getFullName() = "$title $firstName $lastName"
}



