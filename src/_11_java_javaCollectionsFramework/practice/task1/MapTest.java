package _11_java_javaCollectionsFramework.practice.task1;

import _10_java_stackAndQueue.exercise.task7_optional.Employee;
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> employeeHashMap = new HashMap<>();

        employeeHashMap.put("001-000-000", new Employee("Kha Ho", "male", 1995, 12, 29));
        employeeHashMap.put("003-000-000", new Employee("Nhan Truong", "male", 1995, 3, 3));
        employeeHashMap.put("002-000-000", new Employee("Ai Nu", "female", 1995, 4, 30));

        //System.out.println("Display entries of the hash map:");
        //System.out.println(employeeHashMap);
        /*employeeHashMap.forEach((K, V) ->
                System.out.println("{" + K + "," + V + "}"));*/
        System.out.println("Employee in hash map:");
        printMap(employeeHashMap);

        Map<String, Employee> employeeTreeMap = new TreeMap<>(employeeHashMap);

        System.out.println("------------------------------------------------");
        System.out.println("Employee in tree map:");
        printMap(employeeTreeMap);

        Map<String, Employee> employeeLinkedHashMap = new LinkedHashMap<>();
        employeeLinkedHashMap.put("005-000-000", new Employee("Hoai Do", "male", 1995, 9, 2));
        employeeLinkedHashMap.put("004-000-000", new Employee("Nha", "female", 1995, 9, 3));

        System.out.println("------------------------------------------------");
        System.out.println("Employee in linked hash map:");
        printMap(employeeLinkedHashMap);
    }

    private static <K, V> void printMap(Map<? extends K, ? extends V> aMap) {
        aMap.forEach((K, V) ->
                System.out.println("{" + K + "," + V + "}"));
    }
}
