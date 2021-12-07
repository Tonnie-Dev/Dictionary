package com.plcoding.dictionary.feature_dictionary.domain.use_case

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(private val repo: WordInfoRepository) {


    operator fun  invoke(word:String): Flow<Resource<List<WordInfo>>> {

        //validate word

        if (word.isBlank()){
            //return empty flow so that no API call takes place
            return flow {}
        }

        //else get word info
        return repo.getWordInfo(word)
    }
}