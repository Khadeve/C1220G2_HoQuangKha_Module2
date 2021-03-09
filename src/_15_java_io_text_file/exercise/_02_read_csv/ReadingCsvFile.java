package _15_java_io_text_file.exercise._02_read_csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadingCsvFile {

    public static final String absolutePath = "D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\_15_java_io_text_file\\exercise\\_02_read_csv\\";

    public static void main(String[] args) {

        try {
            // Open file with try-with-resources block.
            try (Scanner fin = new Scanner(new FileInputStream(absolutePath + "countries.csv"))) {
                while(fin.hasNextLine()) {
                    System.out.println(fin.nextLine());
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
