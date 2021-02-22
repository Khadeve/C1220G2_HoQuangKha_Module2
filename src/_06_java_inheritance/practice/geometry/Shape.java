package _06_java_inheritance.practice.geometry;

public class Shape {
    private String color = GeometryTest.GREEN;
    private boolean isFilled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.isFilled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    @Override
    public String toString() {
        String fillState = isFilled() ? "filled" : "not filled";
        return getClass().getName() + "[color=" + color + ",isFilled=" + fillState + "]";
    }
}
