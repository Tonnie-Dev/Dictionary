package com.plcoding.dictionary.feature_dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.ui.ExperimentalComposeUiApi

import com.plcoding.dictionary.feature_dictionary.presentation.show_word_info.WordInfoScreen
import com.plcoding.dictionary.feature_dictionary.presentation.ui.theme.DictionaryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

         DictionaryTheme {

             WordInfoScreen()

         }
        }
    }
}