package com.example.a107_interfaceclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Employee employee = new Employee("Barry","Author");
        Consultant consultant = new Consultant("Will",100.00,30);

        textView.setText("");
        displayPay(employee);
        displayPay(consultant);

    }
    void displayPay(Payable payable){
        textView.append(payable.getPayString());
    }

}