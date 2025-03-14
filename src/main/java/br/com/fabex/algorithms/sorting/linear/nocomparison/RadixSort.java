package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.statistic.OrderStatistic;

import static br.com.fabex.util.ArrayUtil.printArray;

public class RadixSort {

    public static void sort(int[] array) {
        int max = OrderStatistic.max(array, array.length);
        for (int i = 1; i <= getTotalDigit(max); i++) {
            countingSort(array, i);
        }
    }

    public static void sort(int[] array, int totalDigit) {
        for (int i = 1; i <= totalDigit; i++) {
            countingSort(array, i);
        }
    }

    private static void countingSort(int[] array, int digit) {
        int[] b = new int[array.length], c = new int[10];

        for (int j = 0; j < array.length; j++) {
            c[getDigit(array[j], digit)] = c[getDigit(array[j], digit)] + 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            b[c[getDigit(array[j], digit)] - 1] = array[j];
            c[getDigit(array[j], digit)] = c[getDigit(array[j], digit)] - 1;
        }

        /* copy array b to original */
        /*for (int i = 0; i < array.length; i++) {
            array[i] = auxArray[i];
        }*/
        //or (more efficient) -> System.arraycopy
        System.arraycopy(b, 0, array, 0, array.length);
    }

    private static int getTotalDigit(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    private static int getDigit(int number, int digit) {
        int i = 1, remainder = 0;
        while (i <= digit) {
            remainder = number % 10;
            number /= 10;
            i++;
        }
        return remainder;
    }

    public static void main(String[] args) {
        //int[] ints = {31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67859};
        //int[] ints = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        int[] ints = new int[]{70, 90, 802, 2, 24, 45, 75, 66};
        printArray(ints);
        sort(ints);
        printArray(ints);
        int[] ints2 = {31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
        printArray(ints2);
        sort(ints2, 1);
        printArray(ints2);
    }
}
