package _07_java_abstraction.exercise.task1;


public class Rectangle extends Shape implements Resizable {

    private double width;
    private double height;

    public Rectangle() {
        width = height = 1.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, boolean isFilled, double width, double height) {
        super(color, isFilled);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() { return width * height; }

    @Override
    public String toString() {
        return super.toString() + "[area=" + getArea() + "]";
    }

    @Override
    public void resize(double byPercent) {
        width += (byPercent / 100) * width;
        height += (byPercent / 100) * height;
    }
}
