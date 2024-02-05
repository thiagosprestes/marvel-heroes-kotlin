package com.example.marvelapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.entity.Hero
import com.example.marvelapp.ui.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    private val _heroes: MutableStateFlow<ResourceState<List<Hero>>> =
        MutableStateFlow(ResourceState.Loading())
    val heroes: StateFlow<ResourceState<List<Hero>>> = _heroes

    init {
        getHeroes()
    }

    private fun getHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            homeRepository.getHeroes().collectLatest { response ->
                _heroes.value = response
            }
        }
    }

    companion object {
        const val TAG = "HomeViewModel"
    }
}
