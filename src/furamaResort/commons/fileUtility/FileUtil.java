package furamaResort.commons.fileUtility;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileUtil {

    public static final String DATA_FOLDER = "D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\furamaResort\\data\\";

    /**
     * Write a new object into a file.
     *
     * @param fileName The name of the file.
     * @param object The written object.
     * @throws FileNotFoundException In case the method cannot open the file.
     */
    public static <E> void writeObject(String fileName, E object) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(FileUtil.DATA_FOLDER + fileName, true))) {
            out.println(object);
        }
    }

    /**
     * Read a line corresponding with the index in a specific file.
     *
     * @param index The index of the line in file.
     * @param fileName The file name.
     * @return The indexed line.
     * @throws IOException In case the name of file is not either existent or accurate.
     */
    public static String readLineFromFile(int index, String fileName) throws IOException {
        File source = new File(DATA_FOLDER + fileName);
        List<String> lines = Files.readAllLines(source.toPath(), StandardCharsets.UTF_8);
        return lines.get(index);
    }
}
