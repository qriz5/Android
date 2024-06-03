package com.example.qriz.ui.screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CustomProgressBar(percent : Float){
    LinearProgressIndicator(modifier = Modifier
        .fillMaxWidth()
        .height(4.dp), progress = percent, color = Color(0xFF939393), trackColor = Color(0xFFD9D9D9)
    )
}