package furamaResort.models;

import java.io.*;
import java.time.LocalDate;

public class Customer {
    private String fullName;
    private String dayOfBirth;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String membership;
    private String address;
    private Service usingService;

    public Customer(){}

    public Customer(String fullName, String dayOfBirth, String gender, String idNumber, String phoneNumber, String email, String membership, String address, Service usingService) {
        this.fullName = fullName;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.membership = membership;
        this.address = address;
        this.usingService = usingService;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDayOfBirth() {
        String[] tokens = dayOfBirth.split("/");
        return LocalDate.of(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[0]));
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getUsingService() {
        return usingService;
    }

    public void setUsingService(Service usingService) {
        this.usingService = usingService;
    }

    @Override
    public String toString() {
        return fullName + "," + dayOfBirth + "," + gender + "," + idNumber + "," + phoneNumber + "," + email +
                "," + membership + "," + address;
    }

    public void showInfor() {
        String infor = "Customer[" +
                "\n1. fullName: " + fullName +
                "\n2. dayOfBirth: " + dayOfBirth +
                "\n3. gender: " + gender +
                "\n4. idNumber: " + idNumber +
                "\n5. phoneNumber: " + phoneNumber +
                "\n6. email: " + email +
                "\n7. membership: " + membership +
                "\n8. address: " + address +
                "\n]";
        System.out.println("----------------------------------------------------");
        System.out.println(infor);
    }
}
