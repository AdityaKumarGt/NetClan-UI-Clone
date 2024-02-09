package com.aditya.netclan.model

data class BusinessUser(
    val name: String? = null,
    val acronymName: String? = null,
    val image: Int? = null,
    val city: String? = null,
    val distanceRange: String? = null,
    val position: List<String>? = emptyList(),
    val status: String? = null,
    )
