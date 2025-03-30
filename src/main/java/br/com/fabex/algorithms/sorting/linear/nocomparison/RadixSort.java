package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.sorting.linear.LinearSorting;
import br.com.fabex.algorithms.statistic.OrderStatistic;
import br.com.fabex.util.ArrayUtils;

import java.util.function.UnaryOperator;

public class RadixSort {

    public static void sort(int[] array) {
        int highestDigitNumber = getHighestDigitNumber(array);
        sort(array, getTotalDigit(highestDigitNumber));
    }

    public static void sort(int[] array, int totalNumberOfDigit) {
        int[] newArray = array;
        for (int i = 1; i <= totalNumberOfDigit; i++) {
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

    public static void sortByImplBubbleSort(int[] array, int totalNumberOfDigit) {
        for (int i = 1; i <= totalNumberOfDigit; i++) {
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
        ArrayUtils.checkEmptyArray(array);
        int min = getDigit(array[0], digit);
        for (int i = 1; i < size; i++) {
            if (min > getDigit(array[i], digit)) {
                min = getDigit(array[i], digit);
            }
        }
        return min;
    }
}
