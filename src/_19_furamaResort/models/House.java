package furamaResort.models;

import java.io.PrintWriter;

public class House extends Service {
    private String classificationOfRoom;
    private String utilities;
    private int numberOfFloors;

    public House() {
    }

    public House(String serviceName, String id, double area, double price, int largestNumberOfGuests, String typeOfRental, String classificationOfRoom, String utilities, int numberOfFloors) {
        super(serviceName, id, area, price, largestNumberOfGuests, typeOfRental);
        this.classificationOfRoom = classificationOfRoom;
        this.utilities = utilities;
        this.numberOfFloors = numberOfFloors;
    }

    public String getClassificationOfRoom() {
        return classificationOfRoom;
    }

    public void setClassificationOfRoom(String classificationOfRoom) {
        this.classificationOfRoom = classificationOfRoom;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    /*@Override
    public void writeService(PrintWriter out) {
        super.writeService(out);
        out.println(classificationOfRoom + "," + utilities + "," + numberOfFloors);
    }*/

    @Override
    public String toString() {
        return super.toString() + classificationOfRoom + "," + utilities + "," + numberOfFloors;
    }

    /*@Override
    public String toString() {
        return super.toString() +
                "\nHouse{" +
                "\n7. classificationOfRoom='" + classificationOfRoom +
                "\n8. utilities='" + utilities +
                "\n9. numberOfFloors=" + numberOfFloors +
                "\n}";
    }*/


    @Override
    public void showInfor() {
        String infor = "House[" +
                "\n1. serviceName: " + super.getServiceName() +
                "\n2. id: " + super.getId() +
                "\n3. area: " + super.getArea() +
                "\n4. price: " + super.getPrice() +
                "\n5. largestNumberOfGuests: " + super.getLargestNumberOfGuests() +
                "\n6. typeOfRental: " + super.getTypeOfRental() +
                "\n7. classificationOfRoom: " + classificationOfRoom +
                "\n8. utilities: " + utilities +
                "\n9. numberOfFloor: " + numberOfFloors +
                "\n]";
        System.out.println("----------------------------------------------------");
        System.out.println(infor);
    }
}
