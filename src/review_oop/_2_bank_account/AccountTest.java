package review_oop._2_bank_account;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountTest {
    private static final String MAIN_MENU = "\n---------------------Main Menu---------------------" +
            "\n1. Add New Account." +
            "\n2. Show Accounts." +
            "\n3. Process on Account." +
            "\n4. Exit." +
            "\n---------------------------------------------------";

    private static final String ACCOUNT_MENU = "\n---------------------Account Menu---------------------" +
            "\n1. Pay in." +
            "\n2. With draw." +
            "\n3. Transfer money." +
            "\n4. Show information." +
            "\n5. Mature." +
            "\n6. Back to main menu." +
            "\n---------------------------------------------------";

    public static void main(String[] args) {
        ArrayList<Account> accountList = new ArrayList<>();

        accountList.add(new Account(1111, "Ho Quang Kha"));
        accountList.add(new Account(2222, "Do Viet Hoai"));

        Scanner in = new Scanner(System.in);

        int choice;
        do {
            System.out.println(MAIN_MENU);
            System.out.print("***Please enter your choice: ");
            choice = in.nextInt();
            switch(choice) {
                case 1:
                    addNewAccount(accountList);
                    break;
                case 2:
                    showAccounts(accountList);
                    break;
                case 3:
                    Account chosenAccount = chooseAnAccount(accountList);

                    // Create a copied list without the chosenAccount.
                    ArrayList<Account> newList = new ArrayList<>();
                    accountList.forEach((e) -> {
                        if (e != chosenAccount) {
                            newList.add(e);
                        }
                    });

                    operateOnAccount(chosenAccount, newList);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while(choice != 4);
    }

    private static void addNewAccount(List<Account> list) {
        Scanner in = new Scanner(System.in);

        System.out.print("1. Enter the account number: ");
        long accountNumber = in.nextLong();

        System.out.print("2. Enter the name of the account: ");
        in.nextLine();  // Consume newline.
        String accountName = in.nextLine();

        list.add(new Account(accountNumber, accountName));
    }

    private static void showAccounts(List<Account> list) {
        AtomicInteger counter = new AtomicInteger(1);
        list.forEach((e) ->
                System.out.println(counter.getAndIncrement() + "." + e));
    }

    private static Account chooseAnAccount(List<Account> list) {
        showAccounts(list);

        Scanner in = new Scanner(System.in);

        int chooseAccount;
        boolean flag;
        do {
            System.out.print("***Choose an account: ");
            chooseAccount = in.nextInt();
            flag = (chooseAccount <= 0 || chooseAccount > list.size());
            if (flag) {
                System.out.println("!Invalid input. Please try again.");
            }
        } while(flag);

        return list.get(chooseAccount - 1);
    }

    private static void operateOnAccount(Account account, List<Account> list) {
        System.out.println(ACCOUNT_MENU);

        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.print("***Enter your choice: ");
            choice = in.nextInt();

            switch(choice) {
                case 1:
                    account.payIn();
                    System.out.println("Pay in done");
                    break;
                case 2:
                    account.withdraw();
                    System.out.println("Withdrawing done");
                    break;
                case 3:
                    System.out.println("***Choose a receiver account:");
                    Account receiver = chooseAnAccount(list);
                    account.transferMoney(receiver);
                    System.out.println("Transferring done");
                    break;
                case 4:
                    System.out.println(account);
                    break;
                case 5:
                    account.mature();
                    System.out.println("Maturing done");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("!Invalid choice. Please try again.");
            }
        } while(choice != 6);

    }
}
