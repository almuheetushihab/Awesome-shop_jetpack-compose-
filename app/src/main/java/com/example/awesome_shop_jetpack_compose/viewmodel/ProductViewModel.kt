package com.example.awesome_shop_jetpack_compose.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponse
import com.example.awesome_shop_jetpack_compose.reposatories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _items: MutableLiveData<ProductsResponse?> by lazy {
        MutableLiveData<ProductsResponse?>()
    }
    val items: MutableLiveData<ProductsResponse?> = _items

    fun getProducts() = viewModelScope.launch {
        try {
            _items.value = productRepository.getProducts()
        } catch (e: Exception) {
            _items.value = null
        }

    }
}