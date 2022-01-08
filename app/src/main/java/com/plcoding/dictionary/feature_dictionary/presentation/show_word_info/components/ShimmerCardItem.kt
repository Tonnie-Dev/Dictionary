package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.plcoding.dictionary.feature_dictionary.presentation.anim.ShimmerAnimation

@Composable
fun ShimmerCardItem(brush: Brush) {


    Column(modifier = Modifier.padding(16.dp)) {


        Spacer(
            modifier = Modifier
                    .height(32.dp)
                    .fillMaxWidth()
                    .background(brush = brush)
        )

        Spacer(
            modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(vertical = 16.dp)
                    .background(brush = brush)
        )
    }
}


@Composable
fun ShowShimmerCard() {
    
    
    LazyColumn(content = {
        
        item { 
            
            ShimmerAnimation {
                brush -> ShimmerCardItem(brush = brush) 
            }
        }
    })
    
}