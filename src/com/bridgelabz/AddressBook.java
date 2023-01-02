package com.bridgelabz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

    ArrayList<ContactPerson> contactList = new ArrayList<>();
    HashMap<String,ArrayList<ContactPerson>> contactsByCity = new HashMap<>();
    HashMap<String,ArrayList<ContactPerson>> contactsByState = new HashMap<>();

    public void addContact() {
        ContactPerson contactPerson = new ContactPerson();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of contact person");
        System.out.print("Enter first name:");
        contactPerson.setName(sc.next());

        boolean userPresent = contactList.stream().anyMatch(el-> el.getName().equals(contactPerson.getName()));
        if(userPresent){
           System.out.println("Contact already present");
           return;
        }
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

        if(contactsByCity.containsKey(contactPerson.getCity())){
            ArrayList<ContactPerson> contacts = contactsByCity.get(contactPerson.getCity());
            contacts.add(contactPerson);
            contactsByCity.put(contactPerson.getCity(), contacts);
        } else{
            contactsByCity.put(contactPerson.getCity(), new ArrayList<>(contactList));
        }

        if(contactsByState.containsKey(contactPerson.getState())){
            ArrayList<ContactPerson> contacts = contactsByState.get(contactPerson.getState());
            contacts.add(contactPerson);
            contactsByCity.put(contactPerson.getState(), contacts);
        } else{
            contactsByState.put(contactPerson.getState(), new ArrayList<>(contactList));
        }
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
                String city = contactPerson.getCity();
                String state = contactPerson.getState();
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
                if(contactsByState.containsKey(state)){
                    for (int i=0; i<contactsByState.get(state).size();i++){
                        if(name.equals(contactsByState.get(state).get(i).getName())){
                            contactsByState.get(state).remove(i);
                            contactsByState.get(state).add(contactPerson);
                        }
                    }
                }

                if(contactsByCity.containsKey(city)){
                    for (int i=0; i<contactsByCity.get(city).size();i++){
                        if(name.equals(contactsByCity.get(city).get(i).getName())){
                            contactsByCity.get(city).remove(i);
                            contactsByCity.get(city).add(contactPerson);
                        }
                    }
                }
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
                if(contactsByState.containsKey(contactPerson.getState())){
                    ArrayList<ContactPerson> contacts = contactsByState.get(contactPerson.getState());
                    contacts = new ArrayList<>(contacts.stream().filter(x-> x.getName() != contactPerson.getName()).toList());
                    contactsByState.put(contactPerson.getState(), contacts);
                }
                if(contactsByState.containsKey(contactPerson.getCity())){
                    ArrayList<ContactPerson> contacts = contactsByCity.get(contactPerson.getCity());
                    contacts = new ArrayList<>(contacts.stream().filter(x-> x.getName() != contactPerson.getName()).toList());
                    contactsByCity.put(contactPerson.getCity(), contacts);
                }
                break;
            }

        }
    }

    public void operation(){
        Scanner scanner = new Scanner(System.in);
        int opration;
        do {
            System.out.println(
                    "1. ADD CONTACT \n2. DISPLAY CONTACT \n3 EDIT \n4 Delete \n 5 Display by city " +
                            "\n 6 Display by state \n 7 Sort by name \n8. EXIT ");
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
                    System.out.println("Enter the  city");
                    String city = scanner.next();
                    System.out.println(contactsByCity.get(city));
                    System.out.println("Number of contacts with city = " + city + " " + contactsByCity.get(city).size());
                    break;
                case 6:
                    System.out.println("Enter the  state");
                    String state = scanner.next();
                    System.out.println(contactsByState.get(state));
                    System.out.println("Number of contacts with state = " + state + " " + contactsByState.get(state).size());
                    break;
                case 7:
                    contactList.sort(Comparator.comparing(ContactPerson::getName));
                    System.out.println(this);
                    break;
                case 8:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Enter The Wrong Opration Number");
            }
        } while (opration != 8);
    }

}
