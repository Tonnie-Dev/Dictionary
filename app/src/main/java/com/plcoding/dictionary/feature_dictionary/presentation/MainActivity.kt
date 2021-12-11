package com.plcoding.dictionary.feature_dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.*


import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.dictionary.feature_dictionary.presentation.components.CustomSearchTextField
import com.plcoding.dictionary.feature_dictionary.presentation.ui.theme.DictionaryTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("oncreate() called here")
        setContent {
            DictionaryTheme {


                //get reference to viewModel, state and scaffold state

                val viewModel: WordInfoViewModel = hiltViewModel()
                val state by viewModel.state
                val scaffoldState = rememberScaffoldState()
                val keyboardController = LocalSoftwareKeyboardController.current

/*You can perform some action on state changes and you can do it
using the side effects.For example you can use the LaunchedEffect
function, where as a key you can pass a state you want to listen.*/


                /*This will be needed to actually listen to events from the
                event flow that we have inside the ViewModel*/

                LaunchedEffect(key1 = true, block = {

                    viewModel.eventFlow.collectLatest {

                            event ->

                        when (event) {

                            is WordInfoViewModel.UIEvent.ShowSnackbar -> {

                                scaffoldState.snackbarHostState.showSnackbar(event.message)

                            }

                            is WordInfoViewModel.UIEvent.HideKeyboard -> {

                                keyboardController?.hide()

                            }

                            is WordInfoViewModel.UIEvent.TagClicked -> run {

                       viewModel::onTagClick
                            }

                            is WordInfoViewModel.UIEvent.ClearIconClicked -> run {

                                viewModel::onClearIconClick
                            }
                        }
                    }
                })


                Scaffold(scaffoldState = scaffoldState) {


                    Box(modifier = Modifier.background(color = MaterialTheme.colors.background)) {

                        Surface(color = MaterialTheme.colors.surface, elevation = 10.dp) {
                            Column(
                                modifier = Modifier
                                        .fillMaxSize().padding(horizontal = 8.dp)

                            ) {


                                CustomSearchTextField(value = viewModel.searchQuery.value,
                                    onValueChange = viewModel::onSearch, viewModel::onClearIconClick)


                                Spacer(modifier = Modifier.height(16.dp))



                                LazyColumn(modifier = Modifier.fillMaxSize()) {

                                    items(count = state.wordInfoItems.size) { i ->

                                        val wordInfo = state.wordInfoItems[i]

                                        //add a spacer for every item apart from the first item
                                        if (i > 0) {

                                            Spacer(modifier = Modifier.height(8.dp))
                                        }



                                        WordInfoItem(wordInfo = wordInfo,

                                            onClickTag =viewModel::onSearch)

                                        //add a spacer for every item apart from the last item
                                        if (i < state.wordInfoItems.size - 1) {

                                            Divider()
                                        }

                                    }


                                }

                            }
                            if (state.isLoading) {

                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }
                        }



                    }
                }

            }
        }
    }
}