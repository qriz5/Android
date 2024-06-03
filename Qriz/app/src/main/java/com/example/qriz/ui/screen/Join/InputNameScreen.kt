package com.example.qriz.ui.screen.Join

import android.widget.ProgressBar
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qriz.R
import com.example.qriz.ui.screen.component.CustomProgressBar
import com.example.qriz.ui.screen.component.LimitedTextBox
import com.example.qriz.ui.screen.component.TextBox
import com.example.qriz.ui.theme.appleNeo
import com.example.qriz.ui.theme.textFieldColor
import com.example.qriz.ui.theme.textFieldFontColor
import com.example.qriz.viewModel.LoginViewModel

@Composable
fun InputNameScreen(navController: NavController,  parentNavController: NavController, viewModel : LoginViewModel){

    var name by remember { mutableStateOf("") }
    val namePlaceHolder = stringResource(id = R.string.nameTextField)
    BackHandler {
        parentNavController.popBackStack("login", false)
    }

    Surface {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BackButton {
                        parentNavController.popBackStack("login", false)
                    }
                    Spacer(modifier = Modifier.weight(1f)) // 가변적인 공간
                    Text(
                        text = "이름 입력",
                        color = Color(0xFF545454),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1f)) // 가변적인 공간
                }
                Spacer(modifier = Modifier.height(10.dp))
                CustomProgressBar(0.25f)
                Spacer(modifier = Modifier.height(32.dp))
                Text("이름을 입력해주세요!", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("가입을 위해 실명을 입력해주세요.", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(32.dp))
                LimitedTextBox(hint = namePlaceHolder, value = name, onValueChange = {name = it}, maxLength = 4)
                Text(text = "${name.length}/4")

            }
            Button(
                onClick = { navController.navigate("InputEmail") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    if (name.isNotEmpty()) Color.Black else textFieldFontColor,
                ),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text("다음")
            }

        }


    }
}

@Composable
fun BackButton(onBack: () -> Unit){

    Image(painter = painterResource(id = R.drawable.baseline_square_24) , contentDescription = "back", modifier = Modifier.clickable {
        onBack()
    })

}



