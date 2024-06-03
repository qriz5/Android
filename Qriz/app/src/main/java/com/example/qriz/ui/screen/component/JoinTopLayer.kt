package com.example.qriz.ui.screen.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qriz.ui.screen.Join.BackButton

@Composable
fun JoinTopLayer(navController : NavController, title : String, text1 : String, text2 : String, progressValue : Float ){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title,
            color = Color(0xFF545454),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
    Spacer(modifier = Modifier.height(10.dp))
    CustomProgressBar(progressValue)
    Spacer(modifier = Modifier.height(32.dp))
    Text(text1, fontWeight = FontWeight.Bold, fontSize = 24.sp)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text2, fontWeight = FontWeight.Medium, fontSize = 16.sp)
}