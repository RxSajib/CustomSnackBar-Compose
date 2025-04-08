package com.net.examplescreen.component

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Details(
    var details: String? = null,
    val title: String? = null,
    val show : Boolean = false,
    val leftIcon : Int? = null
)

object Event {

    private val _state = MutableStateFlow<Details>(Details())
    val state = _state.asStateFlow()

    fun save(details: Details){
        _state.value = details
    }
}