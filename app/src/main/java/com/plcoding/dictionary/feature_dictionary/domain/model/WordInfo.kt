package com.plcoding.dictionary.feature_dictionary.domain.model

import com.plcoding.dictionary.feature_dictionary.data.remote.dto.MeaningDTO
import com.plcoding.dictionary.feature_dictionary.data.remote.dto.PhoneticDTO
import com.squareup.moshi.JsonClass


data class WordInfo(
    val meanings: List<Meaning>,
    val word: String
)
/*  val origin: String,
  val phonetic: String,*/