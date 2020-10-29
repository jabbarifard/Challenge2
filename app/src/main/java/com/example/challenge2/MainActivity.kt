package com.example.challenge2

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var insertBtn: Button? = null
    var refundBtn: Button? = null
    var orangeBtn: Button? = null
    var pepsiBtn: Button? = null
    var cokeBtn: Button? = null
    var amount = 0
    var needed = 0
    var change: String? = null
    var amountText: String? = null
    var builder: AlertDialog.Builder? = null
    var changeAmount: TextView? = null
    var moneyAmount: TextView? = null
    var orangePrice: TextView? = null
    var pepsiPrice: TextView? = null
    var cokePrice: TextView? = null
    var orangeImg: ImageView? = null
    var orangeView: View? = null
    var pepsiView: View? = null
    var cokeView: View? = null
    val backColor = Color.parseColor("#99CCFF")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amount = 0
        changeAmount = findViewById<View>(R.id.changeAmount) as TextView
        moneyAmount = findViewById<View>(R.id.moneyAmount) as EditText
        insertBtn = findViewById<View>(R.id.insertBtn) as Button
        orangeBtn = findViewById<View>(R.id.orangeBtn) as Button
        pepsiBtn = findViewById<View>(R.id.pepsiBtn) as Button
        cokeBtn = findViewById<View>(R.id.cokeBtn) as Button
        refundBtn = findViewById<View>(R.id.refundBtn) as Button
        orangeImg = findViewById<View>(R.id.orangeImg) as ImageView
        builder = AlertDialog.Builder(this)
        orangePrice = findViewById<View>(R.id.orangePrice) as TextView
        pepsiPrice = findViewById<View>(R.id.pepsiPrice) as TextView
        cokePrice = findViewById<View>(R.id.cokePrice) as TextView
        orangeView = findViewById(R.id.orangeView) as View
        pepsiView = findViewById(R.id.pepsiView) as View
        cokeView = findViewById(R.id.cokeView) as View
        orangeBtn!!.setOnClickListener { yesDialog(orangeView, 45, "Orange Crush") }
        pepsiBtn!!.setOnClickListener { yesDialog(pepsiView, 35, "Pepsi") }
        cokeBtn!!.setOnClickListener { yesDialog(cokeView, 25, "Coke") }
        refundBtn!!.setOnClickListener { //Setting message manually and performing action on button click
            builder!!.setMessage("Would you like refund?")
                    .setCancelable(false)
                    .setPositiveButton("Yes") { dialog, id ->
                        dialog.cancel()
                        change = Integer.toString(amount)
                        Toast.makeText(applicationContext, "$change cents has been refunded!",
                                Toast.LENGTH_SHORT).show()
                        amount = 0
                        changeAmount!!.text = Integer.toString(amount)
                        moneyAmount!!.text = ""
                        orangeView!!.setBackgroundColor(Color.TRANSPARENT)
                        pepsiView!!.setBackgroundColor(Color.TRANSPARENT)
                        cokeView!!.setBackgroundColor(Color.TRANSPARENT)
                    }
                    .setNegativeButton("No") { dialog, id -> //  Action for 'NO' Button
                        dialog.cancel()
                    }
            //Creating dialog box
            val alert = builder!!.create()
            //Setting the title manually
            alert.setTitle("You have refund!")
            alert.show()
        }
    }

    fun yesDialog(view: View?, price: Int, choice: String) {
        builder!!.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title)
        //Setting message manually and performing action on button click
        builder!!.setMessage("Do you want to continue?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    dialog.cancel()
                    if (amount >= price) {
                        view!!.setBackgroundColor(backColor)
                        amount = amount - price
                        change = Integer.toString(amount)
                        changeAmount!!.text = change.toString()
                        moneyAmount!!.text = change.toString()
                        Toast.makeText(applicationContext, "Your change: $change cents!",
                                Toast.LENGTH_SHORT).show()
                    } else {
                        needed = price - amount
                        Toast.makeText(applicationContext, "Sorry! You don't have enough money. You need $needed cents more!",
                                Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("No") { dialog, id -> dialog.cancel() }
        //Creating dialog box
        val alert = builder!!.create()
        //Setting the title manually
        alert.setTitle("You chose $choice !")
        alert.show()
    }

    fun isInteger(str: String?) = str?.toIntOrNull()?.let { true } ?: false

    fun insertOnClick(view: View?) {
        amountText = moneyAmount!!.text.toString().trim { it <= ' ' }
        if (amountText!!.length == 0) {
            amount = 0
        }
        if (isInteger(amountText) && (Integer.valueOf(amountText) == 5 || Integer.valueOf(amountText) == 10 || Integer.valueOf(amountText) == 25)) {
            amount += Integer.valueOf(amountText)
            changeAmount!!.text = Integer.toString(amount)
            moneyAmount!!.text = Integer.toString(amount)
        } else {
            Toast.makeText(applicationContext,
                    "You can insert only the values: 5,10 or 25, i.e. nickel, dime or quarter!", Toast.LENGTH_LONG).show()
            moneyAmount!!.text = amount.toString()
        }
        hideKeyboard()
    }

    private fun hideKeyboard() {
        val imm = moneyAmount!!.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(moneyAmount!!.windowToken, 0)
    }
}