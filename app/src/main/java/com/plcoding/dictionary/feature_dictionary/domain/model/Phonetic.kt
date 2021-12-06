package com.plcoding.dictionary.feature_dictionary.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Phonetic( val audio: String,
                     val text: String)
