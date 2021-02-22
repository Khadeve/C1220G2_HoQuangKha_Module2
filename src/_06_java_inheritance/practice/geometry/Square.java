package _06_java_inheritance.practice.geometry;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean isFilled, double side) {
        super(color, isFilled, side, side);
    }

    public double getSide() {
        return super.getHeight();
    }

    public void setSide(double side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[side=" + super.getHeight() + "]";
    }
}
