package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.statistic.OrderStatistic;

import java.util.function.UnaryOperator;

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
}
