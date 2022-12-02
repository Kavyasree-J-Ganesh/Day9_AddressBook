package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<ContactPerson> contactPersons = new ArrayList<ContactPerson>();

    String name;

    AddressBook(String name){
        this.name = name;
    }

    void addPerson(ContactPerson person){
        this.contactPersons.add(person);
    }
    void deleteContact(String name){
        System.out.println("Deleting " + name);
        System.out.println("");
        for (int i=0; i<this.contactPersons.size(); i++){
            if(this.contactPersons.get(i).firstName.equals( name)){
                this.contactPersons.remove(i);
            }
        }
    }
    void editContactPerson(String name, ContactPerson person){
        System.out.println("Replacing " + name + " with " + person.firstName);
        System.out.println("");
        for (int i = 0; i < this.contactPersons.size(); i++){
            if(this.contactPersons.get(i).firstName.equals(name)){
                this.contactPersons.set(i,person);
            }
        }
    }

    ContactPerson readCustomerDetails(){
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
}
