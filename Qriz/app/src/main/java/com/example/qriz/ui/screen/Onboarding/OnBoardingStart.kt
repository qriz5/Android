package com.example.qriz.ui.screen.Onboarding

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
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
fun OnBoardingStart(navController : NavController) {
    Surface (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(color = Color(0xFFAAB6C9))) {
        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(180.dp))
            Column(Modifier.weight(1f)) {
                Text(text = "SQLD를 어느정도 \n \n알고 계신가요?", fontFamily = appleNeo, fontWeight = FontWeight.Bold, fontSize = 36.sp, color = Color(0xFF3F444C))
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "선택하신 체크사항을 기반으로 모의고사 \n난이도를 맞춤으로 조정하여 제공해드려요!", fontFamily = appleNeo, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Color(0xFF747D8B))
            }
            CustomButton(onClick = {navController.navigate(route = Screens.OnBoarding.name)}, text = "시작하기")
            Spacer(modifier = Modifier.height(40.dp))
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QrizTheme {
       OnBoardingStart(NavController(Application()))
    }
}