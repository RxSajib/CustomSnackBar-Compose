package com.net.examplescreen.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class ScreenTwoViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableSharedFlow<String>()
    val state = _state.asSharedFlow()

    fun saveNumber(number : String){
        viewModelScope.launch {
            _state.emit(number)
        }
    }
}