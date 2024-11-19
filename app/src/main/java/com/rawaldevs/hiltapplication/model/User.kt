package com.rawaldevs.hiltapplication.model


/**
 * @auther Somil Rawal
 * Created on 19-11-2023 at 19:56.
 * somil.rawal@gmail.com
 */
data class User(
    val id: Int? = null,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
    val termsAccepted: Boolean? = null
)
