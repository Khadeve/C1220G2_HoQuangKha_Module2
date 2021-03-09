package _10_java_stackAndQueue.exercise.task7_optional;


import java.util.Comparator;

public class CompareByName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
