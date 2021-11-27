package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeaningDTO(
    val definitions: List<DefinitionDTO>,
    val partOfSpeech: String
)