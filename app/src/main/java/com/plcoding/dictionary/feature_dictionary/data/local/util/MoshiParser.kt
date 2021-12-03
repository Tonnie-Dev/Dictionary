package com.plcoding.dictionary.feature_dictionary.data.local.util

import com.google.gson.Gson
import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type




//JsonParser implementation
class GsonParser (private val gson: Gson):JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {

        return gson.fromJson(json,type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj,type)
    }
}
