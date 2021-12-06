package com.plcoding.dictionary.feature_dictionary.domain.model

import com.squareup.moshi.JsonClass


data class Definition (   val antonyms: List<String>,
                     val definition: String,
                     val example: String?,
                     val synonyms: List<String>) {


}