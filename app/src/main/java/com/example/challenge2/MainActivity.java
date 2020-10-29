package com.example.challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button insertBtn;
    Button refundBtn;
    Button orangeBtn;
    Button pepsiBtn;
    Button cokeBtn;
    int amount;
    int needed;
    String change;
    String amountText;
    AlertDialog.Builder builder;

    TextView changeAmount;
    TextView moneyAmount;
    TextView orangePrice;
    TextView pepsiPrice;
    TextView cokePrice;
    ImageView orangeImg;
    View orangeView;
    View pepsiView;
    View cokeView;
    final int backColor = Color.parseColor("#99CCFF");
    final int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = 0;
        changeAmount = (TextView) findViewById(R.id.changeAmount);
        moneyAmount = (EditText) findViewById(R.id.moneyAmount);
        insertBtn = (Button) findViewById(R.id.insertBtn);
        orangeBtn = (Button) findViewById(R.id.orangeBtn);
        pepsiBtn = (Button) findViewById(R.id.pepsiBtn);
        cokeBtn = (Button) findViewById(R.id.cokeBtn);
        refundBtn = (Button) findViewById(R.id.refundBtn);
        orangeImg = (ImageView) findViewById(R.id.orangeImg);
        builder = new AlertDialog.Builder(this);
        orangePrice = (TextView) findViewById(R.id.orangePrice);
        pepsiPrice = (TextView) findViewById(R.id.pepsiPrice);
        cokePrice = (TextView) findViewById(R.id.cokePrice);
        orangeView = (View) findViewById(R.id.orangeView);
        pepsiView = (View) findViewById(R.id.pepsiView);
        cokeView = (View) findViewById(R.id.cokeView);



        orangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesDialog(orangeView, 45, "Orange Crush");
            }
        });

        pepsiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesDialog(pepsiView, 35, "Pepsi");
            }
        });

        cokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesDialog(cokeView, 25, "Coke");
            }
        });

        refundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting message manually and performing action on button click
                builder.setMessage("Would you like refund?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                change = Integer.toString(amount);
                                Toast.makeText(getApplicationContext(), change + " cents has been refunded!",
                                        Toast.LENGTH_SHORT).show();
                                amount = 0;
                                changeAmount.setText(Integer.toString(amount));
                                moneyAmount.setText("");
                                orangeView.setBackgroundColor(Color.TRANSPARENT);
                                pepsiView.setBackgroundColor(Color.TRANSPARENT);
                                cokeView.setBackgroundColor(Color.TRANSPARENT);
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("You have refund!");
                alert.show();
            }
        });
    }

    public void yesDialog (final View view, final int price, final String choice){

        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
        //Setting message manually and performing action on button click
        builder.setMessage("Do you want to continue?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (amount >= price) {
                            view.setBackgroundColor(backColor);
                            amount = amount - price;
                            change = Integer.toString(amount);
                            changeAmount.setText(change.toString());
                            moneyAmount.setText(change.toString());
                            Toast.makeText(getApplicationContext(), "Your change: " + change + " cents!",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            needed = price - amount;
                            Toast.makeText(getApplicationContext(), "Sorry! You don't have enough money. You need " + needed + " cents more!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("You chose "+ choice+" !");
        alert.show();
    }


    public void insertOnClick(View view){

        amountText = moneyAmount.getText().toString().trim();
        if(amountText.length() == 0){amount = 0;}
        if ((amountText.matches("[0-9]+")) && (Integer.valueOf(amountText)== 5 || Integer.valueOf(amountText) == 10 || Integer.valueOf(amountText) == 25)) {
            amount += Integer.valueOf(amountText);
            changeAmount.setText(Integer.toString(amount));
            moneyAmount.setText(Integer.toString(amount));
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "You can insert only the values: 5,10 or 25, i.e. nickel, dime or quarter!", Toast.LENGTH_LONG).show();
            moneyAmount.setText(String.valueOf(amount));
        }
        hideKeyboard();
    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) moneyAmount.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(moneyAmount.getWindowToken(), 0);
    }
}