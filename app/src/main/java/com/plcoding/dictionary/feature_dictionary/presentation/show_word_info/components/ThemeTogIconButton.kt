package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout

@Composable
fun ThemeTogIconButton(onThemeToggle: () -> Unit, modifier: Modifier = Modifier) {
    ConstraintLayout {

    }

        IconButton(onClick = { onThemeToggle() }, modifier) {

            Icon(

                imageVector = Icons.Default.Settings,
                /*painter = painterResource(id = R.drawable.tog_theme),*/
                contentDescription = null
            )

        }



}
