package _18_review_oop._3_fruit_shop.models;

public class Fruit {
    private static int nextId = 1;

    private int id;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitName, double price, int quantity, String origin) {
        this.id = nextId++;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit(int id, String fruitName, double price, int quantity, String origin) {
        this.id = id;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void resetNextId() {
        nextId = 0;
    }

    public static void setNextId(int aNextId) {nextId = aNextId; }

    @Override
    public String toString() {
        return id + "," + fruitName + "," + price + "$," + quantity + "," + origin;
    }

    public void showInfor() {
        String infor = "Fruit{" +
                "id=" + id +
                ", fruitName='" + fruitName + '\'' +
                ", price=" + price + "$" +
                ", quantity=" + quantity +
                ", origin='" + origin + '\'' +
                '}';
        System.out.println(infor);
    }
}
