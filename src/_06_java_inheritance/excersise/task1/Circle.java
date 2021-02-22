package _06_java_inheritance.excersise.task1;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 1.0;
        color = "yellow";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[radius=" + radius
                + ",color=" + color
                + "]";
    }
}
