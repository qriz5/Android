package com.example.qriz.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.load.engine.Resource
import com.example.qriz.MyApp
import com.example.qriz.R
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo
import com.example.qriz.ui.theme.loginButtonColor
import com.example.qriz.ui.theme.textFieldColor
import com.example.qriz.ui.theme.textFieldFontColor
import com.skydoves.landscapist.CircularRevealImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen( onLoginSuccess : () -> Unit){
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val idPlaceHolder = stringResource(id = R.string.idTextField)
    val passwordPlaceHolder = stringResource(id = R.string.passwordTextField)
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(modifier = Modifier.padding(16.dp), painter = painterResource(id = R.drawable.logo_app), contentDescription = "로고(임시)")

            Spacer(modifier = Modifier.height(32.dp))

            TextBox(
                hint = idPlaceHolder,
                value = id,
                onValueChange = { id = it }
            )
            Spacer(modifier = Modifier.height(12.dp))
            //PassWord
            TextBox(
                hint = passwordPlaceHolder,
                value = password,
                onValueChange = { password = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            //loginButton
            Button(onClick = {onLoginSuccess()}, colors = ButtonDefaults.buttonColors(
                containerColor = loginButtonColor,
                contentColor = Color.White,
                disabledContainerColor = loginButtonColor,
                disabledContentColor = Color.White
            ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(8.dp),
                ) {
                Text("로그인", fontFamily = appleNeo, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Divider(
                    color = textFieldFontColor,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
                Text("다른 방법으로 로그인하기", fontFamily = appleNeo, color = textFieldFontColor,
                    modifier = Modifier.padding(horizontal = 16.dp))
                Divider(
                    color = textFieldFontColor,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            // 로그인 버튼  
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.kakao_login_button_logo),
                    contentDescription = "카카오 로그인",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.google_login_button_logo),
                    contentDescription = "구글 로그인",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                )
            }
        }

    }
}
@Composable
fun TextBox(
    hint: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = textFieldColor, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.padding(16.dp),
            contentAlignment = Alignment.CenterStart
            ) {
            if (value.isEmpty()) {
                Text(
                    text = hint,
                    color = textFieldFontColor,
                )
            }

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QrizTheme {
       LoginScreen(onLoginSuccess = {
           // 로그인 성공 시
           // 로그인 상태를 변경

       })
    }
}