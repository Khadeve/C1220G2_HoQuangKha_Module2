package _07_java_abstraction.practice.task1;

public class Circle extends Shape implements Resizable {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean isFilled, double radius) {
        super(color, isFilled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (Math.PI * radius * radius);
    }

    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return super.toString() + "[area=" + getArea() + "]";
    }

    @Override
    public void resize(double byPercent) {
        radius += (byPercent / 100) * radius;
    }
}
