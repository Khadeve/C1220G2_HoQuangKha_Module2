package _10_java_stackAndQueue.exercise.task7_optional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Task7 {
    public static void main(String[] args) throws IOException {
        Set<Employee> staff = new TreeSet<>();

        staff.add(new Employee("Kha Ho", "male", 2021, 3, 2));
        staff.add(new Employee("Nhan Truong", "male", 2018, 4, 1));
        staff.add(new Employee("Khang Ho", "male", 2019, 3, 1));
        staff.add(new Employee("Ai Nu", "female", 2021, 3, 1));
        staff.add(new Employee("Nha", "female", 2021, 2, 28));


        //write data try-with-resource block.
        try (PrintWriter out = new PrintWriter("D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\_10_java_stackAndQueue\\exercise\\task7_optional\\staff.txt"
                , StandardCharsets.UTF_8)) {
            writeData(out, staff);
        }

        //read data with try-with-resource block.
        try (Scanner fin = new Scanner(new FileInputStream("D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\_10_java_stackAndQueue\\exercise\\task7_optional\\staff.txt")
                , StandardCharsets.UTF_8);
             PrintWriter out = new PrintWriter("D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\_10_java_stackAndQueue\\exercise\\task7_optional\\result.txt",
                     StandardCharsets.UTF_8)) {
            ArrayList<Employee> arrList = readData(fin);
            writeData(out, arrList);
        }
    }

    private static void writeData(PrintWriter out, Collection<? extends Employee> data)
            throws IOException {
        //write the number of employees.
        out.println(data.size());

        for (Employee e : data) {
            Employee.writeEmployee(out, e);
        }
    }

    private static <T extends Employee> ArrayList<T> readData(Scanner fin) {
        //read the number of employee.
        int n = fin.nextInt();
        fin.nextLine(); //consume the newline.

        ArrayDeque<T> females = new ArrayDeque<>();
        ArrayDeque<T> males = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            @SuppressWarnings("unchecked cast")
            T newEmployee = (T) Employee.readEmployee(fin);
            if (newEmployee.getGender().equals("female")) {
                females.addLast(newEmployee);
            } else {
                males.addLast(newEmployee);
            }
        }

        int numberOfFemales = females.size();
        int numberOfMales = males.size();
        ArrayList<T> result = new ArrayList<>(numberOfFemales + numberOfMales);

        result.addAll(females);
        result.addAll(males);

        return result;
    }
}
