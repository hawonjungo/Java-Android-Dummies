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

        BagOfCheese bag1 = new BagOfCheese();
        bag1.kind = "Cheddar";
        bag1.weight = 2.43;
        bag1.daysAged = 30;
        bag1.isDomestic = true;

        BagOfCheese bag2 = new BagOfCheese();
        bag2.kind = "Blue";
        bag2.weight = 5.987;
        bag2.daysAged = 90;
        bag2.isDomestic = false;

        textView.setText("");

        textView.append(toString(bag1));
        textView.append(toString(bag2));

    }

    private String toString(BagOfCheese bag) {
        return bag.kind +","+ bag.weight + ", " +
                bag.daysAged + ", " + bag.isDomestic + "\n";
    }
}