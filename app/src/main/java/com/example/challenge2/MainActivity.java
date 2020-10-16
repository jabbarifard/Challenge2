package com.example.challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button insertBtn;
    Button chooseBtn;
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
        chooseBtn = (Button) findViewById(R.id.chooseBtn);
        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),
                        "You chose Orange Crush!", Toast.LENGTH_LONG).show();
            }
        });
    }
//    public void toastMsg(String msg) {
//        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
//        toast.show();
//    }
//    public void displayToastMsg(View v) {
//        toastMsg("You chose Orange Crush!");
//    }

    public void insertOnClick(View view){
        //amount = moneyAmount.getText();//charSequence
        amount += Integer.valueOf(moneyAmount.getText().toString());
        totalAmount.setText(Integer.toString(amount));

    }
}