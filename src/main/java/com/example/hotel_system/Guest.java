package com.example.hotel_system;

public class Guest {
    private final String name;
    private final String mobileNumber;
    private final String email;
    private final String gender;
    private final String nationality;
    private final String nationalID;

    public Guest(String name, String mobileNumber, String email,
                 String gender, String nationality, String nationalID) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.gender = gender;
        this.nationality = nationality;
        this.nationalID = nationalID;
    }

    public String getName() { return name; }
    public String getMobileNumber() { return mobileNumber; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public String getNationality() { return nationality; }
    public String getNationalID() { return nationalID; }
}
