package _11_java_javaCollectionsFramework.practice.task2;

import _10_java_stackAndQueue.exercise.task7_optional.Employee;
import java.util.*;

public class HashSetAndHashMapTest {
    public static void main(String[] args) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Set<Employee> employeeSet = new HashSet<>();

        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Khang Ho", "male", 2006, 9, 24);
        staff[1] = new Employee("Ai Nu", "female", 1995, 2, 22);
        staff[2] = new Employee("Hoai Do", "male", 1995, 2, 9);

        int id = 1;
        for (Employee e : staff) {
            employeeMap.put(id++, e);
            employeeSet.add(e);
        }

        System.out.println("Employees in map:");
        employeeMap.forEach((K, V) ->
                System.out.println("{" + K + "," + V + "}"));

        System.out.println("-----------------------------------------");
        System.out.println("Employees in set:");
        for (Employee e : employeeSet) {
            System.out.println("{" + e + "}");
        }

    }
}
