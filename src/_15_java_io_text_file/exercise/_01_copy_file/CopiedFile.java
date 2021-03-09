package _15_java_io_text_file.exercise._01_copy_file;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class CopiedFile {
    public static final String RELATIVE_WORKING_PATH = "src\\_15_java_io_text_file\\exercise\\_01_copy_file\\";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("***Enter the source file: ");
        String source = in.nextLine();

        System.out.print("***Enter the target file: ");
        String target = in.nextLine();

        int charCounter = 0;

        // Open the source and target files to read and write data.
        try {
            // Use try-with-resources to open files.
            try (Scanner fin = new Scanner(new FileInputStream(RELATIVE_WORKING_PATH + source), StandardCharsets.UTF_8);
                 PrintWriter fout = new PrintWriter(RELATIVE_WORKING_PATH + target)) {

                while (fin.hasNextLine()) {
                    String line = fin.nextLine();

                    int len = line.length();
                    for (int i = 0; i < len; i++) {
                        if (line.charAt(i) != ' ') {
                            charCounter++;
                        }
                    }

                    fout.println(line);
                }
                fout.println("Number of characters: " + charCounter);
                System.out.println("Copying data done.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
