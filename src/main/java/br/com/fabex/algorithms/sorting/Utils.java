package br.com.fabex.algorithms.sorting;

public class Utils {

    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int j : array) {
            if (j < Integer.MAX_VALUE) {
                System.out.print(j + " ");
            }
        }
        System.out.print("] \n");
    }

    public static void printArray(int[] array, int endIndex) {
        System.out.print("[ ");
        for (int j = 0; j <= endIndex; j++) {
            if (array[j] < Integer.MAX_VALUE) {
                System.out.print(array[j] + " ");
            }
        }
        System.out.print("] \n");
    }

    public static void printReverseArray(int[] array) {
        System.out.print("[ ");
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.print("] \n");
    }
}
