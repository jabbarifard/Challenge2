package com.example.challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
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

    //int userInput;
    TextView changeAmount;
    TextView moneyAmount;
    TextView orangePrice;
    TextView pepsiPrice;
    TextView cokePrice;
    ImageView orangeImg;
    View orangeView;
    View pepsiView;
    View cokeView;
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
        final int backColor = Color.parseColor("#99CCFF");





        orangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to continue?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (amount >= 45) {
                                    dialog.cancel();
                                    orangeView.setBackgroundColor(backColor);
                                    amount = amount - 45;
                                    change = Integer.toString(amount);
                                    changeAmount.setText(change.toString()+" cents");
                                    moneyAmount.setText(change.toString()+" cents");
                                    Toast.makeText(getApplicationContext(), "Your change: " + change + " cents!",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    dialog.cancel();
                                    needed = 45 - amount;
                                    Toast.makeText(getApplicationContext(), "Sorry! You don't have enough money. You need " + needed + " cents more!",
                                            Toast.LENGTH_SHORT).show();
                                }
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
                alert.setTitle("You chose Orange Crush!");
                alert.show();
            }
        });


        pepsiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to continue?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (amount >= 35) {
                                    dialog.cancel();
                                    pepsiView.setBackgroundColor(backColor);
                                    amount = amount - 35;
                                    change = Integer.toString(amount);
                                    changeAmount.setText(change.toString()+" cents");
                                    moneyAmount.setText(change.toString()+" cents");
                                    Toast.makeText(getApplicationContext(), "Your change: " + change + " cents!",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    dialog.cancel();
                                    needed = 35 - amount;
                                    Toast.makeText(getApplicationContext(), "Sorry! You don't have enough money. You need " + needed + " cents more!",
                                            Toast.LENGTH_SHORT).show();
                                }
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
                alert.setTitle("You chose Pepsi!");
                alert.show();
            }
        });

        cokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to continue?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (amount >= 25) {
                                    dialog.cancel();
                                    cokeView.setBackgroundColor(backColor);
                                    //cokePrice.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                                    amount = amount - 25;
                                    change = Integer.toString(amount);
                                    changeAmount.setText(change.toString()+" cents");
                                    moneyAmount.setText(change.toString()+" cents");
                                    Toast.makeText(getApplicationContext(), "Your change: " + change + " cents!",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    dialog.cancel();
                                    needed = 25 - amount;
                                    Toast.makeText(getApplicationContext(), "Sorry! You don't have enough money. You need " + needed + " cents more!",
                                            Toast.LENGTH_SHORT).show();
                                }
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
                alert.setTitle("You chose Coke!");
                alert.show();
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
                                changeAmount.setText(Integer.toString(amount)+" cents");
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

//            chooseBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //if (chooseBtn.getId() == R.id.orangeBtn)
//                        //Uncomment the below code to Set the message and title from the strings.xml file
//                    builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
//                    //else if(chooseBtn.getId() == R.id.pepsiBtn){
//                        //builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
//                    //Setting message manually and performing action on button click
//                    builder.setMessage("Do you want to continue?")
//                            .setCancelable(false)
//                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    //finish();
//                                    if(chooseBtn.getId() == R.id.orangeBtn) {
//                                        if (amount >= 45) {
//                                            dialog.cancel();
//                                            Toast.makeText(getApplicationContext(), "You choose yes action for alertbox",
//                                                    Toast.LENGTH_SHORT).show();
//                                            orangePrice.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//                                            //orangeImg.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//                                            amount = amount - 45;
//                                            change = Integer.toString(amount);
//                                            totalAmount.setText(change.toString());
//                                            moneyAmount.setText(change.toString());
//                                        } else {
//                                            dialog.cancel();
//                                            needed = 45 - amount;
//                                            Toast.makeText(getApplicationContext(), "Sorry! You don't have enough money. You need " + needed + " cents more!",
//                                                    Toast.LENGTH_SHORT).show();
//                                        }
//                                    } else if (chooseBtn.getId() == R.id.pepsiBtn){
//                                        if (amount >= 35) {
//                                            dialog.cancel();
//                                            Toast.makeText(getApplicationContext(), "You choose yes action for alertbox",
//                                                    Toast.LENGTH_SHORT).show();
//                                            pepsiPrice.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//                                            //orangeImg.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//                                            amount = amount - 35;
//                                            change = Integer.toString(amount);
//                                            totalAmount.setText(change.toString());
//                                            moneyAmount.setText(change.toString());
//                                        } else {
//                                            dialog.cancel();
//                                            needed = 35 - amount;
//                                            Toast.makeText(getApplicationContext(), "Sorry! You don't have enough money. You need " + needed + " cents more!",
//                                                    Toast.LENGTH_SHORT).show();
//                                        }
//                                    } else {
//                                        if (amount >= 25) {
//                                            dialog.cancel();
//                                            Toast.makeText(getApplicationContext(), "You choose yes action for alertbox",
//                                                    Toast.LENGTH_SHORT).show();
//                                            cokePrice.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//                                            //orangeImg.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//                                            amount = amount - 25;
//                                            change = Integer.toString(amount);
//                                            totalAmount.setText(change.toString());
//                                            moneyAmount.setText(change.toString());
//                                        } else {
//                                            dialog.cancel();
//                                            needed = 25 - amount;
//                                            Toast.makeText(getApplicationContext(), "Sorry! You don't have enough money. You need " + needed + " cents more!",
//                                                    Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                }
//                            })
//                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    //  Action for 'NO' Button
//                                    dialog.cancel();
//                                    Toast.makeText(getApplicationContext(), "You choose no action for alertbox",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                    //Creating dialog box
//                    AlertDialog alert = builder.create();
//                    //Setting the title manually
//                    if(chooseBtn.getId() == R.id.orangeBtn) {
//                        alert.setTitle("You chose Orange Crush!");
//                    } else if (chooseBtn.getId() == R.id.pepsiBtn){
//                        alert.setTitle("You chose Pepsi!");
//                    } else {
//                        alert.setTitle("You chose Coke!");
//                    }
//                    alert.show();
//                }
//            });
//        }


//    public void chooseBtnClick(View view) {
//        if (view.getId() == R.id.orangeBtn) {
//            Toast.makeText(getApplicationContext(),
//                    "You chose Orange Crush!", Toast.LENGTH_LONG).show();
//        } else if (view.getId() == R.id.pepsiBtn) {
//            Toast.makeText(getApplicationContext(),
//                    "You chose Pepsi!", Toast.LENGTH_LONG).show();
//        }else if (view.getId() == R.id.cokeBtn){
//            Toast.makeText(getApplicationContext(),
//                    "You chose Coke!", Toast.LENGTH_LONG).show();
//        }
//    }

//    public void refundBtnClick(View view) {
//        if (view.getId() == R.id.orangeBtn) {
//            Toast.makeText(getApplicationContext(),
//                    "You chose Orange Crush!", Toast.LENGTH_LONG).show();
//        } else if (view.getId() == R.id.pepsiBtn) {
//            Toast.makeText(getApplicationContext(),
//                    "You chose Pepsi!", Toast.LENGTH_LONG).show();
//        }else if (view.getId() == R.id.cokeBtn){
//            Toast.makeText(getApplicationContext(),
//                    "You chose Coke!", Toast.LENGTH_LONG).show();
//        }
//    }


    public void insertOnClick(View view){

        amountText = moneyAmount.getText().toString().trim();
        if(amountText.length() == 0){amount = 0;}
        if (Integer.valueOf(amountText)== 5 || Integer.valueOf(amountText) == 10 || Integer.valueOf(amountText) == 25) {
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