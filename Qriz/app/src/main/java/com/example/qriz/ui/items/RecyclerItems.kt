package com.example.qriz.ui.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qriz.model.OnBoardingCategory
import com.example.qriz.model.TodayStudy
import com.example.qriz.ui.screen.Main.HomeScreen
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.ui.theme.appleNeo
import java.util.Date


@Composable
fun OnBoardingItem(
    item : OnBoardingCategory,
    onItemClicked : (OnBoardingCategory) -> Unit
) {
    Card(modifier = Modifier.padding(vertical = 8.dp), shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(Color.White), border = BorderStroke(width = 1.dp, color = Color.LightGray)){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = item.text)
            RadioButton(
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF3A6EFE),
                    unselectedColor = Color(0xFFAAB6C9),
                ),
                selected = item.isSelected,
                onClick = { onItemClicked(item) }
            )
        }
    }

}

@Composable
fun TodayStudyItem(
    item : TodayStudy,
    onItemClicked : (TodayStudy) -> Unit
) {
    Card(modifier = Modifier
        .padding(horizontal = 8.dp).clickable { onItemClicked(item) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(width = 0.2.dp, color = Color.LightGray),
        ){
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Day", fontSize = 14.sp, fontFamily = appleNeo, fontWeight = FontWeight.Normal, color = Color(0xFF3A6EFE))
            Spacer(modifier = Modifier.height(4.dp))
            Card(shape = CircleShape, colors = CardDefaults.cardColors(Color(0xFF3A6EFE))) {
                Box(
                    Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(

                        text = "${item.day}",
                        fontSize = 14.sp,
                        fontFamily = appleNeo,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodayStudyPreview(){
    QrizTheme {
        TodayStudyItem(TodayStudy(Date(), 1, "", "", "") ,{})
    }
}