package com.example.qriz.ui.screen.Main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.R
import com.example.qriz.model.TodayStudy
import com.example.qriz.ui.items.OnBoardingItem
import com.example.qriz.ui.items.TodayStudyItem
import com.example.qriz.ui.screen.component.CustomButton
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo
import com.example.qriz.ui.theme.textFieldFontColor
import java.util.Date

@Composable
fun HomeScreen(){
    var name by remember {
        mutableStateOf("")
    }
    var isRegistered by remember {
        mutableStateOf(false)
    }

    val items = remember {
        mutableStateListOf(
            TodayStudy(Date(), 1, "Title1", "Content1", "Description1"),
            TodayStudy(Date(), 2, "Title2", "Content2", "Description2"),
            TodayStudy(Date(), 3, "Title3", "Content3", "Description3"),
            TodayStudy(Date(), 4, "Title4", "Content4", "Description4"),
            TodayStudy(Date(), 5, "Title5", "Content5", "Description5"),
            TodayStudy(Date(), 6, "Title6", "Content6", "Description6"),
            TodayStudy(Date(), 7, "Title7", "Content7", "Description7"),
            TodayStudy(Date(), 1, "Title1", "Content1", "Description1"),
            TodayStudy(Date(), 2, "Title2", "Content2", "Description2"),
            TodayStudy(Date(), 3, "Title3", "Content3", "Description3"),
            TodayStudy(Date(), 4, "Title4", "Content4", "Description4"),
            TodayStudy(Date(), 5, "Title5", "Content5", "Description5"),
            TodayStudy(Date(), 6, "Title6", "Content6", "Description6"),
            TodayStudy(Date(), 7, "Title7", "Content7", "Description7"),
        )
    }
    Surface(
        Modifier
            .fillMaxSize()
            .padding(18.dp)
            .verticalScroll(rememberScrollState()), color = Color(0xFFF8F9FD)) {
        Column {
            Row(Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.logo_app), contentDescription = "Logo", modifier = Modifier.height(32.dp))
                Image(painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = null)
            }
            Spacer(modifier = Modifier.height(40.dp))
            RegisterTest(name = "", isRegistered)
            Spacer(modifier = Modifier.height(40.dp))
            TodayStudyView(items, {})
            Spacer(modifier = Modifier.height(60.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .clickable { },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(2.dp)){
                Row(Modifier.padding(vertical = 8.dp, horizontal = 8.dp)){
                    Image(modifier = Modifier.size(40.dp), painter = painterResource(id = R.drawable.baseline_square_24), contentDescription = "")
                    Spacer(modifier = Modifier.padding(end = 12.dp))
                    Column {
                        Text("오답노트 모아보기", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold, color = Color(0xFF3F444C))
                        Text("틀렸던 문제를 다시 복습해요!",fontSize = 12.sp, fontFamily = appleNeo, color = Color(0xFF93979F))
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            Row(Modifier.fillMaxWidth().padding(2.dp)){
                Card(
                    Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 133.dp)
                        .clickable { },
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                    Column(Modifier.padding(24.dp)) {
                        Text("오늘의 테스트", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
                        Text("실전처럼 준비하기", fontSize = 12.sp, fontFamily = appleNeo, color = Color(0xFF93979F))
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Card(
                    Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 133.dp)
                        .clickable { },
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(Modifier.padding(24.dp)) {
                        Text("모의고사 응시", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
                        Text("실전처럼 준비하기", fontSize = 12.sp, fontFamily = appleNeo, color = Color(0xFF93979F))
                    }
                }
            }


        }
    }
}

@Composable
fun RegisterTest(name : String, isRegistered : Boolean){
    if(isRegistered){
        
    }
    else{
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(2.dp)){
            Column(Modifier.padding(24.dp)) {
                Text(text = "${name}님의 \n시험 일정을 등록해보세요!", fontSize = 24.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
                Divider(
                    color = textFieldFontColor,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 24.dp)
                )
                Text(text = "등록된 일정이 없어요.", fontSize = 18.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
                Text(text = "지금 바로 등록할까요?", fontSize = 14.sp, fontFamily = appleNeo, fontWeight = FontWeight.Medium, color = Color(0xFFA8AFB6))
                Spacer(modifier = Modifier.height(16.dp))
                CustomButton(onClick = { /*TODO*/ }, text = "등록하기")

            }

        }
    }

}

@Composable
fun TodayStudyView(items : List<TodayStudy>, onItemClicked : (TodayStudy) -> Unit){

    var selectedItem by remember { mutableStateOf<TodayStudy?>(null) }
    Text("오늘의 공부", fontSize = 18.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(16.dp))
    LazyRow{
        items(items) { item ->
            TodayStudyItem(item = item, onItemClicked = {  clickedItem ->
                onItemClicked(clickedItem)
                selectedItem = clickedItem
            })
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(Color.White)) {
        Column(Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
            Text("공부해야 하는 주제는", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Light)
            Text("${selectedItem?.title}", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
            Divider(
                color = textFieldFontColor,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            Text("${selectedItem?.content}", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Light, color = Color(0xFF5A616B))
            Text("${selectedItem?.description}", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Light, color = Color(0xFF747D8B))

        }

    }
    Spacer(modifier = Modifier.height(16.dp))
    CustomButton(onClick = { /*TODO*/ }, text = "학습하러 가기")


}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    QrizTheme {
        HomeScreen()
    }
}