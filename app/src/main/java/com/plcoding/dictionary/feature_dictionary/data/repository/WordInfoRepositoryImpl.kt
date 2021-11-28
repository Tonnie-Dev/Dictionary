package com.plcoding.dictionary.feature_dictionary.data.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_dictionary.data.local.WordDAO
import com.plcoding.dictionary.feature_dictionary.data.remote.DictionaryAPI
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(private val dao: WordDAO, private val api: DictionaryAPI) :
    WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {


        //we first emit loading when we start the request to display progress bar

        emit(Resource.Loading())

        //get data from the database and convert it to domail level object
        val wordInfos = dao.getWordInfos(word = word).map { it.toWordInfo() }

        //emit the cache in the meantime while awaiting an update from the API

        /*we attach some data to the loading - this will now notify the ViewModel
        * that there is word info to display*/
        emit(Resource.Loading(wordInfos))

        //initiate API request

        try {
            val remoteWordInfos = api.getWordInfo(word)

            //at this point the request is successful and we can delete wordInfo from the db
            dao.deleteWordInfos(remoteWordInfos.map { it.word })

            //then insert the word infos
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })

        }
        //if the request did not complete/ invalid response
        catch (e: HttpException) {


        }
        //servers unreachable, parsing issue, no internet connection
        catch (e: IOException) {
        }
    }
}