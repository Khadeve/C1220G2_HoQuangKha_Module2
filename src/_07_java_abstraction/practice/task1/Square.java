package _07_java_abstraction.practice.task1;

import _07_java_abstraction.practice.task2.Colorable;

public class Square extends Rectangle implements Colorable {

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
    public String howToColor() {
        return "Color at four sides";
    }
}
