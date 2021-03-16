package furamaResort.commons.fileUtility;

import furamaResort.models.Customer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CustomerFileUtil extends FileUtil {

    public static final String CUSTOMER_FILE = "Customer.csv";

    /**
     * Get a new customer object from a string of customer data.
     *
     * @param data contains the customer data fields.
     * @return a new customer object.
     */
    public static Customer readCustomer(String data) {
        String[] tokens = data.split(",");

        String fullName = tokens[0];
        String dayOfBirth = tokens[1];
        String gender = tokens[2];
        String idNumber = tokens[3];
        String phoneNumber = tokens[4];
        String email = tokens[5];
        String membership = tokens[6];
        String address = tokens[7];

        return new Customer(fullName, dayOfBirth, gender, idNumber, phoneNumber,
                email, membership, address, null);
    }

    /**
     * Retrieve a list of customers from a file
     * and print them all on the console.
     *
     * @param path - the path of an input stream.
     * @return an array of customer objects.
     * @throws IOException - from the static method readAllLines of the Files class.
     */
    public static Customer[] readCustomerData(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        int numberOfCustomers = lines.size() - 1;   // Skip the first line of headers.

        Customer[] customers = new Customer[numberOfCustomers];
        for (int i = 0; i < numberOfCustomers; i++) {
            customers[i] = readCustomer(lines.get(i + 1));    // Skip the first line of headers.
        }
        return customers;
    }
}
