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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qriz.ui.screen.component.CustomProgressBar
import com.example.qriz.ui.screen.component.IdTextBox
import com.example.qriz.ui.screen.component.JoinTopLayer
import com.example.qriz.ui.theme.textFieldFontColor
import com.example.qriz.viewModel.LoginViewModel

@Composable
fun InputIDScreen(navController: NavController, viewModel : LoginViewModel){
    var id by remember { mutableStateOf("") }

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
                    text1 = "아이디를 입력해주세요!",
                    text2 = "사용할 아이디를 입력해주세요",
                    0.75f)
                Spacer(modifier = Modifier.height(32.dp))
                IdTextBox(hint = "아이디 입력", value = id, onValueChange = {id = it}, onClickButton = {}, maxLength = 8)
                Text(text = "${id.length}/8")
            }
            Button(
                onClick = { navController.navigate("InputPass") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    if (id.isNotEmpty()) Color.Black else textFieldFontColor,
                ),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text("다음")
            }
        }
    }
}