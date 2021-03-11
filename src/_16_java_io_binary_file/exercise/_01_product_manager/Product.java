package _16_java_io_binary_file.exercise._01_product_manager;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private String brand;
    private double price;
    private int productionYear;

    public Product() {
    }

    public Product(String code, String name, String brand, double price, int productionYear) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.productionYear = productionYear;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", productionYear=" + productionYear +
                '}';
    }
}
