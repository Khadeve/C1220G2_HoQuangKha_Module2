package furamaResort.models;

import furamaResort.commons.fileUtility.CustomerFileUtil;
import furamaResort.commons.fileUtility.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Cinema {
    private int numberOfTickets;
    private final Queue<Customer> cinemaCustomers;

    public Cinema() {
        numberOfTickets = 0;
        cinemaCustomers = new ArrayDeque<>(0);
    }

    public Cinema(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        cinemaCustomers = new ArrayDeque<>(numberOfTickets);
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void sellTicket() {
        Scanner in = new Scanner(System.in);
        File customerFile = new File(FileUtil.DATA_FOLDER + CustomerFileUtil.CUSTOMER_FILE);

        try {
            /* Read all customers in the resort and store into a linked list */
            List<Customer> customerList = new LinkedList<>(Arrays.asList(CustomerFileUtil.readCustomerData(customerFile.toPath())));

            for (int ticketNumber = 1; ticketNumber <= numberOfTickets; ticketNumber++) {

                /* show left customers after selling a ticket */
                System.out.println("----------------------Left Customers--------------------------");
                AtomicInteger counter = new AtomicInteger(1);
                customerList.forEach(e -> System.out.println(counter.getAndIncrement() + ". " + e));
                System.out.println("--------------------------------------------------------------");

                System.out.print("***Choose a customer for the ticket number " + ticketNumber + ": ");
                int customerIndex = in.nextInt();

                /* Remove the chosen customer from the customer list and also add it into the cinema customers */
                cinemaCustomers.add(customerList.remove(customerIndex - 1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCinemaCustomers() {
        System.out.println("-------------------------Cinema Customers----------------------------");
        AtomicInteger counter = new AtomicInteger(1);
        cinemaCustomers.forEach(e ->
                System.out.println(counter.getAndIncrement() + ". " + e));
        System.out.println("---------------------------------------------------------------------");
    }
}
