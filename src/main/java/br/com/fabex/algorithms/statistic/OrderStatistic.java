package br.com.fabex.algorithms.statistic;

import br.com.fabex.algorithms.sorting.comparison.QuickSort;

import static br.com.fabex.util.ArrayUtil.printArray;

public class OrderStatistic {

    public static int selectRandomized(int[] array, int startIndex, int endIndex, int orderStatisticIth) {
        if (startIndex == endIndex) {
            return array[startIndex];
        }
        // Math.max -> only positive > 0 to Random
        int pivot = QuickSort.partitionRandomized(array, startIndex, Math.max(endIndex, 1));

        // Count number of elements [startIndex ~ pivot] + 1 (pivot position)
        int countSubarrayElements = pivot - startIndex + 1;

        if (orderStatisticIth == countSubarrayElements) {
            return array[pivot];
        } else if (orderStatisticIth < countSubarrayElements) {
            return selectRandomized(array, startIndex, pivot - 1, orderStatisticIth);
        } else {
            return selectRandomized(array, pivot + 1, endIndex,
                    orderStatisticIth - countSubarrayElements);
        }
    }

    public static int max(int[] array, int size) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array empty");
        }
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static int min(int[] array, int size) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array empty");
        }
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array;
        System.out.println("## Select Randomized");

        array = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        printArray(array);
        //5th order statistic
        System.out.println(selectRandomized(array, 0, array.length - 1, 5));
        printArray(array);

        System.out.println(" - - - - - - - - - - - - - - - - - ");
        array = new int[]{9, 8, 7, 0};
        printArray(array);
        //3rd order statistic
        System.out.println(selectRandomized(array, 0, array.length - 1, 3));
        printArray(array);

        System.out.println(" - - - - - - - - - - - - - - - - - ");
        array = new int[]{3, 3, 2, 1, 4, 6, 5, 7};
        printArray(array);
        //1st order statistic (or 0st order statistic)
        System.out.println(selectRandomized(array, 0, array.length - 1, 0));
        printArray(array);

        System.out.println(" - - - - - - - - - - - - - - - - - ");
        array = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
        printArray(array);
        //1st order statistic (or 0st order statistic)
        System.out.println(selectRandomized(array, 0, array.length - 1, 0));
        printArray(array);
        System.out.println();

        System.out.println(" - - - - - - - - - - - - - - - - - ");
        array = new int[]{70, 90, 802, 2, 24, 45, 75, 66, 71};
        printArray(array);
        //n th order statistic (or maximum)
        System.out.println(selectRandomized(array, 0, array.length - 1, array.length));
        printArray(array);
        System.out.println(" - - - - - - - - - - - - - - - - - ");
        array = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
        printArray(array);
        //n th order statistic (or maximum)
        System.out.println(selectRandomized(array, 0, array.length - 1, array.length));
        printArray(array);

    }
}
