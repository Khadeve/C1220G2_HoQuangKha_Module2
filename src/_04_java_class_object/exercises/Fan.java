package _04_java_class_object.exercises;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;
    private boolean isOn;
    private double radius;
    private String color;

    Fan() {
        this.speed = SLOW;
        this.isOn = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean getState() {
        return this.isOn;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setSpeed(int level) {
        this.speed = level;
    }

    public void setState(boolean state) {
        this.isOn = state;
    }

    public void setRadius(double rad) {
        this.radius = rad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isOn) {
            return "Fan is on - speed : " + this.speed + " - radius : " + this.radius + " - color : " + this.color;
        } else {
            return "Fan is off - radius : " + this.radius + " - color : " + this.color;
        }
    }

    public static void main(String[] args) {
        //create fan1.
        Fan fan1 = new Fan();
        fan1.setSpeed(10);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setState(true);

        //create fan2.
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);

        System.out.println("Information of fan1:\n" + fan1.toString());
        System.out.println("Information of fan2:\n" + fan2.toString());

    }
}
