package com.mohammed;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("07428673001");

    public static void main(String[] args) {

        boolean quit = false;


        printOptions();

        while(!quit){

            System.out.println("Please select option ");
            int option = input.nextInt();
            input.nextLine();
            switch(option){
                case 0 :
                    printOptions();
                    break;

                case 1 :
                    mobilePhone.printContactList();
                    break;
                case 2 :
                    addContact();
                    break;


                case 3 :
                    removeContact();
                    break;

                case 4 :
                    quit = true;
            }

        }

    }

    private static void printOptions(){
        System.out.println("\nPlease select from the following options: ");
        System.out.println("\t0 - Show options ");
        System.out.println("\t1 - See all contacts ");
        System.out.println("\t2 - Add contact ");
        System.out.println("\t3 - Remove contact");
        System.out.println("\t4 - Quit ");



    }

    private static void addContact(){
        System.out.println("Please enter contact name ");
        String name = input.nextLine();
        System.out.println("Please enter contact number ");
        String number = input.nextLine();

        mobilePhone.addtoContactlist(name,number);

    }

    private static void removeContact(){
        System.out.println("Please enter which contact you would like to remove ");
        int positionInput = input.nextInt();
        mobilePhone.removeContact(positionInput);
    }
}
