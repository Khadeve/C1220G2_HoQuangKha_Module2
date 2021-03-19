package _18_review_oop._3_fruit_shop.commons;

import _18_review_oop._3_fruit_shop.models.Fruit;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtility {
    public static final String DATA_FOLDER = "D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\_18_review_oop\\_3_fruit_shop\\data\\";

    public static void writeFruit(Fruit fruit) throws FileNotFoundException {
        File fruitFile = new File(DATA_FOLDER + "fruit.csv");

        try (PrintWriter out = new PrintWriter(new FileOutputStream(fruitFile, true))) {
            out.println(fruit);
        }
    }

    /**
     * Write the fruit list into the fruit.csv file.
     *
     * @param fruitList The fruit list.
     * @throws FileNotFoundException In case, the method cannot open the fruit.csv file.
     */
    public static void writeFruitData(List<Fruit> fruitList) throws FileNotFoundException {
        File fruitFile = new File(DATA_FOLDER + "fruit.csv");

        try (PrintWriter out = new PrintWriter(new FileOutputStream(fruitFile))) {
            fruitList.forEach(out::println);
        }
    }

    public static List<Fruit> readFruitData() {
        File fruitFile = new File(DATA_FOLDER + "fruit.csv");
        List<Fruit> fruitList = new ArrayList<>();

        try {
            try (Scanner in = new Scanner(fruitFile, StandardCharsets.UTF_8)) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();

                    String[] infor = line.split(",");
                    int id = Integer.parseInt(infor[0]);
                    String fruitName = infor[1];
                    double price = Double.parseDouble(infor[2].substring(0, infor[2].length() - 1)); // Skip the dollar symbol.
                    int quantity = Integer.parseInt(infor[3]);
                    String origin = infor[4];

                    fruitList.add(new Fruit(id, fruitName, price, quantity, origin));
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return fruitList;
    }
}
