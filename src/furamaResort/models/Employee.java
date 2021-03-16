package furamaResort.models;

public class Employee {
    private static int nextId = 1;

    private String fullName;
    private String id;
    private int age;
    private String address;

    public Employee() {}

    public Employee(String fullName, int age, String address) {
        this.fullName = fullName;
        id = "00" + nextId++;
        this.age = age;
        this.address = address;
    }

    public static void resetNextId() {
        nextId = 1;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
