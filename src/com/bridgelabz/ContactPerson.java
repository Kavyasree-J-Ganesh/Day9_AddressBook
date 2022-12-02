package com.bridgelabz;

public class ContactPerson {
    ContactPerson(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phoneNumber,
            String email
    ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;
}
