package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun WordChip(
    word: String,
    onClickChip: (String) -> Unit,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {

    //use surface for elevation

    Surface(
        elevation = 8.dp,
        color = if (isSelected) Color.Gray else MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {


        Row(modifier = Modifier.padding(8.dp)) {
            // Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = word,
                style = MaterialTheme.typography.button,
                modifier = Modifier.clickable { onClickChip(word) })

        }

    }

}

@Composable
fun WordChipsRow(
    words: List<String>,
    scrollState: ScrollState,
   coroutineScope: CoroutineScope,
    onClickChip: (String) -> Unit
) {

    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        coroutineScope.launch {

            scrollState.animateScrollTo(value = 0, animationSpec = spring( dampingRatio = Spring.DampingRatioHighBouncy))
        }

        for ((i, word) in words.withIndex()) {
            Spacer(modifier = Modifier.width(8.dp))
            WordChip(
                word = word.uppercase(),
                onClickChip = onClickChip,
                isSelected = (i == 0)
            )

        }


    }

}


