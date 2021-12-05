package com.plcoding.dictionary.feature_dictionary.data.remote

import com.plcoding.dictionary.feature_dictionary.data.remote.dto.WordInfoDTO
import com.plcoding.dictionary.feature_dictionary.data.remote.respponse.WordResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {

    @GET(value = "/api/v2/entries/en/{word}")
    suspend fun getWordInfo(@Path(value = "word") word:String):List<WordResponse>

    companion object{

        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
}