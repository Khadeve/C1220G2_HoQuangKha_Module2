package furamaResort.models;

import java.io.PrintWriter;

public class Villa extends Service {
    private String classificationOfRoom;
    private String utilities;
    private double areaOfPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String serviceName, String id, double area, double price, int largestNumberOfGuests, String typeOfRental, String classificationOfRoom, String utilities, double areaOfPool, int numberOfFloors) {
        super(serviceName, id, area, price, largestNumberOfGuests, typeOfRental);
        this.classificationOfRoom = classificationOfRoom;
        this.utilities = utilities;
        this.areaOfPool = areaOfPool;
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

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
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
        out.println(classificationOfRoom + "," + utilities + "," + areaOfPool + "," + numberOfFloors);
    }*/

    @Override
    public String toString() {
        return super.toString() + classificationOfRoom + "," + utilities + "," + areaOfPool + "," + numberOfFloors;
    }

    /*@Override
    public String toString() {
        return super.toString() +
                "\nVilla{" +
                "\n7. classificationOfRoom='" + classificationOfRoom +
                "\n8. utilities='" + utilities +
                "\n9. areaOfPool=" + areaOfPool +
                "\n10. numberOfFloors=" + numberOfFloors +
                "\n}";
    }*/


    @Override
    public void showInfor() {
        String infor = "Villa[" +
                "\n1. serviceName: " + super.getServiceName() +
                "\n2. id: " + super.getId() +
                "\n3. area: " + super.getArea() +
                "\n4. price: " + super.getPrice() +
                "\n5. largestNumberOfGuests: " + super.getLargestNumberOfGuests() +
                "\n6. typeOfRental: " + super.getTypeOfRental() +
                "\n7. classificationOfRoom: " + classificationOfRoom +
                "\n8. utilities: " + utilities +
                "\n9. areaOfPool: " + areaOfPool +
                "\n10. numberOfFloor: " + numberOfFloors +
                "\n]";
        System.out.println("----------------------------------------------------");
        System.out.println(infor);
    }
}
