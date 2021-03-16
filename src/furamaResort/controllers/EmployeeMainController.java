package furamaResort.controllers;

import furamaResort.commons.fileUtility.EmployeeFileUtil;
import furamaResort.commons.fileUtility.FileUtil;
import furamaResort.models.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeMainController {

    private static Map<String, Employee> employeeMap;

    private static void setEmployeeMap(String fileName) {
        File employeeFile = new File(FileUtil.DATA_FOLDER + fileName);

        try {
            Employee[] employeeArray = EmployeeFileUtil.readEmployeeData(employeeFile.toPath());

            /* Use lambda expression instead of comparator object for the tree map */
            Map<String, Employee> temp = new TreeMap<>((o1, o2) ->
                    Integer.parseInt(o1) - Integer.parseInt(o2));

            for (Employee e : employeeArray) {
                temp.put(e.getId(), e);
            }
            employeeMap = temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllEmployees() {
        setEmployeeMap(EmployeeFileUtil.EMPLOYEE_FILE);

        employeeMap.forEach((k, v) -> {
                    System.out.println(k + ". " + v);
                }
        );
    }
}
