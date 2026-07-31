package com.example.wishlistapp.addwish

sealed class AddWishEvent {
    data object SaveWish : AddWishEvent()
}
