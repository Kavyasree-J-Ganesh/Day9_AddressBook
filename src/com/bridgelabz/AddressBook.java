package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contactList = new ArrayList<>();

    public void addContact() {
        ContactPerson contactPerson = new ContactPerson();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of contact person");
        System.out.print("Enter first name:");
        contactPerson.setName(sc.next());
        System.out.print("Enter Last name:");
        contactPerson.setLastName(sc.next());
        System.out.println("Enter the Address : ");
        contactPerson.setAddress(sc.next());
        System.out.println("Enter the City : ");
        contactPerson.setCity(sc.next());
        System.out.println("Enter the State : ");
        contactPerson.setState(sc.next());
        System.out.println("Enter the ZipCode : ");
        contactPerson.setZipCode(sc.next());
        System.out.println("Enter the Mobile no : ");
        contactPerson.setPhoneNo(sc.next());
        contactList.add(contactPerson);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contactList=" + contactList +
                '}';
    }

    public void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name:");
        String name = sc.next();
        for (ContactPerson contactPerson : contactList) {
            if (name.equals(contactPerson.getName())) {
                System.out.println("Set Details");
                System.out.print("Enter first name:");
                contactPerson.setName(sc.next());
                System.out.print("Enter Last name:");
                contactPerson.setLastName(sc.next());
                System.out.println("Enter the Address : ");
                contactPerson.setAddress(sc.next());
                System.out.println("Enter the City : ");
                contactPerson.setCity(sc.next());
                System.out.println("Enter the State : ");
                contactPerson.setState(sc.next());
                System.out.println("Enter the ZipCode : ");
                contactPerson.setZipCode(sc.next());
                System.out.println("Enter the Mobile no : ");
                contactPerson.setPhoneNo(sc.next());
                break;
            }
        }


    }

    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name:");
        String name = sc.next();
        for (ContactPerson contactPerson : contactList) {
            if (name.equals(contactPerson.getName())) {
                contactList.remove(contactPerson);
                break;
            }

        }
    }
    public void operation(){
        Scanner scanner = new Scanner(System.in);
        int opration;
        do {
            System.out.println("1. ADD CONTACT \n2. DISPLAY CONTACT \n3 EDIT \n4 Delete \n5. EXIT ");
            System.out.println("Enter the Operation Number");
            opration = scanner.nextInt();
            switch (opration) {
                case 1:
                    addContact();
                    break;
                case 2:
                    System.out.println(this);
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Enter The Wrong Opration Number");
            }
        } while (opration != 5);
    }

}
