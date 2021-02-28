package _10_java_stackAndQueue.practice.task2;

public class MyLinkedListQueue {

    private Link head;
    private Link tail;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(int key) {
        Link newLink = new Link(key);

        if (head == null) {
            head = tail = newLink;
            return;
        }

        tail.next = newLink;
        tail = newLink;
    }

    public Link dequeue() {
        if (head == null) return null;
        Link first = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return first;
    }

    private class Link {
        public int key;
        public Link next;

        public Link(int key) {
            this.key = key;
            next = null;
        }
    }
}
