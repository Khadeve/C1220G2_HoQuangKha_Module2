package _16_java_io_binary_file.exercise._01_product_manager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductManager {

    private static final String SOURCE_PATH = "D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\_16_java_io_binary_file\\exercise\\_01_product_manager\\productList.dat";

    public static void addNewProduct(Product newProduct) {
        File sourceFile = new File(SOURCE_PATH);
        List<Product> productList = null;

        if (sourceFile.length() == 0) { // Empty file.
            productList = new ArrayList<>();
        } else {    // File is not empty.
            // Open the object input stream to read binary data.
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(sourceFile))) {
                productList = (ArrayList<Product>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        assert productList != null;
        productList.add(newProduct);

        // Open the object output stream to write the updated binary data.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(sourceFile))) {
            out.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showProductList() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SOURCE_PATH))) {
            List<Product> productList = (List<Product>) in.readObject();

            // Print out all products on the console.
            AtomicInteger counter = new AtomicInteger(1);
            productList.forEach((e) ->
                    System.out.println(counter.getAndIncrement() + "." + e));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> searchProduct(String matcher) {
        File sourceFile = new File(SOURCE_PATH);

        if (sourceFile.length() == 0) { // Empty file.
            return null;
        }

        List<Product> productList = null;
        List<Product> resultList = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(sourceFile))) {
            productList = (ArrayList<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        assert productList != null;
        for (Product current : productList) {
            if (current.getName().toLowerCase().contains(matcher.toLowerCase())) {
                resultList.add(current);
            }
        }
        return resultList;
    }
}
