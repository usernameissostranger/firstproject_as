package com.example.myfirstproject.domain

data class ShopItem (
    val name: String,
    val count: Int,
    val enebled: Boolean,
    var id: Int = UNDEFINDED_ID
) {

    companion object {
        const val UNDEFINDED_ID = -1
    }
}
