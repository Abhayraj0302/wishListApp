package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "wish-table")
data class WishItem(

    @ColumnInfo(name = "wish-name")
    val wishname: String,

    @ColumnInfo(name = "wish-count")
    val count: Int,

    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
)
