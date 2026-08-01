package com.example.wishlistapp.graphs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.wishlistapp.data.WishDataBase
import com.example.wishlistapp.data.WishRepository

object Graph {
    lateinit var database: WishDataBase

    val wishRepository by lazy {
        WishRepository(database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDataBase::class.java , "wishListDB").build()
    }
}