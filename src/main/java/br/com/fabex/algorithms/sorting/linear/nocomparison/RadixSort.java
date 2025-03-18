package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.sorting.linear.LinearSorting;
import br.com.fabex.algorithms.statistic.OrderStatistic;

import java.util.Arrays;
import java.util.function.UnaryOperator;

import static br.com.fabex.util.ArrayUtil.printArray;

public class RadixSort {

    public static void sort(int[] array) {
        int highestDigitNumber = getHighestDigitNumber(array);
        sort(array, getTotalDigit(highestDigitNumber));
    }

    public static void sort(int[] array, int totalNumerOfDigit) {
        int[] newArray = array;
        for (int i = 1; i <= totalNumerOfDigit; i++) {
            int digit = i;
            int min = min(array, array.length, digit);
            UnaryOperator<Integer> operator = (num) -> getDigit(num, digit);
            newArray = CountingSort.sort(newArray, newArray.length, operator, min, 9);
        }
        System.arraycopy(newArray, 0, array, 0, array.length);
    }

    public static void sortByImplInsertSort(int[] array) {
        int highestDigitNumber = getHighestDigitNumber(array);
        sortByImplInsertSort(array, getTotalDigit(highestDigitNumber));
    }

    public static void sortByImplInsertSort(int[] array, int totalNumerOfDigit) {
        for (int i = 1; i <= totalNumerOfDigit; i++) {
            int digit = i;
            UnaryOperator<Integer> operator = (num) -> getDigit(num, digit);
            LinearSorting.insertionSort(array, array.length, operator);
        }
    }

    public static void sortByImplBubbleSort(int[] array) {
        int highestDigitNumber = getHighestDigitNumber(array);
        sortByImplBubbleSort(array, getTotalDigit(highestDigitNumber));
    }

    public static void sortByImplBubbleSort(int[] array, int totalNumerOfDigit) {
        for (int i = 1; i <= totalNumerOfDigit; i++) {
            int digit = i;
            UnaryOperator<Integer> operator = (num) -> getDigit(num, digit);
            LinearSorting.bubbleSort(array, operator);
        }
    }

    public static int getHighestDigitNumber(int[] array) {
        int firstOrder = OrderStatistic.selectRandomized(array, 0, array.length - 1, 0);
        int lastOrder = OrderStatistic.selectRandomized(array, 0, array.length - 1, array.length);
        int positiveFirstOrder = firstOrder < 0 ? firstOrder * -1 : firstOrder;
        return Math.max(positiveFirstOrder, lastOrder);
    }

    public static int getTotalDigit(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int getDigit(int number, int digit) {
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
        int min = getDigit(array[0], digit);
        for (int i = 1; i < size; i++) {
            if (min > getDigit(array[i], digit)) {
                min = getDigit(array[i], digit);
            }
        }
        return min;
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
        sort(ints, 5);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, -250, 38, 12, 1000301, 1, 2, 10, 11, 8, 67151};
        printArray(ints);
        sort(ints);
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

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, -36, -250, 38, 12, 301, 1, 2, 10, -11, 8, 67151};
        printArray(ints);
        sort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{2, 8, 7, 1, 3, -5, 6, 4};
        printArray(ints);
        sort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, -36, -250, -38, 12, -301, 1, 2, -10, 11, -8, 67151};
        printArray(ints);
        sortByImplBubbleSort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, 250, 38, 12, 301, -1, 2, 10, 11, 8, -67151};
        printArray(ints);
        sortByImplInsertSort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - Sort Default (CountingSort)");
        ints = new int[]{7, 75, 26, -36, -250, -38, 12, -301, 1, 2, -10, 11, -8, 85697};
        printArray(ints);
        sort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - Sort (sortByImplBubbleSort)");
        ints = new int[]{7, 75, 26, -36, -250, -38, 12, -301, 1, 2, -10, 11, -8, 85697};
        printArray(ints);
        sortByImplBubbleSort(ints);
        printArray(ints);


        System.out.println(" - - - - - - - Sort (sortByImplInsertSort)");
        ints = new int[]{7, 75, 26, -36, -250, -38, 12, -301, 1, 2, -10, 11, -8, 85697};
        printArray(ints);
        sortByImplInsertSort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - Sort (any) with min & max ");
        ints = new int[]{7, 75, -95478651, 26, -36, -250, -38, 12, -301, 1, 2, -10, 11, -8, 85697, -9578659};
        int[] aux = new int[]{7, 75, -95478651, 26, -36, -250, -38, 12, -301, 1, 2, -10, 11, -8, 85697, -9578659};
        ;
        printArray(ints);
        //sortByImplInsertSort(ints);
        //sort(ints);
        sortByImplBubbleSort(ints);
        Arrays.sort(aux);
        System.out.println(Arrays.equals(aux, ints));
        printArray(aux);
        printArray(ints);

    }
}
