package _05_java_access_modifier.exercises;

import java.lang.Math;

public class TestCircle {

    public static final String RED_COLOR = "red";

    static class Circle {
        private double radius = 1.0;
        private String color = RED_COLOR;

        Circle() { }
        Circle (double r) {
            this.radius = r;
        }

        private double getRadius() {
            return this.radius;
        }

        public double getArea() {
            return Math.PI * this.radius * this.radius;
        }
    }

    public static void main(String[] args) {
        Circle myCircle = new Circle();
        Circle yourCircle = new Circle(1.5);

        System.out.println("My circle - radius: " + myCircle.getRadius() + ", area: " + myCircle.getArea());
        System.out.println("Your circle - radius: " + yourCircle.getRadius() + ", area: " + yourCircle.getArea());
    }
}
