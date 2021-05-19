package com.example.a918_readonlyfield;

public class Account {
    public String customerName;
    private int internalIdNumber;
    String address;
    String phone;
    public int socialSecurityNumber;
    int accountType;
    double balance;

    public static int findById(int internalIdNumber){
        Account foundAccount = new Account();
        // code find account here.
        return foundAccount.internalIdNumber;
    }
    public int getInternalIdNumber(){
        return internalIdNumber;
    }

    public void setInternalIdNumber(int internalIdNumber) {
        this.internalIdNumber = internalIdNumber;
    }
}
