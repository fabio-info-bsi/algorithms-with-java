package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.statistic.OrderStatistic;

import java.util.function.UnaryOperator;

import static br.com.fabex.util.ArrayUtil.printArray;

public class CountingSort {

    public static int[] sort(int[] array) {
        return sort(array, array.length);
    }

    public static int[] sort(int[] array, int size) {
        return sort(array,
                size,
                OrderStatistic.selectRandomized(array, 0, array.length - 1, 0),
                OrderStatistic.selectRandomized(array, 0, array.length - 1, array.length));
    }

    public static int[] sort(int[] array, int size, int limitMin, int limitMax) {
        int offset = Math.max(limitMin, -1 * limitMin);
        int offsetSize = Math.max(limitMin, -1 * limitMin) + limitMax + 1;
        int[] b = new int[size], c = new int[offsetSize];

        for (int j = 0; j < array.length; j++) {
            c[array[j] + offset] = c[array[j] + offset] + 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            b[c[array[j] + offset] - 1] = array[j];
            c[array[j] + offset] = c[array[j] + offset] - 1;
        }

        return b;
    }

    public static int[] sort(int[] array, int size, UnaryOperator<Integer> operator, int limitMin, int limitMax) {
        int offset = Math.max(limitMin, -1 * limitMin);
        int offsetSize = Math.max(limitMin, -1 * limitMin) + limitMax + 1;
        int[] b = new int[size], c = new int[offsetSize];

        for (int j = 0; j < array.length; j++) {
            c[operator.apply(array[j]) + offset] = c[operator.apply(array[j]) + offset] + 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            b[c[operator.apply(array[j]) + offset] - 1] = array[j];
            c[operator.apply(array[j]) + offset] = c[operator.apply(array[j]) + offset] - 1;
        }

        return b;
    }

    public static int[] sortPositiveNumbers(int[] array) {
        return sortPositiveNumbers(array, array.length);
    }

    public static int[] sortPositiveNumbers(int[] array, int size) {
        return sortPositiveNumbers(array, size, OrderStatistic.max(array, size));
    }

    public static int[] sortPositiveNumbers(int[] array, int size, int limit) {
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
        int[] ints;
        System.out.println("## CountingSort Positive Numbers");

        ints = new int[]{2, 8, 7, 1};
        printArray(ints);
        printArray(sortPositiveNumbers(ints, ints.length, OrderStatistic.max(ints, ints.length)));

        System.out.println(" - - - - - - - ");
        ints = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        printArray(ints);
        printArray(sortPositiveNumbers(ints));

        System.out.println(" - - - - - - - ");
        ints = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        printArray(ints);
        printArray(sortPositiveNumbers(ints, ints.length, OrderStatistic.max(ints, ints.length)));

        System.out.println(" - - - - - - - ");
        ints = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        printArray(ints);
        printArray(sortPositiveNumbers(ints));

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, 38, 12, 1, 2, 10, 11, 8};
        printArray(ints);
        printArray(sortPositiveNumbers(ints, ints.length));

        System.out.println("## CountingSort Negatives numbers");
        ints = new int[]{2, 5, 3, 0, 2, 3, -0, -3, -80};
        printArray(ints);
        printArray(sort(ints,
                ints.length,
                OrderStatistic.selectRandomized(ints, 0, ints.length - 1, 0),
                OrderStatistic.selectRandomized(ints, 0, ints.length - 1, ints.length)));

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, 38, 12, 1, 2, -10, 11, 8};
        printArray(ints);
        printArray(sort(ints));

        System.out.println(" - - - - - - - ");
        ints = new int[]{-2, -8, -7, -1};
        printArray(ints);
        printArray(sort(ints, ints.length));

        System.out.println(" - - - - - - - ");
        ints = new int[]{2, 8, 7, 1, 3, -5, 6, 4};
        printArray(ints);
        printArray(sort(ints, ints.length));
    }
}
