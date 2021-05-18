package com.example.a71_billfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView totalView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalView = (TextView) findViewById(R.id.totalView);
    }
    public void onButtonClick(View view) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        totalView.setText(currency.format(addAll(100.00, 0.05, 0.20)));
    }
    double addAll(double bill, double taxRate, double tipRate) {
        bill *= 1 + taxRate;
        bill *= 1 + tipRate;
        return bill;
    }

}