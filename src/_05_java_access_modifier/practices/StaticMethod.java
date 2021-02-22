package _05_java_access_modifier.practices;

public class StaticMethod {
    public static class Student {
        private int rollno;
        private String name;
        private static String schoolName = "Codegym";

        Student(int r, String n) {
            this.rollno = r;
            this.name = n;
        }

        static void changeSchool() {
            schoolName = "Gymcode";
        }

        void displayStudent() {
            System.out.println(this.name + " - " + this.rollno + " - " + schoolName);
        }
    }

    public static void main(String[] args) {
        Student.changeSchool();

        Student student1 = new Student(1, "Kha");
        Student student2 = new Student(2, "Khang");
        Student student3 = new Student(3, "Khoi");

        student1.displayStudent();
        student2.displayStudent();
        student3.displayStudent();
    }
}
