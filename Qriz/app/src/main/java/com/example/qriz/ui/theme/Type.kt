package com.example.qriz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

)
val appleNeo = FontFamily(
    Font(R.font.apple_sd_gothic_neo_eb),
    Font(R.font.apple_sd_gothic_neo_b),
    Font(R.font.apple_sd_gothic_neo_h),
    Font(R.font.apple_sd_gothic_neo_l),
    Font(R.font.apple_sd_gothic_neo_m),
    Font(R.font.apple_sd_gothic_neo_r),
    Font(R.font.apple_sd_gothic_neo_sb),
    Font(R.font.apple_sd_gothic_neo_t),
    Font(R.font.apple_sd_gothic_neo_ul),
)
