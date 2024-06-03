package com.example.qriz.ui.screen.component

import android.health.connect.datatypes.units.Length
import android.sax.TextElementListener
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qriz.ui.theme.textFieldColor
import com.example.qriz.ui.theme.textFieldFontColor

@Composable
fun TextBox(
    modifier: Modifier,
    innerBoxModifier : Modifier,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword : Boolean = false
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = innerBoxModifier,
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
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,

                )
        }
    }
}

@Composable
fun LimitedTextBox(
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword : Boolean = false,
    maxLength: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(color = textFieldColor, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.padding(start = 16.dp,),
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
                onValueChange = {
                        newValue ->
                    val truncatedValue = newValue.take(maxLength)
                    onValueChange(truncatedValue)
                },
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,

                )
        }
    }
}

@Composable
fun EmailTextBox(
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword : Boolean = false,
    onClickButton : () -> Unit,
) {
    Row {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(44.dp)
                .background(color = textFieldColor, shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.padding(start = 16.dp),
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
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,

                    )
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Button(modifier = Modifier
            .weight(0.5f)
            .height(44.dp),
            colors = ButtonDefaults.buttonColors(
                 if (value.isNotEmpty()) Color.Black else textFieldFontColor,
            ),
            shape = RoundedCornerShape(12.dp),
            onClick = {onClickButton ()}) {
            Text(text = "인증")
        }
    }

}

@Composable
fun IdTextBox(
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword : Boolean = false,
    onClickButton : () -> Unit,
    maxLength: Int,
) {
    Row {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(44.dp)
                .background(color = textFieldColor, shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.padding(start = 16.dp),
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
                    onValueChange = {
                            newValue ->
                        val truncatedValue = newValue.take(maxLength)
                        onValueChange(truncatedValue)
                    },
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black),
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,

                    )
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Button(modifier = Modifier
            .weight(0.5f)
            .height(44.dp),
            colors = ButtonDefaults.buttonColors(
                if (value.isNotEmpty()) Color.Black else textFieldFontColor,
            ),
            shape = RoundedCornerShape(12.dp),
            onClick = {onClickButton ()}) {
            Text(text = "중복확인")
        }
    }

}

