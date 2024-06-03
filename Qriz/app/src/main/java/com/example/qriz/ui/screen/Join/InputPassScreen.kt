package com.example.qriz.ui.screen.Join

import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.qriz.ui.screen.component.IdTextBox
import com.example.qriz.ui.screen.component.JoinTopLayer
import com.example.qriz.ui.screen.component.LimitedTextBox
import com.example.qriz.ui.theme.textFieldFontColor
import com.example.qriz.viewModel.LoginViewModel

@Composable
fun InputPassScreen(navController: NavController, parentNavController: NavController, viewModel : LoginViewModel){
    var pass by remember { mutableStateOf("") }
    var passCheck by remember {
        mutableStateOf("")
    }
    var diffPassText by remember {
        mutableStateOf(false)
    }

    BackHandler {
        navController.popBackStack()
    }
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                JoinTopLayer(navController = navController,
                    title = "회원가입",
                    text1 = "비밀번호를 입력해주세요!",
                    text2 = "사용할 비밀번호를 입력해주세요",
                    1f)
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "비밀번호")
                LimitedTextBox(hint = "비밀번호 입력 (영문/숫자 조합 8~10자)", value = pass, onValueChange = {pass = it}, maxLength = 10, isPassword = true)
                Spacer(modifier = Modifier.height(8.dp))
                LimitedTextBox(hint = "비밀번호 확인", value = passCheck, onValueChange = {passCheck = it}, maxLength = 10, isPassword = true)
                Spacer(modifier = Modifier.height(8.dp))
                if(diffPassText) Text(text = "비밀번호가 맞지 않아요")
            }
            Row{
                Button(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier
                        .weight(1f)
                        .height(54.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Black,
                    ),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text("이전")
                }
                Spacer(modifier = Modifier.weight(0.1f))
                Button(
                    onClick = {
                        if(pass.equals(passCheck)) parentNavController.navigate("login")
                        else {
                            diffPassText = true
                        }
                              },
                    modifier = Modifier
                        .weight(1f)
                        .height(54.dp),
                    colors = ButtonDefaults.buttonColors(
                        if (pass.isNotEmpty() && passCheck.isNotEmpty()) Color.Black else textFieldFontColor,
                    ),
                    enabled = (pass.isNotEmpty() && passCheck.isNotEmpty()),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text("가입하기")
                }
            }

        }
    }
}