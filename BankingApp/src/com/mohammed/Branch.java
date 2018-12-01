package com.mohammed;

import java.util.ArrayList;

import java.util.Scanner;

public class Branch {
    private String branchNumber;
    private ArrayList<Customer> customers;

    private Customer customer;
    private static Scanner input = new Scanner(System.in);

    public Branch(String branchNumber) {
        this.branchNumber = branchNumber;
        this.customers = new ArrayList<Customer>();

    }

    public void printBranchCustomerList(){
        for(int i = 0; i < customers.size();i++){
            System.out.println(i + " " + customers.get(i).getName());
        }
    }




    public void addnewCustomer(String name) {
        if(findCustomer(name)==null) {
            System.out.println("Thank you, " + name + " has been added to branch " + branchNumber);
            customers.add(Customer.createCustomer(name));

        }
    }

    public Customer findCustomer(String name){
        for (int i = 0; i < customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(name)){
                return checkedCustomer;
            }

        }

        return null;

    }



    public String getBranchNumber() {
        return branchNumber;
    }

    public static Branch createBranch(String branchNum){
        return new Branch(branchNum);
    }
}
