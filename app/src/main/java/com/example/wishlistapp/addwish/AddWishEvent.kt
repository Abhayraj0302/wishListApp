package com.example.wishlistapp.addwish

sealed interface AddWishEvent {
    data object SaveWish : AddWishEvent

    data class WishNameChanged(
        val name : String
    ) : AddWishEvent

    data class NumberOfItemChanged(
        val count : String
    ) : AddWishEvent
}
