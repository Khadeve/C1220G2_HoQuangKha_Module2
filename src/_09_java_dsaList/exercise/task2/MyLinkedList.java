package _09_java_dsaList.exercise.task2;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Cloneable {

    private Link head;
    private int numberOfLinks;

    public MyLinkedList() {
        head = null;
        numberOfLinks = 0;
    }

    public int size() {
        return numberOfLinks;
    }

    public void addFirst(E element) {
        Link newLink = new Link(element);
        newLink.next = head;
        head = newLink;
        numberOfLinks++;
    }

    public void addLast(E element) {
        Link newLink = new Link(element);
        if (numberOfLinks == 0) {
            head = newLink;
        } else {
            //get the last link.
            Link tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newLink;
        }
        numberOfLinks++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == numberOfLinks) {
            addLast(element);
        } else {
            Link newLink = new Link(element);
            Link currentLink = head;
            Link previousLink = null;
            for (int i = 0; i < index && currentLink.next != null; i++) {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
            newLink.next = currentLink;
            assert previousLink != null;
            previousLink.next = newLink;
        }
        numberOfLinks++;
    }

    //remove the first element in the list, return null if the list is empty.
    public E poll() {
        if (numberOfLinks == 0) return null;
        Link temp = head;
        head = head.next;
        return temp.data;
    }

    //remove the last element in the list, throw NoSuchElementException if the list is empty.
    public E removeLast() {
        if (numberOfLinks == 0) {
            throw new NoSuchElementException();
        }
        if (numberOfLinks == 1) {
            Link temp = head;
            poll();
            numberOfLinks--;
            return temp.data;
        }
        //get the last element.
        Link tail = head;
        Link previousTail = null;
        while (tail.next != null) {
            previousTail = tail;
            tail = tail.next;
        }
        assert previousTail != null;
        previousTail.next = null;
        numberOfLinks--;
        return tail.data;
    }

    public E remove(int index) {
        if (index < 0 || index >= numberOfLinks) {
            throw new IndexOutOfBoundsException();
        }

        E removedData;

        if (index == 0) {
            removedData = poll();
        } else if (index == numberOfLinks - 1) {
            removedData = removeLast();
        } else {
            Link currentLink = head;
            Link previousLink = null;
            for (int i = 0; i < index && currentLink != null; i++) {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
            assert currentLink != null;
            removedData = currentLink.data;
            previousLink.next = currentLink.next;
        }
        numberOfLinks--;
        return removedData;
    }

    /**
     * remove the first element equivalent with a given object.
     *
     * @return true - if the list is changed after the method call, otherwise false.
     */
    public boolean remove(Object o) {
        Link temp = head;
        for (int i = 0; i < numberOfLinks; i++) {
            if (o == null) {
                if (temp.data == null) {
                    remove(i);
                    numberOfLinks--;
                    return true;
                }
            } else {
                if (temp.data.equals(o)) {
                    remove(i);
                    numberOfLinks--;
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * check whether a given object is in this list.
     *
     * @return true - if given object is in the list, otherwise false.
     */
    public boolean contains(E o) {
        Link temp = head;
        for (int i = 0; i < numberOfLinks; i++) {
            if (o == null) {
                if (temp.data == null) {
                    return true;
                }
            } else {
                if (temp.data.equals(o)) {
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * find the index of the first element equivalent with a given object.
     *
     * @return the index of the first equivalent element, or -1 if there is no such element.
     */
    public int indexOf(E o) {
        Link temp = head;
        for (int i = 0; i < numberOfLinks; i++) {
            if (o == null) {
                if (temp.data == null) {
                    return i;
                }
            } else {
                if (temp.data.equals(o)) {
                    return i;
                }
            }
            temp = temp.next;
        }
        return -1;
    }

    /**
    * append the specified element into this list.
    *
    * @return true
    */
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public E getFirst() {
        if (numberOfLinks == 0) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public E getLast() {
        if (numberOfLinks == 0) {
            throw new NoSuchElementException();
        }
        Link tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail.data;
    }

    public E get(int index) {
        if (index < 0 || index >= numberOfLinks) {
            throw new IndexOutOfBoundsException();
        }
        Link currentLink = head;
        for (int i = 0; i < index; i++) {
            currentLink = currentLink.next;
        }
        return currentLink.data;
    }

    public void clear() {
        head = null;
        numberOfLinks = 0;
    }

    /**
     * clone this list
     *
     * @return a clone of this list.
     */
    @Override
    public MyLinkedList<E> clone() throws CloneNotSupportedException {
        return (MyLinkedList<E>) super.clone();
    }

    //print out all elements in the list
    public void printOut() {
        Link cur = head;
        while (cur != null) {
            System.out.println(cur.getData());
            cur = cur.next;
        }
    }

    private class Link {
        private Link next;
        private E data;

        public Link(E data) {
            next = null;
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }
}
