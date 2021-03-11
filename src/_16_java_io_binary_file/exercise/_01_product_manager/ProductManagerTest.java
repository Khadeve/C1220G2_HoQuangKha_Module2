package _16_java_io_binary_file.exercise._01_product_manager;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductManagerTest {
    private static final String MENU = "--------------MENU---------------" +
            "\n1. Add New Product." +
            "\n2. Show All Products." +
            "\n3. Search Product." +
            "\n4. Exit." +
            "\n---------------------------------";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println(MENU);
            System.out.println("***Enter your choice:");
            choice = in.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("-----------------Enter Information----------------");
                    System.out.print("***Enter the code: ");
                    in.nextLine();  // Consume newline.
                    String code = in.nextLine();

                    System.out.print("***Enter the name: ");
                    String name = in.nextLine();

                    System.out.print("***Enter the brand: ");
                    String brand = in.nextLine();

                    System.out.print("***Enter the price: ");
                    double price = in.nextDouble();

                    System.out.print("***Enter the production year: ");
                    int productionYear = in.nextInt();

                    Product newProduct = new Product(code, name, brand, price, productionYear);
                    ProductManager.addNewProduct(newProduct);
                    break;
                case 2:
                    System.out.println("---------------Product List-----------------");
                    ProductManager.showProductList();
                    System.out.println("--------------------------------------------");
                    break;
                case 3:
                    System.out.print("***Enter the name of the expected product: ");
                    in.nextLine();  // Consume newline.
                    String matcherName = in.nextLine();

                    List<Product> listOfMatchers = ProductManager.searchProduct(matcherName);
                    if (listOfMatchers == null) {
                        System.out.println("No Match");
                    } else {
                        AtomicInteger counter = new AtomicInteger(1);
                        listOfMatchers.forEach((e) ->
                                System.out.println(counter.getAndIncrement() + ". " + e));
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("!Invalid Input. Please try again.");
            }
        } while(choice != 4);

    }
}
