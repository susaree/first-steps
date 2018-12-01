package com.mohammed;


import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;
    private Branch branch;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public void printBranchlist(){
        for(int i = 0;i<branches.size();i++){
            System.out.println(i + " " + branches.get(i).getBranchNumber());
        }
    }

    public Customer findCustomerInBranch(String branchNum, String customerName){
        Branch customerBranch = findBranch(branchNum);
        return customerBranch.findCustomer(customerName);

    }

    public void addNewBranch(String branchNumber){
        branches.add(Branch.createBranch(branchNumber));
    }


    public void addCustomertoBranch(String customerName, String branchNum){
        Branch existingBranch = findBranch(branchNum);
        existingBranch.addnewCustomer(customerName);
    }

    public Branch findBranch(String branchNumber){
        for(Branch branch1 : branches){
            if(branchNumber.equals(branch1.getBranchNumber())){
                return branch1;
            }
        }
        System.out.println("Branch does not exist");
        return null;
    }

}
