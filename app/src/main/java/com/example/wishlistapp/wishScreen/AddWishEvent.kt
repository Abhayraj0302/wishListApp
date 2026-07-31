package com.example.wishlistapp.wishScreen

sealed class AddWishEvent {
    data object SaveWish : AddWishEvent()
}
