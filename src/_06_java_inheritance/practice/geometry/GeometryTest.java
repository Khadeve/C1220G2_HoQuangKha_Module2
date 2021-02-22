package _06_java_inheritance.practice.geometry;

public class GeometryTest {
    public static final String GREEN = "green";
    public static final String RED = "red";

    public static void main(String[] args) {
        Shape aShape = new Shape();
        System.out.println(aShape);

        Shape anotherShape = new Shape(RED, false);
        System.out.println(anotherShape);

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(2.5);
        System.out.println(circle);

        circle = new Circle(RED, false, 3.5);
        System.out.println(circle);

        Rectangle rec = new Rectangle();
        System.out.println(rec);

        rec = new Rectangle(2.5, 3.5);
        System.out.println(rec);

        rec = new Rectangle(GREEN, false, 4.5, 5.5);
        System.out.println(rec);

        Square sq = new Square();
        System.out.println(sq);

        sq = new Square(5);
        System.out.println(sq);

        sq = new Square(RED, false, 6);
        System.out.println(sq);
    }
}
