package com.example.qriz.ui.screen.Join

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qriz.ui.screen.component.CustomProgressBar
import com.example.qriz.ui.screen.component.EmailTextBox
import com.example.qriz.ui.screen.component.JoinTopLayer
import com.example.qriz.ui.screen.component.LimitedTextBox
import com.example.qriz.ui.screen.component.TextBox
import com.example.qriz.ui.theme.textFieldColor

import com.example.qriz.ui.theme.textFieldFontColor
import com.example.qriz.viewModel.LoginViewModel

@Composable
fun InputEmailScreen(navController: NavController, viewModel : LoginViewModel){

    var email by remember { mutableStateOf("") }
    var codeNumber by remember { mutableStateOf("") }
    BackHandler {
        navController.popBackStack()
    }
    var emailError by remember {
        mutableStateOf(false)
    }
    var authError by remember {
        mutableStateOf(false)
    }

    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)){
                JoinTopLayer(navController = navController,
                    title = "이메일 인증",
                    text1 = "이메일로 본인확인을 진행할게요!",
                    text2 = "이메일 형식을 맞춰 입력해주세요.",
                    0.5f)
                Spacer(modifier = Modifier.height(32.dp))
                EmailTextBox(hint = "이메일 입력", value = email, onValueChange = {email = it}, onClickButton = {

                    emailError = true
                })
                if(emailError) Text(text = "이메일을 다시 확인해주세요")
                Spacer(modifier = Modifier.height(18.dp))
                LimitedTextBox(hint = "인증번호 4자리 입력", value = codeNumber, onValueChange = {codeNumber = it}, maxLength = 4, isPassword = true)
                if(authError) Text(text = "인증번호가 다르게 입력되었어요")

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

