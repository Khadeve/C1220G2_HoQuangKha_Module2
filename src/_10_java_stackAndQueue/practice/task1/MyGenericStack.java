package _10_java_stackAndQueue.practice.task1;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    /**
     * append a new element into the stack.
     *
     * @param element - new element.
     */
    public void push(T element) {
        stack.addLast(element);
    }

    /**
     * remove and retrieve the last element in the stack.
     *
     * @return the last element in the stack.
     */
    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeLast();
    }

    /**
     * find the number of elements in the stack.
     *
     * @return the number of elements.
     */
    public int size() {
        return stack.size();
    }

    /**
     * check whether this stack is empty.
     *
     * @return true if stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
