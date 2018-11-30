package com.mohammed;


import java.util.ArrayList;



public class MobilePhone {


    private String myNumber;
    private ArrayList<Contact> myContacts;
    private Contact contact;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean findContact(String contactName) {

      for(int i = 0; i <myContacts.size(); i++) {
          String contact2 = myContacts.get(i).getName();
          if (contactName.equals(contact2)) {
              System.out.println(contact2 + " exists the number is: " + myContacts.get(i).getPhoneNumber());
              return true;
          }

      }
        System.out.println(contactName + " has been added to contact list. ");
      return false;

    }

    public boolean findContact(Contact contact) {
        if (myContacts.contains(contact)) {
            System.out.println("Contact already exists ");
            return true;
        } else {
            return false;
        }
    }

    public void addtoContactlist(String contactName1, String contactNumber) {
        if (!(findContact(contactName1))) {
            Contact newContact = Contact.createContact(contactName1,contactNumber);
            this.myContacts.add(newContact);
        }
    }

    public void printContactList() {
        System.out.println("You have " + myContacts.size() + " contacts in your phone");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contacts = myContacts.get(i);
            System.out.println((i) + " - " + contacts.getName() + " : " + contacts.getPhoneNumber());
        }


    }


    public void removeContact(int position) {
        myContacts.remove(position-1);
        String removedContact = myContacts.get(position).getName();
        System.out.println(removedContact + " has been removed from your contacts ");

    }


}
