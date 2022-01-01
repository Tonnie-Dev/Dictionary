package com.plcoding.dictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WordChip(
    word: String,
    onClickChip: (String) -> Unit
) {
    Text(text = word, modifier = Modifier.clickable { onClickChip(word) })
}

@Composable
fun WordChipsRow(
    words: List<String>,
    scrollState: ScrollState,
    onClickChip: (String) -> Unit
) {

    Row(modifier = Modifier.horizontalScroll(scrollState)) {

        for (word in words){

            WordChip(word = word, onClickChip = onClickChip)

        }

    }

}


