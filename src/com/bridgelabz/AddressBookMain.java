package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    static  HashMap<String,AddressBook> addressBookMap=new HashMap<>();

    // String --> Key
    //Key --> Address book Name
    // AddressBook --> Value(In address book we will store our contacts)
    //Adressbook --> new Object
    public static void main(String[] args) {
        System.out.println("WelCome To AddressBook Program");
        Scanner scanner = new Scanner(System.in);
        int opration;
        do {
            System.out.println(
                    "1. ADD Addressbook \n2. Perform Operations into AddressBook \n3 Display all address book \n " +
                            "4 Get contacts by city \n" +
                            "5 Get contacts by state \n"
                            "\n 5 Exit");
            System.out.println("Enter the Operation Number");
            opration = scanner.nextInt();
            scanner.nextLine();
            switch (opration) {
                case 1:
                    System.out.println("Enter the name of address book");
                    String name =scanner.nextLine();
                    AddressBook addressBook = new AddressBook();
                    addressBookMap.put(name,addressBook);


                    break;
                case 2:
                    System.out.println("Enter the name of address book into which you want to perform the operations");
                    String bookName = scanner.nextLine();

                    AddressBook addressBookToAdd =  addressBookMap.get(bookName);
                    addressBookToAdd.operation();

                    break;
                case 3:
                    for(Map.Entry<String,AddressBook> set : addressBookMap.entrySet()){
                        System.out.println(set.getKey() + "=" + set.getValue());
                    }
                    break;

                case 4:
                    System.out.println("Enter the city");
                    String city = scanner.nextLine();
                    ArrayList<ContactPerson> contactsByCity = new ArrayList<>();
                    for(Map.Entry<String,AddressBook> set : addressBookMap.entrySet()){
                        ArrayList<ContactPerson> contacts = set.getValue().contactList;
                        ArrayList<ContactPerson> contactsByCityFilter =
                                new ArrayList<>(contacts.stream().filter(
                                        el->el.getCity().equals(city)).toList()
                                );
                        contactsByCity.addAll(contactsByCityFilter);
                    }
                    System.out.println(contactsByCity);
                    break;
                case 5:
                    System.out.println("Enter the state");
                    String state = scanner.nextLine();
                    ArrayList<ContactPerson> contactsByState = new ArrayList<>();
                    for(Map.Entry<String,AddressBook> set : addressBookMap.entrySet()){
                        ArrayList<ContactPerson> contacts = set.getValue().contactList;
                        ArrayList<ContactPerson> contactsByCityFilter =
                                new ArrayList<>(contacts.stream().filter(
                                        el->el.getCity().equals(state)).toList()
                                );
                        contactsByState.addAll(contactsByCityFilter);
                    }
                    System.out.println(contactsByState);
                    break;
                case 6:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Enter The Wrong Opration Number");
            }
        } while (opration != 6);

        System.out.println();

    }
}
