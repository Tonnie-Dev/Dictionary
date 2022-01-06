package com.plcoding.dictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

@Composable
fun WordChip(
    word: String,
    onClickChip: (String) -> Unit
) {
    Text(text = word, modifier = Modifier.clickable { onClickChip(word) })
}

@Composable
fun WordChipsRow(
    words: List<WordInfo>,
    scrollState: ScrollState,
    onClickChip: (String) -> Unit
) {

    Row(modifier = Modifier.horizontalScroll(scrollState)) {

      /*  for (wordInfo in words){

            WordChip(word = wordInfo.word, onClickChip = onClickChip)

        }*/


        for (i in 1..10){


WordChip(word = "Text $i ", onClickChip = {})
    }

    }

}


