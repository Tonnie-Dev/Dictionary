package com.plcoding.dictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.feature_dictionary.presentation.ui.theme.DictionaryTheme


@Composable
fun CustomSearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onClearIconClick: () -> Unit
) {


    Row (){
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
                    .fillMaxWidth(0.95f)
                    .padding(8.dp)


            //, placeholder = { Text(text = "Search")}
            //.clip(shape = RoundedCornerShape(75f))


        )
    }


}

@Preview(name = "TextPreview")
@Composable
fun MyTextFieldPreview() {
    Column (modifier = Modifier.fillMaxWidth()){
        Row {
            TextField(
                value = "Semi",
                onValueChange = { },


                label = { Text("Search") })
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomSearchTextField(value = "", onValueChange = {}) {

        }
    }
}
