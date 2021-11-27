package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhoneticDTO(
    val audio: String,
    val text: String
)