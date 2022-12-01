package com.bridgelabz;

import java.util.ArrayList;

public class AddressBook {
    static ArrayList<ContactPerson> contactPersons = new ArrayList<ContactPerson>();

    static void addPerson(ContactPerson person){
        contactPersons.add(person);
    }

    static void deleteContact(String name){
        for (int i = 0; i < contactPersons.size(); i++){
            if(contactPersons.get(i).firstName == name){
                contactPersons.remove(i);
            }
        }
    }

    static void editContactPerson(String name, ContactPerson person){
        for (int i = 0; i < contactPersons.size(); i++){
            if(contactPersons.get(i).firstName == name){
                contactPersons.set(i,person);
            }
        }
    }

    static void showContacts(){
        for (int i = 0; i < contactPersons.size(); i++)
            System.out.println(contactPersons.get(i).firstName + " " +
                    contactPersons.get(i).lastName + " -> " + contactPersons.get(i).phoneNumber);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        ContactPerson kavya = new ContactPerson(
                "kavya",
                "ganesh",
                "kollam",
                "koyilandy",
                "kerla",
                "673529",
                "9496107658",
                "kavyasreejganesh97@gmail.com"
        );

        ContactPerson keerthana = new ContactPerson(
                "keerthana",
                "ganesh",
                "kollam",
                "koyilandy",
                "kerla",
                "673529",
                "9496107658",
                "kavyasreejganesh97@gmail.com"
        );

        ContactPerson ganesh = new ContactPerson(
                "Ganesh",
                "V V",
                "kollam",
                "koyilandy",
                "kerla",
                "673529",
                "9496107658",
                "kavyasreejganesh97@gmail.com"
        );

        addPerson(kavya);
        addPerson(keerthana);

        showContacts();

        editContactPerson("keerthana", ganesh);



        showContacts();

        deleteContact("Ganesh");
        showContacts();
    }
}
