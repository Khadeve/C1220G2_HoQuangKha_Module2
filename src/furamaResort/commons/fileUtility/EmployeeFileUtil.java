package furamaResort.commons.fileUtility;

import furamaResort.models.Employee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EmployeeFileUtil extends FileUtil {

    public static final String EMPLOYEE_FILE = "Employee.csv";

    /**
     * Get a new employee object from a string of employee data.
     *
     * @param data contains the employee data fields.
     * @return a new employee object.
     */
    public static Employee readEmployee(String data) {
        String[] tokens = data.split(",");

        String fullName = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String address = tokens[2];

        return new Employee(fullName, age, address);
    }

    /**
     * Retrieve a list of employees from a file
     *
     * @param path - the path of an input stream.
     * @return an array of employee objects.
     * @throws IOException - from the static method readAllLines of the Files class.
     */
    public static Employee[] readEmployeeData(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        int numberOfEmployees = lines.size() - 1;   // Skip the first line of headers.

        Employee[] employees = new Employee[numberOfEmployees];

        Employee.resetNextId(); // Reset the nextId before reading employees.
        for (int i = 0; i < numberOfEmployees; i++) {
            employees[i] = readEmployee(lines.get(i + 1));    // Skip the first line of headers.
        }
        return employees;
    }
}
