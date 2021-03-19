package review_oop._2_bank_account;

import java.util.*;

public class Account {
    private static final double INTEREST = 0.035;
    private static final double WITHDRAWAL_FEE = 1.5;

    private long accountNumber;
    private String accountName;
    private double balance;

    public Account(){}

    public Account(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        balance = 50;
    }

    public Account(long accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance + "$" +
                '}';
    }

    private double enterMoney() {
        Scanner in = new Scanner(System.in);
        double money;

        do {
            System.out.print("Enter the amount of money: ");
            money = in.nextDouble();
            if (money < 0 || money > balance) {
                System.out.println("Invalid amount. Please try again!");
            } else {
                break;
            }
        } while (true);

        return money;
    }

    public void payIn() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter the amount of money: ");
            double money = in.nextDouble();
            if (money < 0) {
                System.out.println("The amount is negative. Please try again!");
            } else {
                balance += money;
                break;
            }
        } while (true);
    }

    public void withdraw() {
        double money = enterMoney();
        balance -= (money + WITHDRAWAL_FEE);
    }

    public double mature() {
        balance += (balance * INTEREST);
        return balance;
    }

    public void transferMoney(Account other) {
        double money = enterMoney();
        balance -= money;
        other.balance += money;
    }
}
