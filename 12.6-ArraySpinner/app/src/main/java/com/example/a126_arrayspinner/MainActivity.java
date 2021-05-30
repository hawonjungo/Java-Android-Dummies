package com.example.a126_arrayspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        textView =(TextView) findViewById(R.id.textView);

        String[] choices = {
                "Select a composer","Monteverdi","Pachebel","Corelli"
        };

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,choices);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new MyItemSelectedListener());
    }

    class MyItemSelectedListener implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id){
            if(position ==0){
                textView.setText("You haven't selected a composer.");
            }else{
                textView.setText(adapterView.getItemAtPosition(position).toString());
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView){
            // Do nothing
        }
    }



}