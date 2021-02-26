package _07_java_abstraction.practice.task3;

import _06_java_inheritance.practice.geometry.*;

import java.util.Arrays;

public class ComparatorTest {
    public static void main(String[] args) {
        //test CircleComparator.
        Circle[] circles = new Circle[3];

        circles[0] = new Circle();
        circles[1] = new Circle(5.5);
        circles[2] = new Circle("red", false, 3.5);

        Arrays.sort(circles, new CircleComparator());

        for (Circle c : circles) {
            System.out.println(c);
        }

        //test RectangleComparator.
        Rectangle[] rectangles = new Rectangle[3];

        rectangles[0] = new Rectangle(5, 6);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle("blue", false, 2,3);

        Arrays.sort(rectangles, new RectangleComparator());

        System.out.println("---------------------------------------");
        for (Rectangle r : rectangles) {
            System.out.println(r);
        }

        //test SquareComparator.
        Square[] squares = new Square[3];

        squares[0] = new Square(5.5);
        squares[1] = new Square("black", false, 6.5);
        squares[2] = new Square();

        Arrays.sort(squares, new SquareComparator());

        System.out.println("----------------------------------------");
        for (Square s : squares) {
            System.out.println(s);
        }
    }
}
