package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.dictionary.feature_dictionary.presentation.utils.UIEvent.OnHideKeyboard
import com.plcoding.dictionary.feature_dictionary.presentation.utils.UIEvent.OnShowSnackbar

@ExperimentalComposeUiApi
@Composable
fun WordInfoScreen(viewModel: WordInfoViewModel = hiltViewModel()) {

    //States
    val wordInfoState by viewModel.wordInfoState
    val lastTenWords by viewModel.lastTenWords
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()


    /*Launched Effect listen to events from the
     event flow that we have inside the ViewModel*/
    LaunchedEffect(key1 = true, block = {


        val uiEvent = viewModel.uiEvent.collect{ event ->

            when (event){

                is OnHideKeyboard -> {
                    keyboardController?.hide()

                }
                is OnShowSnackbar -> {

                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.msg,
                        actionLabel = event.action

                    )

                }
            }

        }
    })

    Scaffold(scaffoldState = scaffoldState, topBar = {}) {

   Surface() {
            

        }
    }


}