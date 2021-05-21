package com.example.a111_buttonlistener;

import android.view.View;


public class MyOnClickListener implements View.OnClickListener {
    MainActivity caller;
    public MyOnClickListener(MainActivity activity){
        caller = activity;
    }


    public void onClick(View view) {
        caller.textView.setText(R.string.you_clicked);
    }
}
