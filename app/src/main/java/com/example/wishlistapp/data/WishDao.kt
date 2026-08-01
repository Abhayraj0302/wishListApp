package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Query("Select * from `wish-table`")
    abstract fun getAllWish() : Flow<List<WishItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun AddWish(wishItemEntity : WishItem)

    @Delete
    abstract suspend fun DeleteWish(wishItemEntity: WishItem)
}