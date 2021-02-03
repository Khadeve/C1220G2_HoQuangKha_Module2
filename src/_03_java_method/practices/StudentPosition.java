package _03_java_method.practices;

import java.util.Scanner;

public class StudentPosition {

    //find position of student in list.
    public static int findStudentInList(String[] list, String student) {
        int pos = -1;
        for (int i = 0; i < list.length; i++) {
            if (student.equals(list[i])) {
                return i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        Scanner in = new Scanner(System.in);
        System.out.print("Enter name of the student: ");
        String name = in.nextLine();

        int res = findStudentInList(students, name);
        if (res == -1) {
            System.out.println("The student is not in the list.");
        } else {
            System.out.println("The student is at " + res + " position in the list.");
        }
    }
}
