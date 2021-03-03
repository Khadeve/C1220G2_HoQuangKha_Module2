package _11_java_javaCollectionsFramework.practice.task3;

import java.util.ArrayList;
import java.util.*;

public class ComparableAndComparatorTest {
    public static void main(String[] args) {
        Student[] buddies = new Student[4];

        buddies[0] = new Student("Kha Ho", 26, "Binh Dinh");
        buddies[1] = new Student("Khang Ho", 15, "Quy Nhon");
        buddies[2] = new Student("Hoai Do", 26, "Hoai Nhon");
        buddies[3] = new Student("Nu Ai", 21, "Phuoc An");

        ArrayList<Student> students = new ArrayList<>(Arrays.asList(buddies));
        //students.addAll(Arrays.asList(buddies));

        Collections.sort(students);
        System.out.println("Sort by age:");
        students.forEach(System.out::println);

        students.sort(new ComparatorByName());
        System.out.println("----------------------------------");
        System.out.println("Sort by name:");
        students.forEach(System.out::println);
    }
}
