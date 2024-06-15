package com.example.myfirstproject.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstproject.data.ShopListRepositoryImpl
import com.example.myfirstproject.domain.DeleteShopItemUseCase
import com.example.myfirstproject.domain.EditShopItemUseCase
import com.example.myfirstproject.domain.GetShopListUseCase
import com.example.myfirstproject.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enebled = !shopItem.enebled)
        editShopItemUseCase.editShopItem(newItem)
    }
}