package _11_java_javaCollectionsFramework.practice.task3;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student[name=" + this.name +
                "," + "age=" + this.age +
                "," + "address=" + this.address +
                "]";
    }
}
