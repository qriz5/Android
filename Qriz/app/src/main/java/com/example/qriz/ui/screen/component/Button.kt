package com.example.qriz.ui.screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.ui.theme.appleNeo

@Composable
fun CustomButton(onClick: () -> Unit, text : String){
    Button(onClick = { onClick() }, modifier = Modifier
        .fillMaxWidth()
        .height(52.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(Color(0XFF3A6EFE))
    ) {
        Text(text = text, fontFamily = appleNeo, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}