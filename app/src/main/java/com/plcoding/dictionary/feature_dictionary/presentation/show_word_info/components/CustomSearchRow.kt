package com.plcoding.dictionary.feature_dictionary.presentation.show_word_info.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.dictionary.R


@Composable
fun CustomSearchRow(
    value: String,
    onValueChange: (String) -> Unit,
    onClearIconClick: () -> Unit,
    onClickTogIcon: () -> Unit
) {


    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

        SearchTextField(
            value = value,
            onValueChange = onValueChange,
            onClearIconClick = onClearIconClick
        )


        ThemeTogIconButton (onClickTogIcon = onClickTogIcon, modifier = Modifier.align(CenterVertically))

    }


}


@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onClearIconClick: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,

        label = { Text("Search") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Text
        ),

        leadingIcon = {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },

        trailingIcon = {

            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                Modifier.clickable { onClearIconClick() }
            )
        },


        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            leadingIconColor = MaterialTheme.colors.primary,
            trailingIconColor = MaterialTheme.colors.primary
        ),


        singleLine = true,
        modifier = Modifier
                .padding(8.dp)


    )

    //Spacer(modifier = Modifier.width(2.dp))


}


@Composable
fun ThemeTogIconButton(onClickTogIcon: () -> Unit, modifier: Modifier = Modifier) {

    IconButton(onClick = { onClickTogIcon() }) {

        Icon(
            painter = painterResource(id = R.drawable.tog_theme),
            contentDescription = null
        )

    }


}

@Preview(name = "TextPreview")
@Composable
fun MyTextFieldPreview() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row {
            TextField(
                value = "Semi",
                onValueChange = { },


                label = { Text("Search") })
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomSearchRow(value = "", onValueChange = {}, {}) {

        }
    }
}
