package com.plcoding.dictionary.feature_dictionary.data.local.util

import com.google.gson.Gson
import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type

class MoshiParser ():JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {
        val moshi:Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

      /*  //val jsonAdapter: JsonAdapter<T> = moshi.adapter()*/

        //return jsonAdapter.fromJson(json)

    }

    override fun <T> toJson(obj: T, type: Type): String? {

        val moshi:Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val jsonAdapter: JsonAdapter<String> = moshi.adapter(String::class.java)

        return jsonAdapter.toJson(obj.toString())

    }
}


/*
* //JsonParser implementation
class MoshiParser (private val gson: Gson):JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {

        return gson.fromJson(json,type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj,type)
    }
}
*
* */