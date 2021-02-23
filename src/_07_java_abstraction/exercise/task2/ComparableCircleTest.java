package _07_java_abstraction.exercise.task2;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];

        circles[0] = new ComparableCircle();
        circles[1] = new ComparableCircle(5);
        circles[2] = new ComparableCircle("red", false, 3.5);

        System.out.println("Pre-sorted");
        for (ComparableCircle c : circles) {
            System.out.println(c);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted");
        for (ComparableCircle c : circles) {
            System.out.println(c);
        }
    }
}
