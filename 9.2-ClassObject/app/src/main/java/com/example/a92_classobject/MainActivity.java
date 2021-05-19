package com.example.a92_classobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textView);

        BagOfCheese bag1 = new BagOfCheese("Cheddar", 2.43, 30, true);
        BagOfCheese bag2 = new BagOfCheese("Blue", 5.987, 90, false);

        textView.setText("");

        textView.append(bag1.toString());
        textView.append(bag2.toString());

    }


}