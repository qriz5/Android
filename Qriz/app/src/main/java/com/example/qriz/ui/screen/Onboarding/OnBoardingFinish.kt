package com.example.qriz.ui.screen.Onboarding

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qriz.ui.navigation.main.Screens
import com.example.qriz.ui.screen.component.CustomButton
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo

@Composable
fun OnBoardingFinish(navController : NavController) {
    var name by remember { mutableStateOf("") }
    Surface (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(color = Color(0xFFAAB6C9))) {
        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(180.dp))
            Column(Modifier.weight(1f)) {
                Text(text = "${name}님 \n \n환영합니다", fontFamily = appleNeo, fontWeight = FontWeight.Bold, fontSize = 36.sp, color = Color(0xFF3F444C))
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "준비돠어 있는 오늘의 공부와 모의고사로 \n시험을 같이 준비해요!", fontFamily = appleNeo, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Color(0xFF747D8B))
            }
            CustomButton(onClick = {}, text = "홈으로 가기")
            Spacer(modifier = Modifier.height(40.dp))
        }

    }
}
@Preview(showBackground = true)
@Composable
fun OnBoardingFinishPreview() {
    QrizTheme {
        OnBoardingFinish(NavController(Application()))
    }
}