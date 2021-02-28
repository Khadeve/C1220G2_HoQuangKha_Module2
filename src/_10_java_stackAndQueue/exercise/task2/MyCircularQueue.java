package _10_java_stackAndQueue.exercise.task2;

public class MyCircularQueue<E> {

    private Link front;
    private Link rear;

    public MyCircularQueue() {
        front = null;
        rear = null;
    }

    /**
     * append the new link at the end of the queue.
     *
     * @param data - data of the new link.
     */
    public void enQueue(E data) {
        Link newLink = new Link(data);

        if (front == null) {
            front = newLink;
        } else {
            rear.next = newLink;
        }
        rear = newLink;
        rear.next = front;
    }

    /**
     * remove the first element in the queue.
     *
     * @return the removed element.
     */
    public E deQueue() {
        //if the queue is empty.
        if (front == null) {
            System.out.println("The queue is empty.");
            return null;
        }

        //if the queue has only one link.
        if (front == rear) {
            Link temp = front;
            front = rear = null;
            return temp.data;
        }

        //if the queue has more than one link.
        Link temp = front;
        front = front.next;
        rear.next = front;
        return temp.data;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("The queue is empty");
        } else {
            StringBuilder result = new StringBuilder();
            result.append("[");

            Link iter = front;
            while(iter != rear) {
                result.append(iter.data).append(", ");
                iter = iter.next;
            }
            result.append(rear.data).append("]");

            System.out.println("Queue" + result.toString());
        }
    }

    private class Link {
        E data;
        Link next;

        Link(E data) {
            this.data = data;
            next = null;
        }
    }
}
