package com.example.qriz.ui.screen.Setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.R
import com.example.qriz.ui.screen.component.CustomButton
import com.example.qriz.ui.screen.component.TextBox
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo
import com.example.qriz.ui.theme.textFieldColor
import com.example.qriz.ui.theme.textFieldFontColor

@Composable
fun ChangePasswordScreen(){

    var currentPassword by remember {
        mutableStateOf("")
    }
    var newPassword by remember {
        mutableStateOf("")
    }
    var newPasswordCheck by remember {
        mutableStateOf("")
    }
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(start = 18.dp, end = 18.dp, top = 16.dp, bottom = 40.dp).background(Color(0xFFF8F9FE)).imePadding()) {
        Column {
            Column(Modifier.weight(1f)){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally), Arrangement.SpaceBetween){
                    Image(modifier = Modifier.clickable {  }, painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = "")
                    Text(text = "비밀번호 변경", fontSize = 18.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold, color = Color(0xFF3F444C))
                    Spacer(modifier = Modifier.width(1.dp))
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "소중한 정보를 보호하기 위해\n새로운 비밀번호로 변경해 주세요!", fontSize = 20.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "이전에 사용한 적 없는 비밀번호가 안전합니다.", fontSize = 16.sp, fontFamily = appleNeo, color = Color(0xFF8F9AAA))
                Spacer(modifier = Modifier.height(24.dp))
                TextBox(modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(color = Color(0xFFEEF0F8), shape = RoundedCornerShape(12.dp)), innerBoxModifier = Modifier.padding(start = 16.dp), hint = "현재 비밀번호", value = currentPassword, onValueChange = {currentPassword = it})
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "사용중인 비밀번호를 입력해주세요.", fontSize = 12.sp, fontFamily = appleNeo, color = Color(0xFFEF5D5D))
                Spacer(modifier = Modifier.height(16.dp))
                TextBox(modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(color = Color(0xFFEEF0F8), shape = RoundedCornerShape(12.dp)), innerBoxModifier = Modifier.padding(start = 16.dp), hint = "새 비밀번호", value = newPassword, onValueChange = {newPassword = it})
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "새 비밀번호를 입력해주세요.(영문,숫자,특수문자 8~20자)", fontSize = 12.sp, fontFamily = appleNeo, color = Color(0xFFEF5D5D))
                Spacer(modifier = Modifier.height(16.dp))
                TextBox(modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(color = Color(0xFFEEF0F8), shape = RoundedCornerShape(12.dp)), innerBoxModifier = Modifier.padding(start = 16.dp), hint = "새 비밀번호 확인", value = newPassword, onValueChange = {newPassword = it})
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "새 비밀번호를 한번 더 입력해주세요.", fontSize = 12.sp, fontFamily = appleNeo, color = Color(0xFFEF5D5D))
            }
            Text(modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp), text = "비밀번호를 잊으셨나요?", color =  Color(0xFFA0A0A0),textAlign = TextAlign.Center, textDecoration = TextDecoration.Underline)
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    if (currentPassword.isNotEmpty() && newPassword.isNotEmpty() && newPasswordCheck.isNotEmpty()) Color.Black else textFieldFontColor,
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text("변경하기", fontSize = 18.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ChangePasswordPreview(){
    QrizTheme {
        ChangePasswordScreen()
    }
}