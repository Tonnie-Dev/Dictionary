package com.plcoding.dictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.feature_dictionary.presentation.ui.theme.DictionaryTheme


@Composable
fun CustomSearchTextField(value: String, onValueChange: (String) -> Unit) {


    Surface(color = MaterialTheme.colors.primary, elevation = 8.dp) {

        Row(modifier = Modifier.fillMaxWidth()) {
            SearchTextField(value= value, onValueChange = onValueChange)

        }

    }




}


@Composable
fun SearchTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        // placeholder = { Text(text = "Search ...") },

        label = { Text(text = "Search ...") },
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

        textStyle = TextStyle(
            color = MaterialTheme.colors.onSurface,
            fontSize = 28.sp,
            fontWeight = FontWeight.W700,

            ),

        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface, leadingIconColor = MaterialTheme.colors.primaryVariant),

        modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(8.dp),


        )


}

@Preview(name = "Search")
@Composable
fun PreviewCustomSearchTextField() {

    DictionaryTheme{


        CustomSearchTextField(value = "Text", onValueChange = {})
    }


}


