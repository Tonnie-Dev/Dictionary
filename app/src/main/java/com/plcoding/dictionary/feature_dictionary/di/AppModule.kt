package com.plcoding.dictionary.feature_dictionary.di

import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)



@Provides
fun providesRoomDatabase() :RoomDatabase{



}


@Provides
fun provideDictionaryAPI() :