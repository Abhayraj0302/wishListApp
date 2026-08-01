package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    suspend fun addAwish(wish : WishItem){
        wishDao.AddWish(wish)
    }

    fun GetAllWish() : Flow<List<WishItem>> = wishDao.getAllWish()

    suspend fun DeleteAWish(wish : WishItem){
        wishDao.DeleteWish(wish)
    }
}