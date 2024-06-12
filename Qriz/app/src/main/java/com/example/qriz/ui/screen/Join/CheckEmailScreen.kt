package com.example.qriz.ui.screen.Join

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.qriz.ui.screen.component.EmailTextBox
import com.example.qriz.ui.screen.component.JoinTopLayer
import com.example.qriz.ui.screen.component.LimitedTextBox
import com.example.qriz.ui.screen.component.TextBox
import com.example.qriz.ui.screen.component.TimerTextBox
import com.example.qriz.ui.theme.appleNeo
import com.example.qriz.ui.theme.textFieldColor
import com.example.qriz.ui.theme.textFieldFontColor
import com.example.qriz.viewModel.LoginViewModel
import kotlinx.coroutines.delay

@Composable
fun CheckEmailScreen(navController: NavController, viewModel : LoginViewModel){
    var codeNumber by remember { mutableStateOf("") }
    var timer by remember { mutableStateOf(180L) }
    var authError by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        while (timer > 0) {
            delay(1000L)
            timer -= 1
        }
    }
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .imePadding()) {
            Column(modifier = Modifier.weight(1f)){
                JoinTopLayer(navController = navController,
                    title = "이메일 인증",
                    text1 = "이메일로 \n 받은 인증번호를 입력해주세요",
                    text2 = "이메일을 받지 못하셨다면 다시 보내기를 클릭해주세요.",
                    0.5f)
                Spacer(modifier = Modifier.height(32.dp))
                TimerTextBox(hint = "인증번호 4자리 입력",
                    value = codeNumber,
                    onValueChange = {codeNumber = it} ,
                    maxLength = 4,
                    timer = timer)
                if(authError) Text(text = "인증번호가 다르게 입력되었어요")
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "인증번호 다시 받기",
                    fontWeight = FontWeight.Bold,
                    fontFamily = appleNeo,
                    modifier = Modifier.clickable{

                    }.align(Alignment.CenterHorizontally))
            }


            Button(
                onClick = { navController.navigate("InputID") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    if (codeNumber.isNotEmpty()) Color.Black else textFieldFontColor,
                ),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text("다음")
            }

        }


    }
}