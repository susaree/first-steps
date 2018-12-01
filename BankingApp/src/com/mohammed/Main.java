package com.mohammed;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static Bank bank = new Bank("HSBC");

    public static void main(String[] args) {
        boolean quit = false;


        printOptions();

        while (!quit) {

            System.out.println("Please select option ");
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 0:
                    printOptions();
                    break;

                case 1:
                    bank.printBranchlist();
                    break;
                case 2:
                    bank.addNewBranch(getBranchNumber());
                    break;
                case 3:
                    bank.addCustomertoBranch(getCustomerDetails(),getBranchNumber());
                    break;

                case 4:
                    printCustomerList(getBranchNumber());
                    break;

                case 5:
                    showCustomerTransactions(getBranchNumber(),getCustomerDetails());
                    break;

                case 6:
                    customerDeposit(getBranchNumber(),getCustomerDetails(),getAmount());
                    break;

                case 7:
                    customerWithdrawal(getBranchNumber(),getCustomerDetails(),getAmount());
                    break;

                case 8:
                    quit = true;
            }
        }
    }

    private static void printOptions() {
        System.out.println("\nPlease select from the following options: ");
        System.out.println("\t0 - Show options ");
        System.out.println("\t1 - Show Branch list ");
        System.out.println("\t2 - Add new branch ");
        System.out.println("\t3 - Add new customer ");
        System.out.println("\t4 - Show customers in branch");
        System.out.println("\t5 - Show customer transactions");
        System.out.println("\t6 - Make deposit");
        System.out.println("\t7 - Make withdrawal");
        System.out.println("\t8 - Quit app");
    }

     private static void printCustomerList(String branchNumb){
        Branch branch = bank.findBranch(branchNumb);
        branch.printBranchCustomerList();
    }

    private static void showCustomerTransactions(String branchNum, String customerName){
        Customer customer = bank.findCustomerInBranch(branchNum,customerName);
        customer.printTransactions();

    }

    private static void customerDeposit(String branchNum, String customerName, double depositAmount){
        Customer customer = bank.findCustomerInBranch(branchNum,customerName);
        customer.deposit(depositAmount);
    }

    private static void customerWithdrawal(String branchNum, String customerName, double withdrawalAmount){
        Customer customer = bank.findCustomerInBranch(branchNum,customerName);
        customer.withdrawal(withdrawalAmount);
    }

    private static String getBranchNumber(){
        System.out.println("Please enter branch number ");
        return input.nextLine();
    }

    private static String getCustomerDetails(){
        System.out.println("Please enter your name ");
        return input.nextLine();
    }

    private static double getAmount(){
        System.out.println("Please enter amount ");
        return input.nextDouble();
    }

}
