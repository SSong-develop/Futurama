package com.ssong_develop.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.domain.entities.Characters
import com.ssong_develop.domain.repository.Repository
import com.ssong_develop.domain.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _characters: MutableStateFlow<Resource<List<Characters>>> = MutableStateFlow(
        Resource(
            Resource.Status.LOADING, null, null
        )
    )
    val characters: StateFlow<Resource<List<Characters>>>
        get() = _characters

    init {
        viewModelScope.launch {
            repository.load().collect {
                _characters.value = it
            }
        }
    }

}