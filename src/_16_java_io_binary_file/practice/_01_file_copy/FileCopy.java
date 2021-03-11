package _16_java_io_binary_file.practice._01_file_copy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileCopy {

    private static final String absolutePath = "D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\_16_java_io_binary_file\\practice\\_01_file_copy\\";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the source file: ");
        String sourcePath = in.nextLine();

        System.out.println("Enter the destination folder: ");
        String destinationPath = in.nextLine();

        // Construct 2 file objects from the sourcePath and destinationPath.
        File sourceFile = new File(absolutePath + sourcePath);
        File targetFile = new File(absolutePath + destinationPath);

        try {
            //copyFileUsingFilesClass(sourceFile.toPath(), targetFile.toPath());
            copyFileUsingStream(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileUsingFilesClass(Path source, Path destination)
            throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copying done");
    }

    private static void copyFileUsingStream(File source, File destination)
            throws IOException {

        try(InputStream fin =  new FileInputStream(source);
            OutputStream fout = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fin.read(buffer)) > 0) {
                fout.write(buffer, 0, length);
            }
        }
    }
}
