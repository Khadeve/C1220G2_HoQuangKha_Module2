package _10_java_stackAndQueue.exercise.task3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberOfEachWord {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String sample = in.nextLine();
        String[] words = sample.split(" ");

        Map<String, Integer> wordMap = new TreeMap<>();
        for(String word : words) {
            String key = word.toLowerCase();
            wordMap.putIfAbsent(key, 0);
            wordMap.put(key, wordMap.get(key) + 1);
        }

//        System.out.println(wordMap);
        wordMap.forEach((t, u) ->
                System.out.println("[" + t + ", " + u + "]"));
    }

}
