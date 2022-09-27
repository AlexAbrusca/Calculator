package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@Composable
fun Calculator(){
    var display by remember { mutableStateOf("") }
    var num1 by remember { mutableStateOf(0.0) }
    var num2 by remember { mutableStateOf(0.0) }
    var result by remember { mutableStateOf(0.0) }
    var operator by remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = display,
            fontSize = 50.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(20f)
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .weight(0.1f)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            ){
            Key(text = "7") { display = buildString {
                append(display)
                append("7")
            }}
            Key(text = "8") { display = buildString {
                append(display)
                append("8")
            }}
            Key(text = "9") { display = buildString {
                append(display)
                append("9")
            }}
            Key(
                text = "x",
                color = MaterialTheme.colors.secondary
            ) {
                num1 = display.toDouble()
                display = ""
                operator = "x"
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Key(text = "4") { display = buildString {
                append(display)
                append("4")
            }}
            Key(text = "5") { display = buildString {
                append(display)
                append("5")
            }}
            Key(text = "6") { display = buildString {
                append(display)
                append("6")
            }}
            Key(text = "-",
                color = MaterialTheme.colors.secondary
            ) {
                num1 = display.toDouble()
                display = ""
                operator = "-"
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Key(text = "1") { display = buildString {
                append(display)
                append("1")
            }}
            Key(text = "2") { display = buildString {
                append(display)
                append("2")
            }}
            Key(text = "3") { display = buildString {
                append(display)
                append("3")
            }}
            Key(text = "+",
                color = MaterialTheme.colors.secondary
            ) {
                num1 = display.toDouble()
                display = ""
                operator = "+"
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Key(text = ".") { display = buildString {
                append(display)
                append(".")
            }}
            Key(text = "0") { display = buildString {
                append(display)
                append("0")
            }}
            Key(
                text = "=",
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                num2 = display.toDouble()
                when(operator){
                    "x" -> result = num1 * num2
                    "-" -> result = num1 - num2
                    "+" -> result = num1 + num2
                    "/" -> result = num1 / num2
                }
                display = result.toString()
            }
            Key(text = "/",
                color = MaterialTheme.colors.secondary
            ) {
                num1 = display.toDouble()
                display = ""
                operator = "/"
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Key(
                text = "C",
                color = Color.Red
            ) { display = ""}
        }
    }
}
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
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        Calculator()
    }
}