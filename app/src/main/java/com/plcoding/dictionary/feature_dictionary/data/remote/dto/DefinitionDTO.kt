package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DefinitionDTO(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
)