package com.aditya.netclan.model

data class User(
    val name: String? = null,
    val acronymName: String? = null,
    val city: String? = null,
    val position: String? = null,
    val purposes: List<String>? = emptyList(),
    val status: String? = null,
    val about: String? = null,
    val distanceRange: String? = null,
    val image: Int? = null,

)
