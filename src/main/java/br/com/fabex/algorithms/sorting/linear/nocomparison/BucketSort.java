package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.sorting.linear.LinearSorting;
import br.com.fabex.algorithms.statistic.OrderStatistic;

import static br.com.fabex.util.ArrayUtils.printArray;

public class BucketSort {

    public static int[] sort(int[] array) {
        return sort(array, array.length);
    }

    public static int[] sort(int[] array, int size) {
        int max = OrderStatistic.max(array, array.length);
        int min = OrderStatistic.min(array, array.length);

        int offset = Math.max(min, -1 * min);
        int offsetSize = Math.max(min, -1 * min) + max + 1;

        int sizeBuckets = (offsetSize / 10) + 1, index = 0;
        int[][] buckets = new int[sizeBuckets][size + 1];
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int range = ((array[i] + offset) / 10);
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

    public static int[] sortPositiveNumbers(int[] array) {
        return sortPositiveNumbers(array, array.length);
    }

    public static int[] sortPositiveNumbers(int[] array, int size) {
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
}
