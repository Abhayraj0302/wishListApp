package com.example.wishlistapp.home

import com.example.wishlistapp.data.wishListItems

sealed interface  HomeEvent{
    data class DeleteWish(
        val wish : wishListItems
    ) : HomeEvent
}