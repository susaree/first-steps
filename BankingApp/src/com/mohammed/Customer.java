package com.mohammed;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    private double balance = 0.0d;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<Double>();

    }

    public String getName() {
        return name;
    }


    public void printTransactions(){
        for(int i = 0;i<transactions.size();i++){
            System.out.println(i + " " + transactions.get(i));
        }

        System.out.println("Your balance is: " + sumTransactions());
    }

    public void withdrawal(double withdrawalAmount){
        System.out.println("You have withdrawn: " + withdrawalAmount + " GBP ");
        this.balance-=withdrawalAmount;
        transactions.add(withdrawalAmount*-1);
        System.out.println("Your new balance is: " + sumTransactions());
    }

    public void deposit(double depositAmount){
        System.out.println("You have deposited: " + depositAmount + " GBP ");
        this.balance+=depositAmount;
        transactions.add(depositAmount);
        System.out.println("Your new balance is: " + sumTransactions());
    }

    private double sumTransactions(){
        double sum = 0.0;

        for(double transaction : transactions)
            sum += transaction;

        return sum;
    }

    public static Customer createCustomer(String newName){
        return new Customer(newName);
    }
}
