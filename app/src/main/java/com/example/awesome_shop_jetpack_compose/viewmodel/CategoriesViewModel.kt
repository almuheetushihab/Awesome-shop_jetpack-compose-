package com.example.awesome_shop_jetpack_compose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesome_shop_jetpack_compose.reposatories.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val categoriesRepository: CategoriesRepository) : ViewModel() {
    private val _items: MutableLiveData<List<String>> = MutableLiveData()
    val items: LiveData<List<String>> = _items

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getCategories() = viewModelScope.launch {
        _isLoading.value = true
        try {
            _items.value = categoriesRepository.getCategories()
        } catch (e: Exception) {
            _items.value = emptyList()
        } finally {
            _isLoading.value = false
        }
    }
}
