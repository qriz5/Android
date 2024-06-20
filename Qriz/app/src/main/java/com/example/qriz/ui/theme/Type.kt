package com.example.qriz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.qriz.R

val appleNeo = FontFamily(
    Font(R.font.apple_sd_gothic_neo_eb, FontWeight.ExtraBold),
    Font(R.font.apple_sd_gothic_neo_b, FontWeight.Bold),
    Font(R.font.apple_sd_gothic_neo_h, FontWeight.SemiBold),
    Font(R.font.apple_sd_gothic_neo_l, FontWeight.Light),
    Font(R.font.apple_sd_gothic_neo_m, FontWeight.Medium),
    Font(R.font.apple_sd_gothic_neo_r, FontWeight.Normal),
    Font(R.font.apple_sd_gothic_neo_sb, FontWeight.SemiBold),
    Font(R.font.apple_sd_gothic_neo_t, FontWeight.Thin),
//    Font(R.font.apple_sd_gothic_neo_ul, FontWeight.)
)
// Set of Material typography styles to start with
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = appleNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = appleNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = appleNeo,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle( // textBox
        fontFamily = appleNeo,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp


    ),


)

