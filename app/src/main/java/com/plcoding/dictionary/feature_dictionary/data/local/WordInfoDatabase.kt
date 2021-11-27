package com.plcoding.dictionary.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [WordInfoDatabase::class], version = 1)
abstract class WordInfoDatabase : RoomDatabase() {

    abstract val wordDAO:WordDAO
}