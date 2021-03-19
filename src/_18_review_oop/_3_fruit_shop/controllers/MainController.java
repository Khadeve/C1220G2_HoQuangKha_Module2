package _18_review_oop._3_fruit_shop.controllers;

import _18_review_oop._3_fruit_shop.commons.FileUtility;
import _18_review_oop._3_fruit_shop.models.Fruit;

import java.io.FileNotFoundException;;
import java.util.*;

public class MainController {
    private static final String MAIN_SCREEN = "----------------------------------------" +
            "\nFRUIT SHOP SYSTEM" +
            "\n1. Create Fruit" +
            "\n2. View Orders" +
            "\n3. Shopping (for Buyer)" +
            "\n4. Exit" +
            "\n------------------------------------------";

    private static final String SHOPPING_HEADER = "|++Item++|++Fruit Name++|++Origin++|++Price++|";
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, List<Fruit>> orderList = new Hashtable<>();

        List<Fruit> fruitList = FileUtility.readFruitData();
        int numberOfFruit = fruitList.size();
        if (numberOfFruit != 0) {
            // Update the nextId for new fruits, each time restart the program.
            Fruit.setNextId(fruitList.get(numberOfFruit - 1).getId() + 1);
        }

        do {
            System.out.println(MAIN_SCREEN);
            System.out.print("***Please enter your choice: ");
            int choice = in.nextInt();

            switch(choice) {
                case 1: // Creating new fruit feature.
                    String c;
                    in.nextLine();
                    do {
                        System.out.println();
                        Fruit newFruit = createFruit(fruitList);

                        try {
                            FileUtility.writeFruit(newFruit);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        System.out.print("***Do you want to continue (y/n)? ");
                        c = in.nextLine().toLowerCase();
                    } while(c.equals("y"));

                    /* Print out the fruit list */
                    System.out.println("--------------Fruit List--------------");
                    fruitList.forEach(System.out::println);
                    System.out.println("------------------End-----------------");

                    break;
                case 2: // View order list.
                    if (!orderList.isEmpty()) {
                        orderList.forEach((k, v) -> {
                            System.out.println("----------------------------------------------");
                            System.out.println("Customer name: " + k);
                            showOrder(v);
                        });
                    } else {
                        System.out.println("There is no order available.");
                    }

                    break;
                case 3: // Shopping feature for buyer.
                    fruitList = FileUtility.readFruitData();
                    List<Fruit> order = new ArrayList<>();
                    int numberOfOrders = 1;

                    do {
                        System.out.println(SHOPPING_HEADER);
                        for (Fruit fruit : fruitList) {
                            System.out.println("\t" + fruit.getId() + "\t\t" + fruit.getFruitName() +
                                    "\t\t" + fruit.getOrigin() + "\t\t" + fruit.getPrice() + "$");
                        }
                        System.out.print("***Please choose an item: ");
                        int chosenItem = in.nextInt();
                        numberOfFruit = fruitList.size();

                        String fruitName = "";
                        for (int i = 0; i < numberOfFruit; i++) {
                            if (chosenItem == (i + 1)) {
                                fruitName = fruitList.get(i).getFruitName();
                                System.out.println("You selected: " + fruitName);
                                break;
                            }
                        }

                        System.out.print("***Please input quantity: ");
                        int quantity = in.nextInt();
                        double price = fruitList.get(chosenItem - 1).getPrice();
                        String origin = fruitList.get(chosenItem - 1).getOrigin();
                        order.add(new Fruit(numberOfOrders++, fruitName, price, quantity, origin));

                        System.out.print("***Do you want to order now (y/n)? ");
                        in.nextLine();
                        c = in.nextLine().toLowerCase();
                    } while(c.equals("n"));

                    System.out.println("----------------------------------------------");
                    showOrder(order);

                    System.out.println("***Please input your name to finish ordering:");
                    String customerName = in.nextLine();
                    orderList.put(customerName, order);

                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("!Invalid choice. Please try again.");
            }
        } while(true);
    }

    /**
     * Create a new fruit and store it into the fruit list.
     * @param fruitList The fruit list.
     */
    public static Fruit createFruit(List<Fruit> fruitList) {
        System.out.print("***Enter the name of the fruit: ");
        String fruitName = in.nextLine();

        System.out.print("***Enter the price of the fruit: ");
        double price = in.nextDouble();

        System.out.print("***Enter the quantity of the fruit: ");
        int quantity = in.nextInt();

        System.out.print("***Enter the origin of the fruit: ");
        in.nextLine();
        String origin = in.nextLine();

        Fruit newItem = new Fruit(fruitName, price, quantity, origin);
        fruitList.add(newItem); // Add a newly created fruit into the fruit list.
        return newItem;
    }

    public static void showOrder(List<Fruit> order) {
        System.out.println("Product | Quantity | Price | Amount");
        double total = 0;
        for (Fruit fruit : order) {
            double price = fruit.getPrice();
            int quantity = fruit.getQuantity();
            total += price * quantity;
            System.out.println(fruit.getFruitName() + "\t\t" + quantity +
                    "\t\t" + price + "$" + "\t\t" + (quantity * price) + "$");
        }
        System.out.println("Total: " + total);
    }
}
