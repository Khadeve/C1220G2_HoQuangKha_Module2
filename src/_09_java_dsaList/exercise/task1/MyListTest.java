package _09_java_dsaList.exercise.task1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> countries = new MyList<>();

        /*test add methods*/
        countries.add("Vietnam");
        countries.add(1, "USA");
        countries.add(0, "Germany");
        countries.add(1, "Japan");

        System.out.println("Test add methods:");
        System.out.println(countries);

        /*test remove method*/
        System.out.println("-------------------------------------------------");
        System.out.println("The removed element: " + countries.remove(2));
        System.out.println("Test remove method:");
        System.out.println(countries);

        /*Test clone method*/
        System.out.println("-------------------------------------------------");
        try {
            MyList<String> cloned = countries.clone();
            System.out.println("Cloned:");
            System.out.println(cloned);
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }

        /*Test contains method*/
        System.out.println("-------------------------------------------------");
        System.out.println("Has Germany? " + countries.contains("Germany"));
        System.out.println("Has Korea? " + countries.contains("Korea"));

        /*Test indexOf method*/
        System.out.println("-------------------------------------------------");
        System.out.println("The index of Japan " + countries.indexOf("Japan"));
        System.out.println("The index of Australia " + countries.indexOf("Australia"));

        /*Test get method*/
        System.out.println("-------------------------------------------------");
        System.out.println("Element 2: " + countries.get(2));
//        System.out.println("Element 3: " + countries.get(3)); //error

        /*Test clear method*/
        System.out.println("-------------------------------------------------");
        countries.clear();
        System.out.println("After-removing all elements:");
        System.out.println(countries);
    }
}
