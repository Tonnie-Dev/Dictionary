package com.plcoding.dictionary.feature_dictionary.data.remote.dto

import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WordInfoDTO(
    val meanings: List<MeaningDTO>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDTO>,
    val word: String
){

    fun  toWordInfo():WordInfo{

        return WordInfo(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word =word
        )
    }
}