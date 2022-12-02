package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static ArrayList<ContactPerson> contactPersons = new ArrayList<ContactPerson>();

    static void addPerson(ContactPerson person){
        contactPersons.add(person);
    }
    static void deleteContact(String name){
        System.out.println("Deleting " + name);
        System.out.println("");
        for (int i=0; i<contactPersons.size(); i++){
            if(contactPersons.get(i).firstName == name){
                contactPersons.remove(i);
            }
        }
    }
    static void editContactPerson(String name, ContactPerson person){
        System.out.println("Replacing " + name + " with " + person.firstName);
        System.out.println("");
        for (int i = 0; i < contactPersons.size(); i++){
            if(contactPersons.get(i).firstName == name){
                contactPersons.set(i,person);
            }
        }
    }
    static void showContacts(){
        if(contactPersons.size() == 0){
            System.out.println("No contacts in Address book");
        }
        System.out.println("Contact details");
        System.out.println("");
        for (int i = 0; i < contactPersons.size(); i++) {
            System.out.println(i+1 + ":" + contactPersons.get(i).firstName);
            System.out.println("____________________________________");
            System.out.println("Name : " + contactPersons.get(i).firstName + " " + contactPersons.get(i).lastName);
            System.out.println("Address : " + contactPersons.get(i).address);
            System.out.println("City : " + contactPersons.get(i).city);
            System.out.println("State : " + contactPersons.get(i).state);
            System.out.println("Zip : " + contactPersons.get(i).zip);
            System.out.println("Phone Number : " + contactPersons.get(i).phoneNumber);
            System.out.println("Email : " + contactPersons.get(i).email);
            System.out.println("");
        }
    }

    static ContactPerson readCustomerDetails(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Customer Details ");
        System.out.println("First Name: ");
        String firstName = scan.nextLine();
        System.out.println("Last Name: ");
        String lastName = scan.nextLine();
        System.out.println("Address: ");
        String address = scan.nextLine();
        System.out.println("State: ");
        String state = scan.nextLine();
        System.out.println("City: ");
        String city = scan.nextLine();
        System.out.println("Zip: ");
        String zip = scan.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = scan.nextLine();
        System.out.println("Email: ");
        String email = scan.nextLine();
        ContactPerson person = new ContactPerson(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phoneNumber,
                email
        );
        return person;
    }

    static void displayOptions(){
        Scanner scan =  new Scanner(System.in);
        System.out.println("Select an option to continue");
        System.out.println("1. Add user");
        System.out.println("2. Edit user");
        System.out.println("3. Delete user");
        System.out.println("4. Close");
        int option = scan.nextInt();

        switch (option){
            case 1:
                ContactPerson person = readCustomerDetails();
                addPerson(person);
                showContacts();
                displayOptions();
                break;
            case 2:
                System.out.println("Enter the name to edit");
                String name = scan.nextLine();
                person = readCustomerDetails();
                editContactPerson(name, person);
                showContacts();
                displayOptions();
                break;
            case 3:
                System.out.println("Enter the name to delete");
                name = scan.nextLine();
                deleteContact(name);
                showContacts();
                displayOptions();
                break;
            case 4:
                System.out.println("Stopped");

        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        displayOptions();
    }
}
