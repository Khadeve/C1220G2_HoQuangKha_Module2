package _04_java_class_object.exercises;

import java.util.Date;
import java.util.Scanner;

public class StopWatch {

    private Date startTime;
    private Date endTime;

    public StopWatch() {
        this.startTime = new Date();
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = new Date();
    }

    public void end() {
        this.endTime = new Date();
    }

    public long getElapsedTime() {
        return this.endTime.getTime() - this.startTime.getTime();
    }

    public static int[] createRandomArray() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the amount of elements: ");
        int amountOfElmnts = in.nextInt();

        int[] arr = new int[amountOfElmnts];
        for (int i = 0; i < amountOfElmnts; i++) {
            arr[i] = (int)(Math.random() * amountOfElmnts);
        }

        return arr;
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();

        watch.start();
        int[] arr = createRandomArray();
        watch.end();

        System.out.println("The process time: " + watch.getElapsedTime() + "ms");
    }

}
