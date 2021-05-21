package com.example.a107_interfaceclass;

import java.text.NumberFormat;
import java.util.Locale;

public class Consultant implements Payable {
    String name;
    double hourlyFee;
    int hoursWorked;

    static NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

    public Consultant(){

    }

    public Consultant(String name, double hourlyFee, int hoursWorked) {
        this.name = name;
        this.hourlyFee = hourlyFee;
        this.hoursWorked = hoursWorked;
    }

    public double pay(){
        return hourlyFee*hoursWorked;
    }
    @Override
    public String getPayString() {
        return name+","+currency.format(pay())+"\n";
    }
}
