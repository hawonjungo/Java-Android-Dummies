package com.example.a121_arraylistcollections;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= (TextView) findViewById(R.id.textView);

        OrderedPair<BagOfCheese> pair = new OrderedPair<>();

        BagOfCheese bag = new BagOfCheese();
        bag.kind = "Muenster";
        pair.setX(bag);

        bag = new BagOfCheese();
        bag.kind = "Brie";
        pair.setY(bag);

        textView.setText("");
        textView.append(pair.getX().kind);
        textView.setText("\n");
        textView.append(pair.getY().kind);
    }

}