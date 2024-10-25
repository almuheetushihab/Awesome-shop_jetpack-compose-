package com.example.awesome_shop_jetpack_compose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.reposatories.CategoryWiseProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryWiseProductViewModel @Inject constructor(
    private val categoryWiseProductRepository: CategoryWiseProductRepository
) : ViewModel() {

    private val _items = MutableLiveData<List<ProductsResponseItem>?>()
    val items: LiveData<List<ProductsResponseItem>?> = _items

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getCategoryWiseProducts(category: String) = viewModelScope.launch {
        _isLoading.value = true
        try {
            _items.value = categoryWiseProductRepository.getCategoryWiseProducts(category)
        } catch (e: Exception) {
            _items.value = null
        } finally {
            _isLoading.value = false
        }
    }
}
