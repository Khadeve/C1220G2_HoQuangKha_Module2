package _07_java_abstraction.practice.task2;

import _07_java_abstraction.practice.task1.*;

public class ColorableInterfaceTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();

        for (Shape s : shapes) {
            System.out.println(s);
            if (s instanceof Colorable) {
                System.out.println(((Square) s).howToColor());
            }
        }
    }
}
