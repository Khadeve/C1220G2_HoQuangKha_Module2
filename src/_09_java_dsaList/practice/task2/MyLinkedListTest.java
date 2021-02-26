package _09_java_dsaList.practice.task2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> friends = new MyLinkedList<>();

        friends.addFirst("Kha");
        friends.addFirst("Hoai");

        friends.insert(1, "Nhan");
        friends.insert(2, "Nu");

        System.out.println("The list:");
        friends.printList();

//        System.out.println("The element " + 1 + ": " + friends.get(1));
    }
}
