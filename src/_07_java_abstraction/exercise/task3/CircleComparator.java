package _07_java_abstraction.exercise.task3;

import _06_java_inheritance.practice.geometry.Circle;
import java.util.*;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius() > o2.getRadius()) return 1;
        else if (o1.getRadius() < o2.getRadius()) return -1;
        return 0;
    }
}
