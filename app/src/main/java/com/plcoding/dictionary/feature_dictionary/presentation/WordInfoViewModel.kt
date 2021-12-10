package com.plcoding.dictionary.feature_dictionary.presentation

import android.provider.Contacts
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(private val useCase: GetWordInfo) :
    ViewModel() {

    //STATES
    var searchQuery = mutableStateOf("")
        private set

    var state = mutableStateOf(WordInfoState())
        private set

    var eventFlow = MutableSharedFlow<UIEvent>()
        private set


    //job to manage coroutines
    private var searchJob: Job? = null

    /*everytime we type a character we trigger this function to make a request
    to the corresponding src (db or api) to get the result*/
    fun onSearch(query: String) {

        //update query state
        searchQuery.value = query

        Timber.i("Query is: $query")
        //cancel current coroutine job when we type a new character
        searchJob?.cancel()

        //launch new job to execute the request
        searchJob = viewModelScope.launch {

            //we need some time to allow character typing hence we create a delay

            /*if within a half second we type another character onSearch is called
            * again the old running job and wait for another half second until there
            * is 500 ms in which we did not type a character then the search is
            * executed*/
            delay(500L)


            //call use case and listen to each flow emission
            useCase(query).onEach {

                    result ->

                when (result) {

                    is Resource.Success -> {

                       state.value = state.value.copy(
                            wordInfoItems = result.data ?: emptyList(),
                            isLoading = false
                        )
                         eventFlow.emit(UIEvent.HideKeyboard)

                    }

                    is Resource.Error -> {

                        /*here we show the same info as success as we may still get
                            data from the db to show to the UI*/

                        state.value = state.value.copy(
                            wordInfoItems = result.data ?: emptyList(),
                            isLoading = false
                        )



                        eventFlow.emit(UIEvent.HideKeyboard)
                        //show
                        eventFlow.emit(UIEvent.ShowSnackbar(result.message?: "Unknown error"))


                    }
                    is Resource.Loading -> {



                        state.value = state.value.copy(
                            //we might also have some data to display
                            wordInfoItems = result.data ?: emptyList(),
                            isLoading = true
                        )
                    }
                }
                //this refers to the current ViewModelScope
            }.launchIn(this)
        }
    }



    fun onTagClick(synonym:String){

        searchQuery.value = synonym

    }

    //EVENT FLOW

    sealed class UIEvent {

       data class ShowSnackbar(val message: String) : UIEvent()
        object HideKeyboard:UIEvent()
       data class TagClicked(val synonym:String):UIEvent()

    }
}