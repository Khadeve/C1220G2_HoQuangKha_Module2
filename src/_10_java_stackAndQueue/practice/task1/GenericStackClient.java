package _10_java_stackAndQueue.practice.task1;

public class GenericStackClient {

    private static void stackOfStrings() {
        MyGenericStack<String> clientStack = new MyGenericStack<>();

        clientStack.push("five");
        clientStack.push("four");
        clientStack.push("three");
        clientStack.push("two");
        clientStack.push("one");

        System.out.println("1. The size of stack after pushing operation: " + clientStack.size());

        System.out.println("2. Pop all elements from the stack:");
        while(!clientStack.isEmpty()) {
            System.out.printf(" %s\n", clientStack.pop());
        }
        System.out.println("3. The size of the stack after popping operation: " + clientStack.size());
    }

    /*private static void stackOfIntegers() {
        MyGenericStack<Integer> clientStack = new MyGeneric

        clientStack.push("five");
        clientStack.push("four");
        clientStack.push("three");
        clientStack.push("two");
        clientStack.push("one");

        System.out.println("1. The size of stack after pushing operation: " + clientStack.size());

        System.out.println("2. Pop all elements from the stack:");
        while(!clientStack.isEmpty()) {
            System.out.printf(" %s\n", clientStack.pop());
        }
        System.out.println("3. The size of the stack after popping operation: " + clientStack.size());
    }*/

    public static void main(String[] args) {
        stackOfStrings();
    }
}
