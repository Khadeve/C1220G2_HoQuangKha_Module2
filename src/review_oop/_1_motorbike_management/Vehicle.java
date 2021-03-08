package review_oop._1_motorbike_management;

public class Vehicle {
    private static final double LOWEST_TAX = 1;
    private static final double MEDIUM_TAX = 3;
    private static final double HIGHEST_TAX = 5;
    private static final int VOLUME_100CC = 100;
    private static final int VOLUME_200CC = 200;

    private double price;
    private int cylinderVolume;

    public Vehicle() {
    }

    public Vehicle(double price, int cylinderVolume) {
        this.price = price;
        this.cylinderVolume = cylinderVolume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCylinderVolume() {
        return cylinderVolume;
    }

    public void setCylinderVolume(int cylinderVolume) {
        this.cylinderVolume = cylinderVolume;
    }

    /**
     * Calculate the tax for this vehicle.
     */
    public double calculateTax() {
        if (cylinderVolume < VOLUME_100CC) {
            return price * (LOWEST_TAX / 100);
        }
        if (cylinderVolume <= VOLUME_200CC) {
            return price * (MEDIUM_TAX / 100);
        }
        return price * (HIGHEST_TAX / 100);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "price=" + price + "$" +
                ", cylinderVolume=" + cylinderVolume +
                ", tax=" + calculateTax() +
                '}';
    }
}
