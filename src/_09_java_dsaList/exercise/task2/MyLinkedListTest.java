package _09_java_dsaList.exercise.task2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> animals = new MyLinkedList<>();

        /*Test addFirst method*/
        System.out.println("-----------------------------------------------");
        animals.addFirst("Rabbit");
        animals.addFirst("Lion");
        System.out.println("Test addFirst:");
        animals.printOut();

        //Test addLast method
        System.out.println("-----------------------------------------------");
        animals.addLast("Bear");
        System.out.println("Test addLast:");
        animals.printOut();

        //Test add method
        System.out.println("-----------------------------------------------");
        animals.add(0, "Tiger");
        animals.add(1, "Wolf");
        animals.add(2, "Fish");
        System.out.println("Test add:");
        animals.printOut();

        /*//Test poll method
        System.out.println("-----------------------------------------------");
        animals.poll();
        System.out.println("Test poll:");
        animals.printOut();

        *//*Test removeLast method*//*
        System.out.println("-----------------------------------------------");
        animals.removeLast();
        System.out.println("Test removeLast:");
        animals.printOut();*/

        //Test remove(int) method.
        System.out.println("-----------------------------------------------");
        animals.remove(0);
        animals.remove(animals.size() - 1);
        animals.remove(1);
        System.out.println("Test remove(int):");
        animals.printOut();

        //Test remove(Object).
        System.out.println("-----------------------------------------------");
        System.out.println("Test remove(Object): " + animals.remove("Fish"));
        animals.printOut();

        //Test clone method.
        System.out.println("-----------------------------------------------");
        try {
            MyLinkedList<String> cloned = animals.clone();
            System.out.println("The cloned list:");
            cloned.printOut();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //Test contains method.
        System.out.println("-----------------------------------------------");
        System.out.println("Test contains method:");
        System.out.println("Has Wolf: " + animals.contains("Wolf"));
        System.out.println("Has Cow: " + animals.contains("Cow"));

    }
}
