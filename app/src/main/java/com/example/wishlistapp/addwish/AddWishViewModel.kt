package com.example.wishlistapp.addwish

import androidx.lifecycle.ViewModel
import com.example.wishlistapp.data.WishItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddWishViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AddWishUiState())
    val uiState = _uiState.asStateFlow()

    fun onWishEvent(event: AddWishEvent) {
        when (event) {
            is AddWishEvent.SaveWish -> {
                val wish = WishItem(
                    wishname = uiState.value.WishName,
                    count = uiState.value.NumberOfItem.toIntOrNull() ?: 0
                )
            }
        }
    }
}
