package _09_java_dsaList.exercise.task1;

import java.util.Arrays;

public class MyList<E> implements Cloneable {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException(initialCapacity + " is negative.");
        }
        elements = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(int index, E newElement) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = newElement;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        @SuppressWarnings("unchecked")
        E removedElement = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements = Arrays.copyOf(elements, size);
        return removedElement;
    }

    @Override
    public MyList<E> clone() throws CloneNotSupportedException {
        return (MyList<E>) super.clone();
    }

    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)) return i;
            }
        }
        return -1;
    }

    //append a new element e into the end of the list.
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    //increase the capacity of this ArrayList to ensure it can hold the desired minimum capacity.
    public void ensureCapacity(int minCapacity) {
        if (elements.length < minCapacity) {
            elements = Arrays.copyOf(elements, minCapacity * 2);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("MyList[");

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result.append(elements[i]);
                break;
            }
            result.append(elements[i]).append(",");
        }
        result.append("]");

        return result.toString();
    }
}
