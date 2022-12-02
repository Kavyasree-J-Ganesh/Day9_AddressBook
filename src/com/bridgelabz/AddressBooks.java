package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBooks {
    static ArrayList<AddressBook> addressbooks = new ArrayList<AddressBook>();

    static void addAddressBook(String name){
         AddressBook book =  new AddressBook(name);
         addressbooks.add(book);
    }


    static void showContacts(){

        System.out.println("Contact details");
        System.out.println("");
        for(int j=0; j < addressbooks.size();j++){
            System.out.println("Address Book: " + addressbooks.get(j).name);
            System.out.println("____________________________________");
            if(addressbooks.get(j).contactPersons.size() == 0 ){
                System.out.println("No contacts");
            }
            for (int i = 0; i < addressbooks.get(j).contactPersons.size(); i++) {
                System.out.println(i+1 + ":" + addressbooks.get(j).contactPersons.get(i).firstName);
                System.out.println("____________________________________");
                System.out.println("Name : " + addressbooks.get(j).contactPersons.get(i).firstName + " " + addressbooks.get(j).contactPersons.get(i).lastName);
                System.out.println("Address : " + addressbooks.get(j).contactPersons.get(i).address);
                System.out.println("City : " + addressbooks.get(j).contactPersons.get(i).city);
                System.out.println("State : " + addressbooks.get(j).contactPersons.get(i).state);
                System.out.println("Zip : " + addressbooks.get(j).contactPersons.get(i).zip);
                System.out.println("Phone Number : " + addressbooks.get(j).contactPersons.get(i).phoneNumber);
                System.out.println("Email : " + addressbooks.get(j).contactPersons.get(i).email);
                System.out.println("");
            }

            System.out.println("");
        }

    }
    static void displayOptions(){
        Scanner scan =  new Scanner(System.in);
        int option;
        if(addressbooks.size() ==0 ){
            option = 4;
        } else {
            System.out.println("Select an option to continue");
            System.out.println("1. Add user");
            System.out.println("2. Edit user");
            System.out.println("3. Delete user");
            System.out.println("4. Add Address Book");
            System.out.println("5. Close");
            option = scan.nextInt();
        }

        switch (option){
            case 1:
                System.out.println("Enter the Address book number");
                int bookNo = scan.nextInt();
                ContactPerson person = addressbooks.get(bookNo).readCustomerDetails();
                addressbooks.get(bookNo).addPerson(person);
                showContacts();
                displayOptions();
                break;
            case 2:
                System.out.println("Enter the Address book number");
                bookNo = scan.nextInt();
                System.out.println("Enter the name to edit");
                String name = scan.next();
                person = addressbooks.get(bookNo).readCustomerDetails();
                addressbooks.get(bookNo).editContactPerson(name, person);
                showContacts();
                displayOptions();
                break;
            case 3:
                System.out.println("Enter the Address book number");
                bookNo = scan.nextInt();
                System.out.println("Enter the name to delete");
                name = scan.next();
                addressbooks.get(bookNo).deleteContact(name);
                showContacts();
                displayOptions();
                break;
            case 4:
                System.out.println("Enter the name of address book");
                String bookName = scan.next();
                addAddressBook(bookName);
                showContacts();
                displayOptions();
                break;
            case 5:
                System.out.println("Stopped");
                break;

        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        displayOptions();
    }
}
