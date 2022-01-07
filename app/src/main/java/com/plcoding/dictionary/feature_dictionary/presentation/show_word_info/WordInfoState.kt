package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info

import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
