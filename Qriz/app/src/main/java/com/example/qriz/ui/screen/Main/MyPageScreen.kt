package com.example.qriz.ui.screen.Main

import android.graphics.drawable.Icon
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.R
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo


@Composable
fun MyPageScreen(){
    Surface {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally), Arrangement.SpaceBetween){
                Spacer(modifier = Modifier.width(1.dp))
                Text(text = "마이페이지", fontSize = 18.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold, color = Color(0xFF3F444C))
                Image(modifier = Modifier.clickable {  }, painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = "")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row{
                Text(text = "쿼리츠", fontSize = 24.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally), Arrangement.SpaceAround){
                MyPageMenuCard("정오답노트")
                MyPageMenuCard("점수 보기")
                MyPageMenuCard("시험 등록")

            }
            Spacer(modifier = Modifier.height(40.dp))
            Card(shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(2.dp)){
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)) {
                    Text("고객센터", fontSize = 18.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
                    MypageUserInformation("FAQ", R.drawable.baseline_square_24)
                    MypageUserInformation("서비스 이용약관", R.drawable.baseline_square_24)
                    MypageUserInformation("개인정보 처리방침", R.drawable.baseline_square_24)
                    MypageUserInformation("버전정보", R.drawable.baseline_square_24)
                    MypageUserInformation("공지사항", R.drawable.baseline_square_24)


                }

            }

        }
    }
}
@Composable
fun MyPageMenuCard(text : String, ){
    Card(

        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp)){
        Column(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(modifier = Modifier.size(32.dp), painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = "")
            Spacer(modifier = Modifier.height(8.dp))
            Text("$text")

        }
    }
}

@Composable
fun MypageUserInformation(text : String, icon : Int){
    Row(Modifier.fillMaxWidth().padding(vertical = 16.dp).clickable {  }){
        Image(painter = painterResource(id = icon), contentDescription = "$text")
        Text(modifier = Modifier.padding(start = 12.dp), text = "$text", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Medium)
    }

}
@Preview(showBackground = true)
@Composable
fun MyPagePreview(){
    QrizTheme {
        MyPageScreen()
    }
}