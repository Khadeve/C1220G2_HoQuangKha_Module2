package _06_java_inheritance.excersise.task1;

public class Task1Test {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        System.out.println(myCircle);

        myCircle = new Circle(2.0, "red");
        System.out.println(myCircle);
        System.out.printf("%s%.2f%s%.2f\n", "area=", myCircle.getArea(),
                ",perimeter=", myCircle.getPerimeter());

        Cylinder myCylinder = new Cylinder();
        System.out.println(myCylinder);

        myCylinder = new Cylinder(8);
        System.out.println(myCylinder);

        myCylinder = new Cylinder(3, "pink", 10);
        System.out.println(myCylinder);
        System.out.printf("%s%.2f%s%.2f%s%.2f\n", "area=", myCylinder.getArea(),
                ",perimeter=", myCylinder.getPerimeter(),
                ",volume=", myCylinder.getVolume());
    }
}
