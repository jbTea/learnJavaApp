package vn.funix.fx16042.java.asm2.models;

import javax.xml.namespace.QName;

public class Account {
    private String accountNumber;
    private double balance;

    public Account() {

    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public boolean isPremium(){
        return this.balance>=10000000;
    }
}
