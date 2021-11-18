package com.ssong_develop.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository : Repository
) : ViewModel() {

    fun test(){
        viewModelScope.launch {
            repository.load().collect {
                Log.d("helll",it.toString())
            }
        }
    }
}