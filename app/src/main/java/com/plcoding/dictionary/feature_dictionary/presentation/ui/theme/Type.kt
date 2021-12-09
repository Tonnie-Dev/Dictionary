package com.plcoding.dictionary.feature_dictionary.presentation.ui.theme


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.icons.materialIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle

import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.R
import okhttp3.internal.notifyAll

//initialize font family - FontFamily takes a list of fonts

private val RobotoCondensed = FontFamily(
    Font(resId = R.font.roboto_condensed_light, weight = FontWeight.W300),
    Font(resId = R.font.roboto_condensed_light_italic, weight = FontWeight.W200),
    Font(resId = R.font.roboto_condensed_regular, weight = FontWeight.W400),
    Font(resId = R.font.roboto_condensed_bold, weight = FontWeight.W900)
)


// Set of Material typography styles to start with
val Typography = Typography(

    h5 = TextStyle(
        color = Teal300,
        fontFamily = RobotoCondensed,
        fontSize = 36.sp,
        fontWeight = FontWeight.W400
    ),

    h6 = TextStyle(
        color = Teal200,
        fontFamily = RobotoCondensed,
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.W400),


    body1 = TextStyle(
        color = Black100,
        fontFamily = RobotoCondensed,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal),

    body2 = TextStyle(
        color = Black100,
        fontFamily = RobotoCondensed,
        fontSize = 14.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Medium



    ),

    caption = TextStyle(
        color = Teal200,
        fontFamily = RobotoCondensed,
        fontSize = 20.sp,
        fontWeight = FontWeight.W900
    ),

    overline = TextStyle(
        color = Black100,
        fontFamily = RobotoCondensed,
        fontSize = 12.sp,
        fontWeight = FontWeight.W900
    )


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