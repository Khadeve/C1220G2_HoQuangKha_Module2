package _09_java_dsaList.practice.task1;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    //non-parameter constructor to initialize an internal array.
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //Increase the length of elements by DEFAULT_CAPACITY if it is full.
    public void ensureCapacity() {
        elements = Arrays.copyOf(elements, elements.length + 10);
    }

    //Add a new element at the end of the list.
    public void push(E newElement) {
        if (elements.length == size) {
            ensureCapacity();
        }
        elements[size++] = newElement;
    }

    public int getSize() {
        return size;
    }

    //Get an element at index i in the list.
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException("[index=" + i + ",size=" + size + "]");
        }
        return (E) elements[i];
    }
}
