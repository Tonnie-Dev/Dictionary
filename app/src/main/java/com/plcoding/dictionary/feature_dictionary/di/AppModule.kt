package com.plcoding.dictionary.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.plcoding.dictionary.feature_dictionary.data.local.Converters
import com.plcoding.dictionary.feature_dictionary.data.local.WordInfoDatabase
import com.plcoding.dictionary.feature_dictionary.data.local.util.GsonParser
import com.plcoding.dictionary.feature_dictionary.data.remote.DictionaryAPI
import com.plcoding.dictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


object AppModule {


    init {

        //initialize moshi
    }

    //USE CASE
    @Provides
    @Singleton
    fun providesUseCase(repository: WordInfoRepository): GetWordInfo {

        return GetWordInfo(repo = repository)
    }


    //REPOSITORY

    @Provides
    @Singleton

    fun providesRepository(db: WordInfoDatabase, api: DictionaryAPI): WordInfoRepository {


        return WordInfoRepositoryImpl(db.wordDAO, api)
    }

    //API

    @Provides
    @Singleton

    fun providesAPI(): DictionaryAPI {


//Retrofit is not on our project - so we need a builder to create its instance
        return Retrofit.Builder().baseUrl(DictionaryAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryAPI::class.java)
    }


    //DATABASE
    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }


}


