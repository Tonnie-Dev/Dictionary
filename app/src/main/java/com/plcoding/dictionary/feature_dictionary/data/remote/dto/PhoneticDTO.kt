package com.plcoding.dictionary.feature_dictionary.data.remote.dto


import com.plcoding.dictionary.feature_dictionary.domain.model.Phonetic


data class PhoneticDTO(
    val audio: String,
    val text: String
){

    fun toPhonetic(): Phonetic {

        return Phonetic(
            audio = audio,
            text = text
        )
    }
}