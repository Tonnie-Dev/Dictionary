package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetLastTenWords
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import com.plcoding.dictionary.feature_dictionary.presentation.show_word_info.WordInfoEvent.OnClearSearchText
import com.plcoding.dictionary.feature_dictionary.presentation.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(
    private val getWordInfoUseCase: GetWordInfo,
    private val getLastTenWordsUseCase: GetLastTenWords
) :
    ViewModel() {

    //STATES
    var searchQuery by mutableStateOf("")
        private set

    var wordInfoState = mutableStateOf(WordInfoState())
        private set

   /* var eventFlow = MutableSharedFlow<UIEvent>()
        private set*/

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var lastTenWords: MutableState<List<WordInfo>> = mutableStateOf(listOf())
        private set

    //job to manage coroutines
    private var searchJob: Job? = null



    init {
        getLastTenWords()
    }

    fun getLastTenWords() {

        getLastTenWordsUseCase().onEach {

                result ->

            when (result) {

                is Resource.Success -> {
                    lastTenWords.value = result.data?.distinct() ?: emptyList()

                }

                // TODO: 05-Jan-22 Implement Error and Loading
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }

            }
        }
                .launchIn(viewModelScope)
    }


    fun onWordInfoEvent(event: WordInfoEvent) {

        when (event) {

            is OnClearSearchText -> {

                searchQuery= ""
            }

            is WordInfoEvent.OnTagClick -> {

                searchQuery = event.synonym
                onSearch(searchQuery)
                getLastTenWords()
            }

            is WordInfoEvent.OnChipClick -> {
                searchQuery = event.word
                onSearch(searchQuery)
                getLastTenWords()

            }

            is WordInfoEvent.OnSearchTextChange -> {

                onSearch(event.text)

            }

        }

    }


    private fun sendUIEvents(event: UIEvent) {

        viewModelScope.launch {
            _uiEvent.send(event)

        }
    }

    /*everytime we type a character we trigger this function to make a request
      to the corresponding src (db or api) to get the result*/
    private fun onSearch(query: String) {

        //update query state
        searchQuery = query

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
            getWordInfoUseCase(query).onEach {

                    result ->

                when (result) {

                    is Resource.Success -> {

                        wordInfoState.value = wordInfoState.value.copy(
                            wordInfoItems = result.data ?: emptyList(),
                            isLoading = false
                        )
                        sendUIEvents(UIEvent.OnHideKeyboard)
getLastTenWords()
                    }

                    is Resource.Error -> {

                        /*here we show the same info as success as we may still get
                            data from the db to show to the UI*/

                        wordInfoState.value = wordInfoState.value.copy(
                            wordInfoItems = result.data ?: emptyList(),
                            isLoading = false
                        )



                        sendUIEvents(UIEvent.OnHideKeyboard)
                        sendUIEvents(UIEvent.OnShowSnackbar(msg = result.message ?: "Unknown Error", action = ""))



                    }
                    is Resource.Loading -> {
                        wordInfoState.value = wordInfoState.value.copy(
                            //we might also have some data to display
                            wordInfoItems = result.data ?: emptyList(),
                            isLoading = true
                        )


                    }
                }
                //this refers to the current ViewModelScope
            }
                    .launchIn(this)
        }
    }



}