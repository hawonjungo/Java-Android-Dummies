package com.example.a107_interfaceclass;

public class Employee implements Payable{
    String name;
    String jobTitle;
    int vacationDays;
    double taxWithheld;

    public Employee(){

    }

    public Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    @Override
    public String getPayString() {
        return name+", Pay not known\n";
    }
}
