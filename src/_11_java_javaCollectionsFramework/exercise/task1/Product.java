package _11_java_javaCollectionsFramework.exercise.task1;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product> {

    private static int nextID = 1;

    private String name;
    private int id;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.id = nextID++;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product[name:" + name +
                ",id:" + id +
                ",price:" + price + "$" +
                "]";
    }

    @Override
    public int compareTo(@NotNull Product o) {
        return id - o.id;
    }
}
