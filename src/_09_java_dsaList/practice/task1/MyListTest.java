package _09_java_dsaList.practice.task1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerList = new MyList<>();

        //fill up the integerList with integers.
        for (int i = 1; i < 5; i++) {
            integerList.push(i);
        }

        int size = integerList.getSize();
        System.out.println("All elements:");
        int i;
        for (i = 1; i <= size; i++) {
            System.out.println("element " + i + ": " + integerList.get(i - 1));
        }

//        System.out.println("element " + i + ":" + integerList.get(i - 1));
        System.out.println("element -1: " + integerList.get(-1));
    }
}
