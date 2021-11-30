package com.plcoding.dictionary.feature_dictionary.di

import androidx.room.RoomDatabase
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


object AppModule {


    @Provides
    @Singleton
    fun providesUseCase(repository: WordInfoRepository): GetWordInfo{

        return GetWordInfo(repo = repository)
    }
}


