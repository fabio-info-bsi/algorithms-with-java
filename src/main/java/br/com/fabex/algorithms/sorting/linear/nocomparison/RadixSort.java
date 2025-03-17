package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.statistic.OrderStatistic;

import static br.com.fabex.util.ArrayUtil.printArray;

public class RadixSort {

    public static void sort(int[] array) {
        int max = OrderStatistic.selectRandomized(array, 0, array.length - 1, array.length);
        for (int i = 1; i <= getTotalDigit(max); i++) {
            countingSortByColumn(array, i);
        }
    }

    public static void sort(int[] array, int totalDigit) {
        for (int i = 1; i <= totalDigit; i++) {
            countingSortByColumn(array, i);
        }
    }

    private static void countingSortByColumn(int[] array, int digit) {
        int min = min(array, array.length, digit);
        int offset = Math.max(min, -1 * min);
        int[] b = new int[array.length], c = new int[20];

        for (int j = 0; j < array.length; j++) {
            c[getDigit(array[j], digit) + offset] = c[getDigit(array[j], digit) + offset] + 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            b[c[getDigit(array[j], digit) + offset] - 1] = array[j];
            c[getDigit(array[j], digit) + offset] = c[getDigit(array[j], digit) + offset] - 1;
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

    private static int min(int[] array, int size, int digit) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array empty");
        }
        int max = getDigit(array[0], digit);
        for (int i = 1; i < size; i++) {
            if (max < getDigit(array[i], digit)) {
                max = getDigit(array[i], digit);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints;

        ints = new int[]{70, 90, 802, 2, 24, 45, 75, 66};
        printArray(ints);
        sort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
        printArray(ints);
        sort(ints, 1);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, -250, 38, 12, 1000301, 1, 2, 10, 11, 8, 67151};
        printArray(ints);
        sort(ints, 7);
        //sort(ints, 7);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67859};
        printArray(ints);
        sort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        printArray(ints);
        sort(ints);
        printArray(ints);

    }
}
