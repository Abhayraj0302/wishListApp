package com.example.wishlistapp.WishViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.addwish.AddWishEvent
import com.example.wishlistapp.addwish.AddWishUiState
import com.example.wishlistapp.data.WishItem
import com.example.wishlistapp.data.WishListData
import com.example.wishlistapp.data.WishRepository
import com.example.wishlistapp.graphs.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WishlistViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(WishListData())
    val uiState = _uiState.asStateFlow()
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

    lateinit var getAllWishes : Flow<List<WishItem>>

    init {
        viewModelScope.launch {
            wishRepository.GetAllWish().collect { wishes ->
                _uiState.update { it.copy(wishListItems = wishes) }
            }
        }
    }

    fun addWish(wish: WishItem){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAwish(wish)
        }
    }
    fun deleteWish(wish: WishItem){
        viewModelScope.launch {
            wishRepository.DeleteAWish(wish)
        }
    }
    fun resetAddWishState(){
        _addWishUiState.update { AddWishUiState() }
    }
    companion object {
        val Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                WishlistViewModel(Graph.wishRepository) as T
        }
    }
}