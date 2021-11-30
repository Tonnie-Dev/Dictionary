package com.plcoding.dictionary.feature_dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.dictionary.feature_dictionary.presentation.ui.theme.DictionaryTheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictionaryTheme {


                //get reference to viewModel, state and scaffold state

                val viewModel: WordInfoViewModel = hiltViewModel()
                val state by viewModel.state
                val scaffoldState = rememberScaffoldState()

                /*This will be needed to actually listen to events from the
                event flow that we have inside the ViewModel*/

                LaunchedEffect(key1 = true, block = {

                    viewModel.eventFlow.collectLatest {

                        event ->

                        when(event){


                            is WordInfoViewModel.UIEvent.ShowSnackbar -> {

                                scaffoldState.snackbarHostState.showSnackbar(event.message)
                            }
                        }
                    }
                })


                Scaffold(scaffoldState = scaffoldState) {


                    Box(modifier = Modifier.background(color = MaterialTheme.colors.background)){



                    }
                }

            }
        }
    }
}