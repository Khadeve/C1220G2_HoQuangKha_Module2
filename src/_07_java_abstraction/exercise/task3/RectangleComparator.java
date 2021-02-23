package _07_java_abstraction.exercise.task3;

import _06_java_inheritance.practice.geometry.Rectangle;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        if (r1.getArea() > r2.getArea()) return 1;
        else if (r1.getArea() < r2.getArea()) return -1;
        return 0;
    }
}
