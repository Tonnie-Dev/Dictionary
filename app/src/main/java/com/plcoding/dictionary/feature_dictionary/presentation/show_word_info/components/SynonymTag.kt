package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SynonymTag(synonym:String, onClickTag:(String)->Unit) {

    Box(modifier = Modifier.border(
        width = 1.dp,
        color = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(100.dp)
    ).clickable {  onClickTag(synonym)}) {


        Text(
            text = synonym,
            style = MaterialTheme.typography.overline,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(5.dp)
        )
    }


}