package com.example.challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button insertBtn;
    int amount;
    TextView totalAmount;
    TextView moneyAmount;
    String amountText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = 0;
        totalAmount = (TextView) findViewById(R.id.totalAmount);
        moneyAmount = (EditText) findViewById(R.id.moneyAmount);
        insertBtn = (Button) findViewById(R.id.insertBtn);
    }

    public void insertOnClick(View view){
        //amount = moneyAmount.getText();//charSequence
        amount += Integer.valueOf(moneyAmount.getText().toString());
        totalAmount.setText(Integer.toString(amount));

    }
}