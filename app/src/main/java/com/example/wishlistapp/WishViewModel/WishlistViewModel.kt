package com.example.wishlistapp.WishViewModel

import androidx.lifecycle.ViewModel
import com.example.wishlistapp.addwish.AddWishEvent
import com.example.wishlistapp.addwish.AddWishUiState
import com.example.wishlistapp.data.WishItem
import com.example.wishlistapp.data.WishListData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WishlistViewModel : ViewModel() {

    // Controls the actual wishlist
    private val _uiState = MutableStateFlow(WishListData())
    val uiState = _uiState.asStateFlow()

    // Controls Add Wish screen input fields
    private val _addWishUiState = MutableStateFlow(AddWishUiState())
    val addWishUiState = _addWishUiState.asStateFlow()


    fun onWishEvent(event: AddWishEvent) {

        when (event) {

            is AddWishEvent.WishNameChanged -> {
                _addWishUiState.update {
                    it.copy(
                        wishName = event.name
                    )
                }
            }

            is AddWishEvent.NumberOfItemChanged -> {
                _addWishUiState.update {
                    it.copy(
                        numberOfItem = event.count
                    )
                }
            }

            else -> {}
        }
    }


    fun addWish(wish: WishItem) {

        _uiState.update { currentState ->

            currentState.copy(
                wishListItems = currentState.wishListItems + wish
            )
        }
        _addWishUiState.value = AddWishUiState()
    }


    fun deleteWish(wish: WishItem) {
        _uiState.update { currentState ->

            currentState.copy(
                wishListItems = currentState.wishListItems
                    .filter { it != wish }
            )
        }
    }
}