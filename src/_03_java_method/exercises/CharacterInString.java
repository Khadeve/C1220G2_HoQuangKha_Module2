package _03_java_method.exercises;

import java.util.Scanner;

public class CharacterInString {
    public static void main(String[] args) {
        String name = "Ho Quang Kha";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char c = in.nextLine().charAt(0);

        int counter = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == c) {
                counter++;
            }
        }
        System.out.println("The number of appearances of " + c + " in " + name + " is " + counter);
    }
}
