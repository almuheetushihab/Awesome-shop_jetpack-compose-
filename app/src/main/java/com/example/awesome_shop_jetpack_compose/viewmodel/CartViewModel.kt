package com.example.awesome_shop_jetpack_compose.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.reposatories.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartRepository: CartRepository) : ViewModel() {
    val items = MutableLiveData<List<ProductsResponseItem>>()

    fun cartData(cartId: Int) {
        viewModelScope.launch {
            val response = cartRepository.getCart(cartId)
            if (response.isSuccessful) {

                val cartResponse = response.body()

                cartResponse?.let { cart ->
                    val productList = ArrayList<ProductsResponseItem>()

                    for (cartProduct in cart.products) {
                        val productResponse = cartRepository.getProductById(cartProduct.productId)
                        if (productResponse.isSuccessful) {
                            productResponse.body()?.let { product ->
                                productList.add(product)
                            }
                        }
                    }
                    items.postValue(productList)
                }
            }
        }
    }
}


