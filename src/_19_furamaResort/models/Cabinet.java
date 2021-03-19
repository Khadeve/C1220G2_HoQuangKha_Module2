package furamaResort.models;

import furamaResort.commons.fileUtility.EmployeeFileUtil;
import furamaResort.commons.fileUtility.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Cabinet {
    private static Cabinet employeeCabinet = new Cabinet();
    private static Stack<Employee> documentList;

    /* Set up a new set of documents for this cabinet */
    static {
        File dataFile = new File(FileUtil.DATA_FOLDER + EmployeeFileUtil.EMPLOYEE_FILE);
        try {
            Employee[] employeePapers = EmployeeFileUtil.readEmployeeData(dataFile.toPath());

            documentList = new Stack<>();
            for (furamaResort.models.Employee paper : employeePapers) {
                documentList.push(paper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cabinet() {
    }

    // Get the only employee cabinet available.
    public static Cabinet getEmployeeCabinet() {
        return employeeCabinet;
    }

    public void searchEmployeeDocument() {
        Stack<Employee> temporaryStack = new Stack<>();

        Scanner in = new Scanner(System.in);
        System.out.print("***Enter the name of an employee: ");
        String searchedName = in.nextLine();

        int counter = 1;
        System.out.println("------------------------Found Documents---------------------------");
        while (!documentList.isEmpty()) {
            Employee current = documentList.pop();

            if (current.getFullName().toLowerCase().equals(searchedName.toLowerCase())) {
                System.out.println(counter++ + ". " + current); // Print the match document.
            } else {
                temporaryStack.push(current);   // Move the unmatched documents into the temporary stack.
            }
        }
        System.out.println("--------------------------------End-------------------------------");
        System.out.println("Get the document(s) out of the cabinet.");
        documentList = temporaryStack;    // Update the cabinet.
    }
}
