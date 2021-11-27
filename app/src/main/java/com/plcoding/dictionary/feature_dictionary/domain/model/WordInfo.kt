package com.plcoding.dictionary.feature_dictionary.domain.model

import com.plcoding.dictionary.feature_dictionary.data.remote.dto.MeaningDTO
import com.plcoding.dictionary.feature_dictionary.data.remote.dto.PhoneticDTO

data class WordInfo(val meanings: List<Meaning>,
                    val origin: String,
                    val phonetic: String,
                    val word: String)
