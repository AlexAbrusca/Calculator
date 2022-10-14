package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.calculator.ui.theme.Key
import com.example.calculator.ui.theme.keyLogic


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
    var num1 by remember { mutableStateOf(0.0) }
    var num2 by remember { mutableStateOf(0.0) }
    var result by remember { mutableStateOf(0.0) }
    var operator by remember { mutableStateOf("+")}
    var display by remember { mutableStateOf("") }
    val mlist  by remember { mutableStateOf(mutableListOf<Double>()) }

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
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "7")
            }
            Key(text = "8") { display = buildString {
                append(display)
                append("8")
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "8")
            }
            Key(text = "9") { display = buildString {
                append(display)
                append("9")
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "9")
            }
            Key(
                text = "x",
                color = MaterialTheme.colors.secondary
            ) {
                if(display != "") num1 = mlist.fold(0.0){ total, n -> total + n}
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
            }
               keyLogic(mlist = mlist, display = display, operator = operator, text = "4")
            }
            Key(text = "5") { display = buildString {
                append(display)
                append("5")
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "5")
            }
            Key(text = "6") { display = buildString {
                append(display)
                append("6")
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "6")
            }
            Key(text = "-",
                color = MaterialTheme.colors.secondary
            ) {
                operator = "-"
                display = ""
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
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "1")
            }
            Key(text = "2") { display = buildString {
                append(display)
                append("2")
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "2")
            }
            Key(text = "3") { display = buildString {
                append(display)
                append("3")
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "3")
            }
            Key(text = "+",
                color = MaterialTheme.colors.secondary
            ) {
                operator = "+"
                display = ""
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
            }
                keyLogic(mlist = mlist, display = display, operator = operator, text = "0")
            }
            Key(
                text = "=",
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                if (display != "") {
                when(operator){
                    "x" -> {
                        num2 = display.toDouble()
                        result = (num1 * num2)
                        mlist.clear()
                        mlist.add(result)
                    }
                    "/" -> {
                        num2 = display.toDouble()
                        result = (num1 / num2)
                        mlist.clear()
                        mlist.add(result)
                    }
                    "-","+" -> result = mlist.fold(0.0){ total, n -> total + n}
                }
                display = result.toString()
                operator = "+"
                }
            }
            Key(text = "/",
                color = MaterialTheme.colors.secondary
            ) {
                if(display != "") num1 = mlist.fold(0.0){ total, n -> total + n}
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
            ) {
                display = ""
                mlist.clear()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        Calculator()
    }
}