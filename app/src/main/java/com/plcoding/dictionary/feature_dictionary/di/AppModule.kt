package com.plcoding.dictionary.feature_dictionary.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.plcoding.dictionary.feature_dictionary.data.local.Converters
import com.plcoding.dictionary.feature_dictionary.data.local.WordDAO
import com.plcoding.dictionary.feature_dictionary.data.local.WordInfoDatabase
import com.plcoding.dictionary.feature_dictionary.data.local.util.MoshiParser
import com.plcoding.dictionary.feature_dictionary.data.remote.DictionaryAPI
import com.plcoding.dictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetLastTenWords
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


object AppModule {


    //USE CASE 1
    @Provides
    @Singleton
    fun providesUseCase(repository: WordInfoRepository): GetWordInfo {

        return GetWordInfo(repo = repository)
    }


    //USE CASE 2
    @Provides
    @Singleton

    fun provideLastTenWordsUseCase (repository: WordInfoRepository):GetLastTenWords{

        return GetLastTenWords(repository = repository)
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

        //initialize moshi
        val moshi: Moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

//Retrofit is not on our project - so we need a builder to create its instance
        return Retrofit.Builder()
                .baseUrl(DictionaryAPI.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(DictionaryAPI::class.java)
    }


    //DATABASE

    @Provides
    @Singleton

    fun providesDatabase(@ApplicationContext context: Context): WordInfoDatabase {

        return Room.databaseBuilder(context, WordInfoDatabase::class.java, "word_db")
                .addTypeConverter(Converters(MoshiParser()))
                .build()
    }


}


