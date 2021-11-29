package com.plcoding.dictionary.feature_dictionary.presentation

import androidx.lifecycle.ViewModel
import com.plcoding.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(private val useCase:GetWordInfo) :
    ViewModel() {
}