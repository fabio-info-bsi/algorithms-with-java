package br.com.fabex.algorithms.sorting.linear.nocomparison;

import static br.com.fabex.util.ArrayUtil.maxElement;
import static br.com.fabex.util.ArrayUtil.printArray;

public class CountingSort {

    public static int[] sort(int[] array) {
        return sort(array, array.length);
    }

    public static int[] sort(int[] array, int size) {
        return sort(array, size, maxElement(array, size));
    }

    public static int[] sort(int[] array, int size, int limit) {
        int[] b = new int[size], c = new int[limit + 1];

        for (int j = 0; j < array.length; j++) {
            c[array[j]] = c[array[j]] + 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            b[c[array[j]] - 1] = array[j];
            c[array[j]] = c[array[j]] - 1;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println("## CountingSort");
        //int[] ints = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        //int[] ints = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        //int[] ints = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        //int[] ints = new int[]{31, 26, 36, 38, 12, 1, 2, 10, 11, 8};
        int[] ints = new int[]{2, 8, 7, 1};
        //negatives numbers
        //int[] ints = {2, 5, 3, 0, 2, 3, -0, -3};
        printArray(ints);
        printArray(sort(ints, ints.length, maxElement(ints, ints.length)));
        printArray(sort(ints, ints.length));
        printArray(sort(ints));
    }
}
