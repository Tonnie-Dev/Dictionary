package com.plcoding.dictionary.feature_dictionary.presentation.ui.theme


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.icons.materialIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.R

//initialize font family - FontFamily takes a list of fonts

private val RobotoCondensed = FontFamily(
    Font(resId = R.font.roboto_condensed_light, weight = FontWeight.W300),
    Font(resId = R.font.roboto_condensed_light_italic, weight = FontWeight.W300),
    Font(resId = R.font.roboto_condensed_regular, weight = FontWeight.W400),
    Font(resId = R.font.roboto_condensed_bold, weight = FontWeight.W700)
    )




// Set of Material typography styles to start with
val Typography = Typography(

    h6 = TextStyle(
        color = Teal300,
        fontSize = 20.sp,
        fontFamily = RobotoCondensed,
        fontWeight =FontWeight.Medium
    ),



    body1 = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp

    ),

    body2 = TextStyle(),

    caption = TextStyle()



    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)