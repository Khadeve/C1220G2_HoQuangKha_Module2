package furamaResort.models;

public class ServicesTest {

    public static void main(String[] args) {
        Services villa = new Villa("Villa", "001-0010", 200.5, 1000,
                10, "days",
                "4*", "pool + body massage", 50.2, 3);

        Services house = new House("House", "002-0010", 100.5,
                500, 5, "months", "5*",
                "pool + foot massage", 2);

        Services room = new Room("room", "003-0010", 70.5, 300, 3, "hours", "wifi");

        villa.showInfor();
        house.showInfor();
        room.showInfor();
    }

}
