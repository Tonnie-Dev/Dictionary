package com.plcoding.dictionary.feature_dictionary.data.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_dictionary.data.local.WordDAO
import com.plcoding.dictionary.feature_dictionary.data.remote.DictionaryAPI
import com.plcoding.dictionary.feature_dictionary.data.remote.dto.toWordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(private val dao: WordDAO,
                             private val api: DictionaryAPI) :
    WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {

//EMIT LOADING
        //we first emit loading before we start the request to display progress bar

        emit(Resource.Loading())

        //EMIT FROM DATABASE
        // read the current word from database and convert it to domail level object
        val wordInfos = dao.getWordInfos(word = word).map { it.toWordInfo() }

        //emit the cache in the meantime while awaiting an update from the API

        /*we attach some data to the loading - this will now notify the ViewModel
        * that there is word info to display*/
        emit(Resource.Loading(wordInfos))


//GET INFO FROM API & SAVE INTO THE DB
        try {
            //initiate the API call
            val remoteWordInfos = api.getWordInfo(word)

            //at this point the request is successful and we can delete wordInfo from the db
            dao.deleteWordInfos(remoteWordInfos.map { it.word })

            //then we replace the word infos in the db with info from the API
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
            //EMIT FROM THE DB WITH UPDATED INFO
            val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
            emit(Resource.Success(data = newWordInfos))
        }

        //EMIT ERRORS IF ANY
        //if the request did not complete/ invalid response
        catch (e: HttpException) {

            emit(
                Resource.Error(
                    "Ooops something went wrong",
                    //in error case we can potentially get data from the db

                    data = wordInfos
                )
            )


        }
        //servers unreachable, parsing issue, no internet connection
        catch (e: IOException) {

            emit(
                Resource.Error(
                    "Couldn't reach server, check your internet connection",
                    //in error case we can potentially get data from the db

                    data = wordInfos
                )
            )
        }

        //read again from the database after the remote update


    }
}