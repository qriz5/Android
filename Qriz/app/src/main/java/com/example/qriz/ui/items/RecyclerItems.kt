package com.example.qriz.ui.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import com.example.qriz.model.OnBoardingCategory




@Composable
fun OnBoardingItem(
    item : OnBoardingCategory,
    onItemClicked : (OnBoardingCategory) -> Unit
) {
    Card(modifier = Modifier.padding(vertical = 8.dp), shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(Color.White), border = BorderStroke(width = 1.dp, color = Color.LightGray)){
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
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