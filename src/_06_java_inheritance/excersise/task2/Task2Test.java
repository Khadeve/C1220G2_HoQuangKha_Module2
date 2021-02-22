package _06_java_inheritance.excersise.task2;

import java.util.Arrays;

public class Task2Test {
    public static void main(String[] args) {
        Point2D rootPoint = new Point2D();
        System.out.println(rootPoint);

        Point2D a = new Point2D(4.5f,5.6f);
        System.out.println(a);

        a.setXY(6.5f, 7.6f);
        System.out.println(Arrays.toString(a.getXY()));

        Point3D b = new Point3D();
        System.out.println(b);

        Point3D c = new Point3D(1.5f, 2.5f, 3.5f);
        c.setXYZ(-1.5f, -2.5f, -3.5f);
        System.out.println(Arrays.toString(c.getXYZ()));
    }
}
