package com.example.wishlistapp.home

import androidx.lifecycle.ViewModel
import com.example.wishlistapp.data.WishListData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(WishListData())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteWish -> {
                _uiState.update { curr ->
                    curr.copy(
                        wishListItems = curr.wishListItems
                            .filter { it != event.wish }
                    )
                }
            }
        }
    }
}
