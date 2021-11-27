package com.plcoding.dictionary.feature_dictionary.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {

    @GET(value = "/api/v2/entries/en/{word}")
    suspend fun getWordInfo(@Path(value = "word") word:String)
}