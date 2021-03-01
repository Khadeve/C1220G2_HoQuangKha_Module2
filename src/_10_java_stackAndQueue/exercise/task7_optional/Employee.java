package _10_java_stackAndQueue.exercise.task7_optional;

import org.jetbrains.annotations.NotNull;

import java.io.PrintWriter;
import java.time.*;
import java.util.*;

public class Employee implements Comparable<Employee> {
    private String name;
    private String gender;
    LocalDate birthday;

    public Employee(String name, String gender, int year, int month, int day) {
        this.name = name;
        this.gender = gender;
        birthday = LocalDate.of(year, month, day);
    }

    /**
     * Write information of this employee into a PrintWriter object.
     *
     * @param out - PrintWriter object.
     */
    public static void writeEmployee(PrintWriter out, Employee employee) {
        out.println(employee.name + "|" + employee.gender + "|" + employee.birthday);
    }

    public static Employee readEmployee(Scanner fin) {
        String line = fin.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        String gender = tokens[1];
        LocalDate birthday = LocalDate.parse(tokens[2]);

        int year = birthday.getYear();
        int month = birthday.getMonthValue();
        int day = birthday.getDayOfMonth();

        return new Employee(name, gender, year, month, day);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(int year, int month, int day) {
        birthday = LocalDate.of(year, month, day);
    }


    @Override
    public int compareTo(@NotNull Employee o) {
        return birthday.compareTo(o.birthday);
    }
}
