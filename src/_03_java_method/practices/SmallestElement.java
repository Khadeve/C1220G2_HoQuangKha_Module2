package _03_java_method.practices;

public class SmallestElement {

    public static int minValue(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for (int v : arr) {
            if (v < minValue) {
                minValue = v;
            }
        }
        return minValue;
    }
    public static void main(String[] args) {
        int[] arr = {4, 12, -2, 8, 1, 6, 9};
        System.out.println("The smallest element in the array: " + minValue(arr));
    }
}
