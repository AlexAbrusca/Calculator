package com.example.calculator.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Key (
    color: Color = MaterialTheme.colors.background,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
    click: () -> Unit,
){
    Button(
        click,
        shape = CircleShape,
        colors = colors

    ) {
        Text(text = text,
            fontSize = 35.sp,
            color = color
        )
    }
}