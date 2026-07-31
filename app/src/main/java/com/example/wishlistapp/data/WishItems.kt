package com.example.wishlistapp.data

data class wishListItems(
    val wishname : String,
    val count : Int,
    val id: String = java.util.UUID.randomUUID().toString()
)
