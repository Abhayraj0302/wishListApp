package com.example.wishlistapp.data

data class WishListData(
    val wishListItems: List<WishItem> = listOf(
        WishItem("Get a CLS 63", 4),
        WishItem("Get a internship", 2),
        WishItem("Get a house", 7),
        WishItem("Get a GLS 63", 4),
        WishItem("Get a KAWASHAKI", 2),
        WishItem("Get a BIKE", 7),
    )
)
