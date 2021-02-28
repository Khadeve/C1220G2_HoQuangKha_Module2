package _10_java_stackAndQueue.exercise.task2;

public class MyCircularQueueTest {
    public static void main(String[] args) {
        MyCircularQueue<String> myQueue = new MyCircularQueue<>();

        myQueue.enQueue("Ho");
        myQueue.enQueue("Quang");
        myQueue.enQueue("Kha");

        System.out.println("The removed element: " + myQueue.deQueue());
        myQueue.displayQueue();
    }
}
