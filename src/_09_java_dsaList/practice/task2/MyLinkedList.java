package _09_java_dsaList.practice.task2;

public class MyLinkedList<E> {

    private Link head;
    private Link tail;
    private int numberOfLinks;

    //construct an empty list
    public MyLinkedList() {
        head = null;
        tail = null;
        numberOfLinks = 0;
    }

    //construct a list with one element.
    public MyLinkedList(E data) {
        Link newLink = new Link(data);
        head = newLink;
        tail = newLink;
        numberOfLinks++;
    }

    //add a new link into the list.
    public void addFirst(E element) {
        Link newLink = new Link(element);

        //if list is empty.
        if (numberOfLinks == 0) {
            head = tail = newLink;
        } else {
            newLink.next = head;
            head.previous = newLink;
            head = newLink;
        }
        numberOfLinks++;
    }

    //insert a new link at index i.
    public void insert(int i, E data) {
        Link newLink = new Link(data);

        if (numberOfLinks == 0) {
            head = tail = newLink;
        } else {
            if (i <= 1) {
                addFirst(data);
            } else {
                Link temp = head;
                Link previousTemp = temp.next;
                for (int count = 1; count < i && temp.next != null; count++) {
                    previousTemp = temp;
                    temp = temp.next;
                }

                newLink.next = temp;
                assert previousTemp != null;
                previousTemp.next = newLink;
                temp.previous = newLink;
                newLink.previous = previousTemp;
            }

        }
        numberOfLinks++;
    }

    //get an element at index.
    public Link get(int index) {
        Link temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //print out all elements in the list.
    public void printList() {
        Link temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private class Link {
        public E data;
        Link next;
        Link previous;

        Link(E data) {
            this.data = data;
            next = null;
            previous = null;
        }

        E getData() {
            return data;
        }
    }
}
