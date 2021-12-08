package com.plcoding.dictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

@Entity(tableName = "wordinfoentity")
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val word: String,
    @PrimaryKey
    val id: Int? = null

/* val origin: String,
    val phonetic: String,*/
) {

    //helper method to convert entity to the model class
    fun toWordInfo(): WordInfo {

        return WordInfo(
            meanings = meanings,
            word = word

        /*origin = origin,
            phonetic = phonetic,*/
        )
    }
}
