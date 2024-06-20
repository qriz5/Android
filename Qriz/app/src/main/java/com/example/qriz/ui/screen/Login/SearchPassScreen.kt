package com.example.qriz.ui.screen.Login

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.qriz.ui.screen.Join.BackButton
import com.example.qriz.ui.screen.component.ConfirmDialog
import com.example.qriz.ui.screen.component.TextBox
import com.example.qriz.ui.theme.textFieldColor
import com.example.qriz.ui.theme.textFieldFontColor
import com.example.qriz.viewModel.LoginViewModel

@Composable
fun SearchPassScreen(navController : NavController, viewModel : LoginViewModel){
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }
    var dialogState by remember {
        mutableStateOf(false)
    }
    BackHandler {
        navController.popBackStack("login", false)
    }

    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BackButton {
                        navController.popBackStack("login", false)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "비밀번호 찾기",
                        color = Color(0xFF545454),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "비밀번호를 잊으셨나요?", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Qriz에 가입했던 이메일을 입력하시면 " + "\n"+
                        "비밀번호 변경 메일을 전송해드립니다.", fontWeight = FontWeight.Medium, fontSize = 16.sp)

                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "이메일", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                TextBox(modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(color = textFieldColor, shape = RoundedCornerShape(12.dp)), innerBoxModifier = Modifier.padding(start = 16.dp), hint = "예) Qriz@test.com", value = email, onValueChange = {email = it})
                Spacer(modifier = Modifier.height(8.dp))
                if(emailError) Text(text = "이메일을 정확하게 입력해주세요", fontWeight = FontWeight.Medium, fontSize = 12.sp)
            }
            Button(
                onClick = { dialogState = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    if (email.isNotEmpty()) Color.Black else textFieldFontColor,
                ),
                shape = RoundedCornerShape(12.dp),
                enabled = email.isNotEmpty()
            ) {
                Text("이메일 발송")
            }
        }
        if(dialogState) ConfirmDialog(
            title = "이메일 발송 완료!",
            description = "입력해주신 이메일 주소로 \n 비밀번호가 발송되었습니다. \n 메일함을 확인해주세요",
            onClickCancel = {
                dialogState = false
            }
        )
    }
}