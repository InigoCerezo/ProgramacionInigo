package Tema3.Arrays;

public class pruebaArray {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
    public static void main(String[] args) {
        int[] grades;
        grades = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        printArray(grades);
    }
}
