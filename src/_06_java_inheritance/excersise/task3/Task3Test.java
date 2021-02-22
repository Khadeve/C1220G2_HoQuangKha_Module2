package _06_java_inheritance.excersise.task3;

public class Task3Test {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint();
        System.out.println(point);

        point = new MovablePoint(2, 3);
        point.setXY(1, 2);
        System.out.println(point);

        point = new MovablePoint(1, 2, 0, 0);
        point.setSpeed(2, 3);
        point.move();
        System.out.println(point);
    }
}
