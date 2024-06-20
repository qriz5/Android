package com.example.qriz.ui.screen.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.model.OnBoardingCategory
import com.example.qriz.ui.items.OnBoardingItem
import com.example.qriz.ui.screen.component.CustomButton
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo

@Composable
fun OnBoarding(){

    val items = remember {
        mutableStateListOf(
            OnBoardingCategory("모델링"),
            OnBoardingCategory("조인"),
            OnBoardingCategory("DDL"),
            OnBoardingCategory("모델링"),
            OnBoardingCategory("조인"),
            OnBoardingCategory("DDL"),
            OnBoardingCategory("모델링"),
            OnBoardingCategory("조인"),
            OnBoardingCategory("DDL"),
            OnBoardingCategory("모델링"),
            OnBoardingCategory("조인"),
            OnBoardingCategory("DDL"),
        )
    }

    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(color = Color(0xFFAAB6C9))) {
        Column (Modifier.fillMaxSize()){
            Column(Modifier.weight(1f)) {
                Text(text = "아는 개념을 체크해주세요!", fontSize = 24.sp, fontFamily = appleNeo, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "체크하신 결과를 토대로 \n추후 진행할 테스트의 레벨이 조정됩니다!", fontSize = 16.sp, fontFamily = appleNeo, fontWeight = FontWeight.Medium, color = Color(0XFF747D8B))
                Spacer(modifier = Modifier.height(24.dp))
                CategoryList(items, onItemClicked = { clickedItem ->
                    items.forEach { it.isSelected = it == clickedItem }
                })

            }
            CustomButton(onClick = { /*TODO*/ }, text = "선택완료")
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
@Composable
fun CategoryList(
    items: List<OnBoardingCategory>,
    onItemClicked: (OnBoardingCategory) -> Unit
) {
    LazyColumn {
        items(items) { item ->
            OnBoardingItem(item = item, onItemClicked = onItemClicked)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    QrizTheme {
        OnBoarding()
    }
}