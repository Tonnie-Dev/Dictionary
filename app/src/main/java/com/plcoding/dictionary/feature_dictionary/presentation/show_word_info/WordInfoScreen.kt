package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel

@ExperimentalComposeUiApi
@Composable
fun WordInfoScreen(viewModel:WordInfoViewModel = hiltViewModel()) {

    //States
    val wordInfoState by viewModel.wordInfoState
    val lastTenWords by viewModel.lastTenWords
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()

}