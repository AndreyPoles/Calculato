package com.example.andreygalashko.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var myScreen: TextView
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btn0: Button
    lateinit var btnSub: Button
    lateinit var btnAdd: Button
    lateinit var btnMult: Button
    lateinit var btnDiv: Button
    lateinit var btnEqu: Button
    lateinit var btnMemDel: Button
    lateinit var btnMem: Button
    lateinit var btnSqu: Button
    lateinit var btnRes: Button
    lateinit var btnPoint: Button

    var temp = ""
    var memory = 0f
    var res = ""
    var num1 = 0f
    var num2 = 0f
    var result = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myScreen = findViewById(R.id.myScreen)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnAdd = findViewById(R.id.btnAdd)
        btnDiv = findViewById(R.id.btnDiv)
        btnEqu = findViewById(R.id.btnEqu)
        btnMem = findViewById(R.id.btnMem)
        btnMemDel = findViewById(R.id.btnMemDel)
        btnMult = findViewById(R.id.btnMult)
        btnSub = findViewById(R.id.btnSub)
        btnSqu = findViewById(R.id.btnSqu)
        btnRes = findViewById(R.id.btnRes)
        btnPoint = findViewById(R.id.btnPoint)

        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnAdd.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btnEqu.setOnClickListener(this)
        btnMem.setOnClickListener(this)
        btnMemDel.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnPoint.setOnClickListener(this)
        btnRes.setOnClickListener(this)
        btnSqu.setOnClickListener(this)
        btnSub.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState?.run {
            putString("KEY", myScreen.text.toString())
            putFloat("KEY1", num1)
            putFloat("KEY2", num2)
            putString("KEY3", temp)
            putFloat("KEY4", memory)
            putString("KEY5", res)
            putFloat("KEY6", result)
        }

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {

        myScreen.text = savedInstanceState?.getString("KEY")
        num1 = savedInstanceState?.getFloat("KEY1")
        num2 = savedInstanceState?.getFloat("KEY2")
        temp = savedInstanceState?.getString("KEY3").toString()
        memory = savedInstanceState?.getFloat("KEY4")
        res = savedInstanceState?.getString("KEY5").toString()
        result = savedInstanceState?.getFloat("KEY6")

        super.onRestoreInstanceState(savedInstanceState)
    }

    fun printOnScreenFirstN() {
        // Ф-я вывода результата на экран
        if (res.equals("")) {
            num1 = temp.toFloat()
            myScreen.text = num1.toString()
        } else {
            num2 = temp.toFloat()
            myScreen.text = num1.toString() + " " + res + " " + num2.toString()
        }
    }

    fun printOnScreenRes() {
        // Ф-я вывода знака на экран
        myScreen.text = num1.toString() + " " + res
        temp = ""
    }

    fun printOnScreenResult() {
// Ф-я вывода результата на экран
        myScreen.text =
            num1.toString() + " " + res + " " + num2.toString() + " = " + result.toString()
        temp = ""
        res = ""
        num1 = 0f
        num2 = 0f
        num1 = result
    }

    override fun onClick(v: View?) {
        // Логика нажатия кнопок
        when (v) {
            btn0 -> {
                temp = temp + "0"
                printOnScreenFirstN()
            }
            btn1 -> {
                temp = temp + "1"
                printOnScreenFirstN()
            }
            btn2 -> {
                temp = temp + "2"
                printOnScreenFirstN()
            }
            btn3 -> {
                temp = temp + "3"
                printOnScreenFirstN()
            }
            btn4 -> {
                temp = temp + "4"
                printOnScreenFirstN()
            }
            btn5 -> {
                temp = temp + "5"
                printOnScreenFirstN()
            }
            btn6 -> {
                temp = temp + "6"
                printOnScreenFirstN()
            }
            btn7 -> {
                temp = temp + "7"
                printOnScreenFirstN()
            }
            btn8 -> {
                temp = temp + "8"
                printOnScreenFirstN()
            }
            btn9 -> {
                temp = temp + "9"
                printOnScreenFirstN()
            }
            btnPoint -> {
                val regex = Regex("\\d+")
                val match = regex.matchEntire(temp)
                if (match != null) {
                    if (temp.equals("")) {
                        temp = temp + "0."
                        printOnScreenFirstN()
                    } else {
                        temp = temp + "."
                        printOnScreenFirstN()
                    }
                } else {
                    myScreen.text = "ТОЧКА УЖЕ СТОИТ"
                }
            }
            btnEqu -> if (num1 != 0f) {
                when (res) {
                    "+" -> {
                        result = num1 + num2
                        printOnScreenResult()
                    }
                    "-" -> {
                        result = num1 - num2
                        printOnScreenResult()
                    }
                    "/" -> {
                        if (num2 == 0f) {
                            myScreen.text = "НА 0 ДЕЛИТЬ НЕЛЬЗЯ"
                            temp = ""
                            res = ""
                            num1 = 0f
                            num2 = 0f
                            num1 = result
                        } else {
                            result = num1 / num2
                            printOnScreenResult()
                        }
                    }
                    "*" -> {
                        result = num1 * num2
                        printOnScreenResult()
                    }
                }
            } else
                myScreen.text = "ВВЕДИТЕ ДАННЫЕ"
            btnAdd -> {
                res = "+"
                temp = ""
                printOnScreenRes()
            }
            btnSub -> {
                res = "-"
                temp = ""
                printOnScreenRes()
            }
            btnDiv -> {
                res = "/"
                temp = ""
                printOnScreenRes()
            }
            btnMult -> {
                res = "*"
                temp = ""
                printOnScreenRes()
            }
            btnRes -> {
                temp = ""
                res = ""
                num1 = 0f
                num2 = 0f
                result = 0f
                myScreen.text = "0"
            }
            btnSqu -> {
                if (result != 0f) {
                    temp = sqrt(result).toString()
                    printOnScreenFirstN()
                    result = 0f
                } else if (num1 != 0f) {
                    temp = sqrt(num1).toString()
                    printOnScreenFirstN()
                }
            }
            btnMem -> {
                if (memory == 0f) {
                    if (result != 0f) {
                        memory = result
                        num2 = 0f
                        num1 = 0f
                    } else {
                        myScreen.text = "НЕТ ДАННЫХ ДЛЯ ЗАПОМИНАНИЯ"
                    }
                } else {
                    if (result == 0f) {
                        temp = memory.toString()
                        printOnScreenFirstN()
                    } else {
                        myScreen.text = "ОЧИСТИТЕ ПАМЯТЬ"
                    }
                }
            }
            btnMemDel -> {
                if (memory != 0f) {
                    memory = 0f
                } else {
                    myScreen.text = "ПАМЯТЬ ОЧИЩЕННА"
                }
            }
        }
    }
}