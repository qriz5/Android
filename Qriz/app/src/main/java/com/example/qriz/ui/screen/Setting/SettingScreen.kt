package com.example.qriz.ui.screen.Setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.R
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo

@Composable
fun SettingScreen(){

    var name by remember {
        mutableStateOf("Qriz")
    }
    var email by remember {
        mutableStateOf("Qriz@test.com")
    }
    Surface {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)){
            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally), Arrangement.SpaceBetween){
                Image(modifier = Modifier.clickable {  }, painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = "")
                Text(text = "설정", fontSize = 18.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold, color = Color(0xFF3F444C))
                Spacer(modifier = Modifier.width(1.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text("$name"+"님", fontSize = 24.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
            Text("$email", fontSize = 16.sp, fontFamily = appleNeo, color = Color(0xFF8F9AAA))
            Spacer(modifier = Modifier.height(30.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(2.dp)){
                Row(
                    Modifier
                        .padding(horizontal = 18.dp, vertical = 16.dp),
                    Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Column(Modifier.weight(1f)) {
                        Text(text = "회원정보 수정", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Medium)
                        Text(text = "$email", fontSize = 14.sp, fontFamily = appleNeo, color = Color(0xFF8F9AAA))
                    }

                    Image(painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = "")
                }
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(2.dp)){
                Row(
                    Modifier
                        .padding(horizontal = 18.dp, vertical = 16.dp),
                    Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Column(Modifier.weight(1f)) {
                        Text (text = "프로필 수정", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Medium)
                        Text(text = "$name", fontSize = 14.sp, fontFamily = appleNeo, color = Color(0xFF8F9AAA))
                    }

                    Image(painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = "")
                }
            }
            SettingMenu(text = "비밀번호 변경", icon = R.drawable.baseline_square_24)
            SettingMenu(text = "알림 설정", icon = R.drawable.baseline_square_24)
            SettingMenu(text = "로그아웃", icon = R.drawable.baseline_square_24)
            SettingMenu(text = "계정탈퇴", icon = R.drawable.baseline_square_24)
        }
    }
}

@Composable
fun SettingMenu(text : String, icon : Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 2.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp)){
        Row(
            Modifier
                .padding(horizontal = 18.dp, vertical = 16.dp),
            Arrangement.SpaceBetween){
            Text(modifier = Modifier.weight(1f), text = "$text", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Medium)
            Image(painter = painterResource(id = icon), contentDescription = "$text")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SettingPreview(){
    QrizTheme {
        SettingScreen()
    }
}