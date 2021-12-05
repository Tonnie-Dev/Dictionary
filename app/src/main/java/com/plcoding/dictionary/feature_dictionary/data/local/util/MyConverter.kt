package com.plcoding.dictionary.feature_dictionary.data.local.util

import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MyConverter {

    private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val jsonAdapter: JsonAdapter<Meaning> = moshi.adapter(Meaning::class.java)

    fun fromJson(json: String):Meaning?{

      return  jsonAdapter.fromJson(json)

    }
    fun toJson(obj: T):String?{




        return jsonAdapter.toJson(meaning)
    }

}