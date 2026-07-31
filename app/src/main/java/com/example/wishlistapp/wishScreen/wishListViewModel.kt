package com.example.wishlistapp.wishScreen

import androidx.lifecycle.ViewModel
import com.example.wishlistapp.data.wishListItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class wishlistViewModel() : ViewModel(){
    private val  _wistUiState = MutableStateFlow(WishUiState())
    val wishUiState = _wistUiState.asStateFlow()

    fun onWishEvent(event : AddWishEvent){
        when(event){
            is AddWishEvent.SaveWish -> {
                val wish = wishListItems(
                    count = wishUiState.NumberOfItem,
                )
            }
        }
    }

}