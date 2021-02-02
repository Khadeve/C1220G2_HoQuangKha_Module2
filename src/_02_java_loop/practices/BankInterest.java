package _02_java_loop.practices;

import java.util.Scanner;

public class BankInterest {
    public static void main(String[] args) {
        double interest;
        int months;
        long money;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter interest of bank (%): ");
        interest = in.nextDouble();
        System.out.print("Please enter the investment money: ");
        money = in.nextLong();
        System.out.print("Please enter number of months: ");
        months = in.nextInt();

        long totalInterest = 0;
        for (int i = 1; i <= months; i++) {
            totalInterest += money * ((interest / 100) / 12) * months;
        }

        System.out.println("Total interest money: " + totalInterest);
    }
}
