package _11_java_javaCollectionsFramework.exercise.task1;

import java.util.Scanner;

public class ProductManagerTest {
    public static void main(String[] args) {
        ProductManager productList = new ProductManager();

        /*--------------add new product into the list---------------*/
        productList.addNewProduct(new Product("MacBook", 2200));
        productList.addNewProduct(new Product("Motorbike", 1200));
        productList.addNewProduct(new Product("House", 55000));
        productList.addNewProduct(new Product("Car", 25000));

        Scanner in = new Scanner(System.in);
        int id, choice;

        do {
            System.out.println("------------------Menu--------------------");
            System.out.println("1. Add new product.");
            System.out.println("2. Edit product.");
            System.out.println("3. Remove product.");
            System.out.println("4. Search a product by name.");
            System.out.println("5. Sort the list in ascending order based on price.");
            System.out.println("6. Sort the list in descending order based on price.");
            System.out.println("7. Show product list.");
            System.out.println("8. Exit");
            System.out.println("-----------------------------------------");

            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.print("Enter name of new product: ");
                    in.nextLine();  //consume the newline.
                    String name = in.nextLine();
                    System.out.print("Enter price of new product: ");
                    double price = in.nextDouble();

                    productList.addNewProduct(new Product(name, price));
                    System.out.println("Add done");
                    break;
                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("Enter id of product you want to edit:");
                    id = in.nextInt();

                    try {
                        productList.editProductInfo(id);
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Edit done");
                    break;
                case 3:
                    System.out.println("---------------------------------------");
                    System.out.println("Enter id of product you want to remove:");
                    id = in.nextInt();

                    try {
                        productList.removeProduct(id);
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Remove done");
                    break;
                case 4:
                    System.out.println("---------------------------------------");
                    System.out.println("Enter the name of product you want to find:");
                    in.nextLine();  //consume the newline.
                    String keyName = in.nextLine();
                    Product p = productList.searchByName(keyName);
                    if (p == null) {
                        System.out.println("There is no \"" + keyName + "\" in the list.");
                    } else {
                        System.out.println("Result: " + p);
                    }
                    break;
                case 5:
                    System.out.println("---------------------------------------");
                    productList.sortInAscendingOrder();
                    System.out.println("Sort done");
                    break;
                case 6:
                    System.out.println("---------------------------------------");
                    productList.sortInDescendingOrder();
                    System.out.println("Sort done");
                    break;
                case 7:
                    System.out.println("---------------------------------------");
                    System.out.println("The product list:");
                    System.out.println(productList);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("YOUR CHOICE IS INVALID. PLEASE TRY AGAIN.");
            }
        } while (isContinue());
    }

    private static boolean isContinue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to continue? (y/n)");
        String c = in.nextLine().toLowerCase();
        return c.equals("y");
    }
}
