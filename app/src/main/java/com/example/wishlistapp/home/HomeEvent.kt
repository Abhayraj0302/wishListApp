package com.example.wishlistapp.home

import com.example.wishlistapp.data.WishItem

sealed interface HomeEvent {
    data class DeleteWish(
        val wish: WishItem
    ) : HomeEvent
}
