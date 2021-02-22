package _06_java_inheritance.excersise.task1;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        height = 5;
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return (2 * Math.PI * getRadius() * height) + (2 * Math.PI * getRadius() * getRadius());
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * getRadius() * height);
    }

    public double getVolume() {
        return Math.PI * getRadius() * getRadius() * height;
    }

    @Override
    public String toString() {
        return super.toString()
                + "[height="
                + height
                + "]";
    }
}
