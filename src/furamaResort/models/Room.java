package furamaResort.models;

import java.io.PrintWriter;

public class Room extends Services {
    private String freeUtilities;

    public Room() {
    }

    public Room(String serviceName, String id, double area, double price, int largestNumberOfGuests, String typeOfRental, String freeUtilities) {
        super(serviceName, id, area, price, largestNumberOfGuests, typeOfRental);
        this.freeUtilities = freeUtilities;
    }

    public String getFreeUtilities() {
        return freeUtilities;
    }

    public void setFreeUtilities(String freeUtilities) {
        this.freeUtilities = freeUtilities;
    }

    @Override
    public void writeService(PrintWriter out) {
        super.writeService(out);
        out.println(freeUtilities);
    }

    @Override
    public void showInfor() {
        String infor = "Room[" +
                "\n1. serviceName: " + super.getServiceName() +
                "\n2. id: " + super.getId() +
                "\n3. area: " + super.getArea() +
                "\n4. price: " + super.getPrice() +
                "\n5. largestNumberOfGuests: " + super.getLargestNumberOfGuests() +
                "\n6. typeOfRental: " + super.getTypeOfRental() +
                "\n7. freeUtilities: " + freeUtilities +
                "\n]";
        System.out.println("----------------------------------------------------");
        System.out.println(infor);
    }
}
