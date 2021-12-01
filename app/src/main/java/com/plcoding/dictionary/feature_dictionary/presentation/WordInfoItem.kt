package com.plcoding.dictionary.feature_dictionary.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo


@Composable
fun WordInfoItem(wordInfo: WordInfo, modifier: Modifier = Modifier) {


    Column(modifier = modifier) {

        //title
        Text(
            text = wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        
        //phonetic
        
        Text(text = wordInfo.phonetic, fontWeight = FontWeight.Light)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        //origin
        Text(text = wordInfo.origin)


        //loop over the meanings

        wordInfo.meanings.forEach { meaning ->


            //part of speech e.g. noun, adjective, verb etc
            
            Text(text = meaning.partOfSpeech, fontWeight = FontWeight.Bold)

            //loop over the meaning of the word

            meaning.definitions.forEachIndexed { i, definition ->

                Text(text = "${i + 1}. ${definition.definition}")


                Spacer(modifier = Modifier.height(8.dp))

                //loop over examples
                
                definition.example?.let { 
                    
                    example ->
                    
                    Text(text = "Example: $example")
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))



        }
    }


}