package furamaResort.models;

import java.io.*;

public abstract class Services {

    private String serviceName;
    private String id;
    private double area;
    private double price;
    private int largestNumberOfGuests;
    private String typeOfRental;

    public Services() {
    }

    public Services(String serviceName, String id, double area, double price, int largestNumberOfGuests, String typeOfRental) {
        this.serviceName = serviceName;
        this.area = area;
        this.price = price;
        this.largestNumberOfGuests = largestNumberOfGuests;
        this.typeOfRental = typeOfRental;
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    public int getLargestNumberOfGuests() {
        return largestNumberOfGuests;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public String getId() {
        return id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLargestNumberOfGuests(int largestNumberOfGuests) {
        this.largestNumberOfGuests = largestNumberOfGuests;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void writeService(PrintWriter out) {
        out.print(serviceName + "," + id + "," + area + "," + price + "," +
                largestNumberOfGuests + "," + typeOfRental + ",");
    }

    public abstract void showInfor();
}
