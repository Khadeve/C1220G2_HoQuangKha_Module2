package furamaResort.controllers;

import furamaResort.commons.exception.*;
import furamaResort.commons.fileUtility.CustomerFileUtil;
import furamaResort.commons.fileUtility.FileUtil;
import furamaResort.commons.validation.*;
import furamaResort.models.Customer;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class CustomerMainController {
    public static final String BOOKING_MENU = "\n---------------------Booking Menu---------------------" +
            "\n1. Booking Villa." +
            "\n2. Booking House." +
            "\n3. Booking Room." +
            "\n4. Back to Main Menu." +
            "\n5. Exit." +
            "\n------------------------------------------------------";

    private static final Scanner in = new Scanner(System.in);

    public static String enterCustomerName() throws InvalidNameException {
        System.out.print("***Enter the full name (ex: John Wick): ");
        String fullName = in.nextLine();

        boolean flag = !CustomerInputValidation.isValidInputData(fullName, CustomerInputValidation.CUSTOMER_NAME_PATTERN);
        if (flag) {
            throw new InvalidNameException("!The first letter in each word of the customer's name must be uppercase.");
        }
        return fullName;
    }

    public static String enterCustomerBirthday() throws InvalidBirthdayException {
        System.out.print("***Enter the day of birth (dd/mm/yyyy): ");
        String dayOfBirth = in.nextLine();

        boolean flag = !(CustomerInputValidation.isValidInputData(dayOfBirth, CustomerInputValidation.CUSTOMER_BIRTHDAY_PATTERN) &&
                CustomerInputValidation.isValidCustomerBirthday(dayOfBirth));
        if (flag) {
            throw new InvalidBirthdayException("The year must be bigger than 1900. " +
                    "And the customer must be at least enough 18 years old.");
        }
        return dayOfBirth;
    }

    public static String enterCustomerGender() throws InvalidGenderException {
        System.out.print("***Enter the gender (Male, Female or Unknown): ");
        String gender = in.nextLine().toLowerCase();

        boolean flag = CustomerInputValidation.isValidInputData(gender, CustomerInputValidation.CUSTOMER_GENDER_PATTERN);

        if (flag) { // Format the input.
            StringBuilder temp = new StringBuilder(gender);
            temp.setCharAt(0, Character.toUpperCase(temp.charAt(0)));
            gender = temp.toString();
        } else {
            throw new InvalidGenderException("!Invalid input format. Please try again.");
        }

        return gender;
    }

    public static String enterCustomerIdNumber() throws InvalidIdCardException {
        System.out.print("***Enter the id number (DDD DDD DDD): ");
        String idNumber = in.nextLine();

        boolean flag = !CustomerInputValidation.isValidInputData(idNumber, CustomerInputValidation.CUSTOMER_ID_PATTERN);
        if (flag) {
            throw new InvalidIdCardException("! The id must contain 9 digits and in the format of DDD DDD DDD");
        }

        return idNumber;
    }

    public static String enterCustomerEmail() throws InvalidEmailException {
        System.out.print("***Enter the email (abc@abc.abc): ");
        String email = in.nextLine();

        boolean flag = !CustomerInputValidation.isValidInputData(email, CustomerInputValidation.CUSTOMER_EMAIL_PATTERN);
        if (flag) {
            throw new InvalidEmailException("! The email must be in format of abc@abc.abc");
        }

        return email;
    }

    /**
     * Fill in information of a new customer and add the customer into Customer.csv file.
     *
     * @throws FileNotFoundException In case the method cannot open the target file.
     */
    public static void addNewCustomer() throws FileNotFoundException {

        String fullName = null;
        String dayOfBirth = null;
        String gender = null;
        String idNumber = null;
        String phoneNumber = null;
        String email = null;
        String membership = null;
        String address = null;

        do {
            try {
                fullName = enterCustomerName();
                break;
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        do {
            try {
                dayOfBirth = enterCustomerBirthday();
                break;
            } catch (InvalidBirthdayException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        do {
            try {
                gender = enterCustomerGender();
                break;
            } catch (InvalidGenderException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        do {
            try {
                idNumber = enterCustomerIdNumber();
                break;
            } catch (InvalidIdCardException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        System.out.print("***Enter the phone number: ");
        phoneNumber = in.nextLine();

        do {
            try {
                email = enterCustomerEmail();
                break;
            } catch (InvalidEmailException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        System.out.print("***Enter the membership: ");
        membership = in.nextLine();

        System.out.print("***Enter the address: ");
        address = in.nextLine();

        Customer newCustomer = new Customer(fullName, dayOfBirth, gender, idNumber, phoneNumber,
                email, membership, address, null);

        FileUtil.writeObject("Customer.csv", newCustomer);
        System.out.println("!Successfully writing new customer.");
    }

    /**
     * Print out all customers in the Customer.csv in the order in which they are inserted.
     * Overloaded method.
     */
    public static void showAllCustomers() {
        try {
            File file = new File(FileUtil.DATA_FOLDER + "Customer.csv");
            Customer[] customerList = CustomerFileUtil.readCustomerData(file.toPath());

            for (int i = 0; i < customerList.length; i++) {
                System.out.print((i + 1) + "/ ");
                customerList[i].showInfor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print out all customers in an sorted order based on customer's name and day of birth.
     *
     * @param sorted to overload the original method.
     */
    public static void showAllCustomers(boolean sorted) {
        try {
            File file = new File(FileUtil.DATA_FOLDER + "Customer.csv");
            Customer[] customerList = CustomerFileUtil.readCustomerData(file.toPath());

            /*
             * Sort all customers in an alphabetical order based on their names.
             * In case, customers have same name, then sort based on their day of birth.
             */
            Arrays.sort(customerList, Comparator.comparing(Customer::getFullName).
                    thenComparing(Customer::getDayOfBirth));

            for (int i = 0; i < customerList.length; i++) {
                System.out.print((i + 1) + "/ ");
                customerList[i].showInfor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new booking for a specific customer.
     */
    public static void addNewBooking() throws IOException {
        System.out.println("---------------------Customer List---------------------");
        showAllCustomers();
        System.out.println("------------------------End-------------------------");

        System.out.print("***Choose the index of a customer for the booking: ");
        int customerIndex = in.nextInt();

        /* Get the customer data with the chosen index */
        String customerData = FileUtil.readLineFromFile(customerIndex, "Customer.csv");

        /* Choose a service for the booking */
        System.out.println(BOOKING_MENU);

        String serviceFile = null;   // The file of the chosen type of service.

        do {
            System.out.print("***Which is the service for the booking? ");
            int opt = in.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("---------------------Villa List---------------------");
                    ServiceMainController.showServiceList("Villa.csv");
                    System.out.println("------------------------End-------------------------");
                    serviceFile = "Villa.csv";
                    break;
                case 2:
                    System.out.println("---------------------House List---------------------");
                    ServiceMainController.showServiceList("House.csv");
                    System.out.println("------------------------End-------------------------");
                    serviceFile = "House.csv";
                    break;
                case 3:
                    System.out.println("---------------------Room List---------------------");
                    ServiceMainController.showServiceList("Room.csv");
                    System.out.println("------------------------End-------------------------");
                    serviceFile = "Room.csv";
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("!Invalid choice. Please try again.");
                    continue;
            }
            break;
        } while (true);


        System.out.print("***Enter the index of a service you want to choose: ");
        int serviceIndex = in.nextInt();

        String serviceData = FileUtil.readLineFromFile(serviceIndex, serviceFile);
        String[] tokens = serviceData.split(",");
        String serviceId = tokens[1];   // Get the id of the chosen service.

        // Booking includes the customer information and the id of the chosen service.
        String booking = customerData + "," + serviceId;

        // Write the booking into the Booking.csv
        try (PrintWriter out = new PrintWriter(new FileOutputStream(FileUtil.DATA_FOLDER + "Booking.csv", true))) {
            out.println(booking);
        }
    }
}
