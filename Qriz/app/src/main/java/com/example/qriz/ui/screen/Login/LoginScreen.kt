package com.example.qriz.ui.screen.Login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qriz.R
import com.example.qriz.ui.screen.component.TextBox
import com.example.qriz.ui.theme.appleNeo
import com.example.qriz.ui.theme.loginButtonColor
import com.example.qriz.ui.theme.textColorGray
import com.example.qriz.ui.theme.textFieldColor
import com.example.qriz.ui.theme.textFieldFontColor
import com.example.qriz.viewModel.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel){
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val idPlaceHolder = stringResource(id = R.string.idTextField)
    val passwordPlaceHolder = stringResource(id = R.string.passwordTextField)
    val context = LocalContext.current

    // Google SignIn 초기화

    LaunchedEffect(Unit) {
        viewModel.configureGoogleSignIn()
    }

    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(modifier = Modifier.padding(16.dp), painter = painterResource(id = R.drawable.logo_app), contentDescription = "로고(임시)")

            Spacer(modifier = Modifier.height(32.dp))

            TextBox(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(color = textFieldColor, shape = RoundedCornerShape(12.dp)),
                innerBoxModifier = Modifier.padding(16.dp),
                hint = idPlaceHolder,
                value = id,
                onValueChange = { id = it }
            )
            Spacer(modifier = Modifier.height(12.dp))
            //PassWord
            TextBox(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(color = textFieldColor, shape = RoundedCornerShape(12.dp)),
                innerBoxModifier = Modifier.padding(16.dp),
                hint = passwordPlaceHolder,
                value = password,
                onValueChange = { password = it },
                true
            )

            Spacer(modifier = Modifier.height(16.dp))

            //loginButton
            Button(
                onClick = {
                          viewModel.login(id, password)
                },
                colors = ButtonDefaults.buttonColors(
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
                Text("다른 방법으로 로그인하기", fontFamily = appleNeo, color = textColorGray,
                    modifier = Modifier.padding(horizontal = 16.dp))
                Divider(
                    color = textFieldFontColor,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            // 소셜 로그인 버튼
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.kakao_login_button_logo),
                    contentDescription = "카카오 로그인",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable {
                            Toast
                                .makeText(context, "카카오 로그인", Toast.LENGTH_SHORT)
                                .show()
                            viewModel.kakaoLogin()
                        }
                )
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.google_login_button_logo),
                    contentDescription = "구글 로그인",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .clickable {
                            viewModel.googleSignIn()
                        }
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            // 회원가입, 아이디 찾기, 비밀번호 찾기
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){

                Text(text = "회원가입",fontFamily = appleNeo, color = textColorGray,  modifier = Modifier.clickable {
                    navController.navigate("join")
                })
                Spacer(modifier = Modifier.width(4.dp))
                VerticalDivider()
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "아이디 찾기",fontFamily = appleNeo, color = textColorGray, modifier = Modifier.clickable {
                    navController.navigate("searchID")
                })
                Spacer(modifier = Modifier.width(4.dp))
                VerticalDivider()
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "비밀번호 찾기",fontFamily = appleNeo, color = textColorGray, modifier = Modifier.clickable {
                    navController.navigate("searchPass")
                })
            }
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    QrizTheme {
//       LoginScreen(viewModel = LoginViewModel( Application()))
//    }
//}

@Composable
fun VerticalDivider(
    color: Color = textColorGray,
    thickness: Dp = 1.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(thickness)
            .height(13.dp)
            .background(color = color)
    )
}