package _05_java_access_modifier.practices;

public class StaticProperty {
    static class Car {
        private String brand;
        private String model;
        private static int numberOfCars = 0;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getModel() {
            return model;
        }

        Car (String carBrand, String carModel) {
            this.brand = carBrand;
            this.model = carModel;
            numberOfCars++;
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Vinfase", "SUV3");
        System.out.println("Number of cars: " + Car.numberOfCars);

        Car car2 = new Car("Toyota", "Camry");
        System.out.println("Number of cars: " + Car.numberOfCars);
    }
}
