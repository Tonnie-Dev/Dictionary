package com.plcoding.dictionary.feature_dictionary.data.local.util

import com.google.gson.Gson
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class MoshiParser (private val moshi: Moshi):JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {
        TODO("Not yet implemented")
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        TODO("Not yet implemented")
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