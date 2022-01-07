package com.plcoding.dictionary.feature_dictionary.presentation.utils

sealed interface UIEvent {


    data class OnShowSnackbar(val msg:String, val action:String): UIEvent
    object OnHideKeyboard :UIEvent
}