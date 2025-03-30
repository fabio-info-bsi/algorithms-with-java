package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.sorting.linear.LinearSorting;
import br.com.fabex.algorithms.statistic.OrderStatistic;

import static br.com.fabex.util.ArrayUtils.printArray;

public class BucketSort {

    public static int[] sort(int[] array) {
        return sort(array, array.length);
    }

    public static int[] sort(int[] array, int size) {
        int max = OrderStatistic.max(array, array.length), sizeBuckets = (max / 10) + 1, index = 0;
        int[][] buckets = new int[sizeBuckets][size + 1];
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int range = (array[i] / 10);
            insertAndSort(buckets[range], array[i]);
        }

        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i][buckets[i].length - 1]; j++) {
                newArray[index++] = buckets[i][j];
            }
        }
        return newArray;
    }

    private static void insertAndSort(int[] array, int newElement) {
        array[array[array.length - 1]] = newElement;
        array[array.length - 1]++;
        LinearSorting.insertionSort(array, array[array.length - 1]);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        printArray(ints);
        printArray(sort(ints));

        ints = new int[]{70, 90, 802, 2, 24, 45, 75, 66, 71};
        printArray(ints);
        printArray(sort(ints));
        int[] ints2 = {31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
        printArray(sort(ints2));

        ints2 = new int[]{7, 5, 1, 8, 11, -1, 7};
        printArray(sort(ints2));
    }
}
