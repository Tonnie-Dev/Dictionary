package com.plcoding.dictionary.feature_dictionary.data.remote.dto

import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WordInfoDTO(
    val meanings: List<MeaningDTO>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDTO>?,
    val word: String
){

    fun  toWordInfoEntity():WordInfoEntity{

        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word =word
        )
    }


}