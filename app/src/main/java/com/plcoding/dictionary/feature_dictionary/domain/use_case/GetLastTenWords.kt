package com.plcoding.dictionary.feature_dictionary.domain.use_case

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow

class GetLastTenWords(private val repository: WordInfoRepository) {

    operator fun invoke(): Flow<Resource<List<WordInfo>>> {


        return repository.getLastTenWords()
    }



}