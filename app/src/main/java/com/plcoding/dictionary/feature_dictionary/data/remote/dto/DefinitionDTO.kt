package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.plcoding.dictionary.feature_dictionary.domain.model.Definition
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DefinitionDTO(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
){

    fun toDefinition():Definition{

        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}