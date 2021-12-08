package com.plcoding.dictionary.feature_dictionary.data.remote.dto

import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WordInfoDTO(
    val meanings: List<MeaningDTO>,
    val word: String

    //val origin: String? = null,
    //val phonetic: String? = null,
    //val phonetics: List<PhoneticDTO>,

)

fun WordInfoDTO.toWordInfoEntity(): WordInfoEntity {

    return WordInfoEntity(meanings = listOf(), origin = "", phonetic = "", word = "", id = null)

}





/*Null Check
*
*
*  if (phonetic === null || origin == null) {

        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = "origin: _ _",
            phonetic = "phonetic: _ _",
            word = word
        )

    } else {

        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )

    }
* */