package com.plcoding.dictionary.feature_dictionary.domain.model

import com.plcoding.dictionary.feature_dictionary.data.remote.dto.DefinitionDTO
import com.squareup.moshi.JsonClass


data class Meaning(val definitions: List<Definition>,
                   val partOfSpeech: String)
