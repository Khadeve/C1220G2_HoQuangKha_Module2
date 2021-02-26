package _07_java_abstraction.practice.task2;


import _06_java_inheritance.practice.geometry.*;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    public int compareTo(ComparableCircle other) {
        if (getRadius() > other.getRadius()) return 1;
        else if (getRadius() == other.getRadius()) return 0;
        return -1;
    }
}
