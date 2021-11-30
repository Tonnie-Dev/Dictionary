package com.plcoding.dictionary.feature_dictionary.di

import androidx.room.RoomDatabase
import com.plcoding.dictionary.feature_dictionary.data.local.WordDAO
import com.plcoding.dictionary.feature_dictionary.data.remote.DictionaryAPI
import com.plcoding.dictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


object AppModule {

    //USE CASE
    @Provides
    @Singleton
    fun providesUseCase(repository: WordInfoRepository): GetWordInfo {

        return GetWordInfo(repo = repository)
    }


    //REPOSITORY

    @Provides
    @Singleton

    fun providesRepository(dao: WordDAO, api: DictionaryAPI): WordInfoRepository {


        return WordInfoRepositoryImpl(dao, api)
    }

    //API

    @Provides
    @Singleton

    fun providesAPI(): DictionaryAPI {

        //initialize moshi
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

//Retrofit is not on our project - so we need a builder to create its instance
        return Retrofit.Builder().baseUrl(DictionaryAPI.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(DictionaryAPI::class.java)
    }


}


