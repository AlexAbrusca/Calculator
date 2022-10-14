package com.example.calculator.ui.theme

fun keyLogic(
    mlist: MutableList<Double>,
    display: String,
    operator: String,
    text: String
){
    if (display == text){
        when(operator){
            "+" -> mlist.add(display.toDouble())
            "-" -> mlist.add(display.toDouble()*(-1))
        }
    }else
        when(operator){
            "+" -> mlist[mlist.size-1] = display.toDouble()
            "-" -> mlist[mlist.size-1] = display.toDouble()*(-1)
        }
}