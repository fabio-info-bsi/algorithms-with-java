package br.com.fabex.algorithms.statistic;

import br.com.fabex.algorithms.sorting.comparison.QuickSort;
import br.com.fabex.algorithms.sorting.linear.LinearSorting;

public class OrderStatistic {

    public static int select(int[] array, int startIndex, int endIndex, int iThOrderStatistic) {
        while ((endIndex - startIndex + 1) % 5 != 0) {
            for (int j = startIndex + 1; j <= endIndex; j++) {
                if (array[startIndex] > array[j]) {
                    int temp = array[j];
                    array[j] = array[startIndex];
                    array[startIndex] = temp;
                }
            }
            if (iThOrderStatistic == 1) {
                return array[startIndex];
            }
            startIndex++;
            iThOrderStatistic--;
        }

        // Number of 5 element group
        int numberOfGroup = (endIndex - startIndex + 1) / 5;

        for (int i = startIndex, indexGroup = 0; i <= startIndex + numberOfGroup - 1; i++, indexGroup += 5) {
            //Sorting each group
            LinearSorting.insertionSort(array, indexGroup, (indexGroup + 5 - 1)); // (Work!)
            //LinearSorting.selectionSort(array, indexGroup, (indexGroup + 5 - 1)); // (Maybe it works too)
        }

        int pivotValue = select(array, (startIndex + (2 * numberOfGroup)), (startIndex + (3 * numberOfGroup) - 1), Math.max((numberOfGroup / 2), 1));
        int pivotIndex = partitionAround(array, startIndex, endIndex, pivotValue);

        // Count number of elements [startIndex ~ pivotIndex] + 1 (pivot position)
        int countSubArrayElements = pivotIndex - startIndex + 1;

        if (iThOrderStatistic == countSubArrayElements) {
            return array[pivotIndex];
        } else if (iThOrderStatistic < countSubArrayElements) {
            return select(array, startIndex, pivotIndex - 1, iThOrderStatistic);
        } else {
            return select(array, pivotIndex + 1, endIndex,
                    iThOrderStatistic - countSubArrayElements);
        }
    }

    private static int partitionAround(int[] array, int startIndex, int endIndex, int pivotValue) {
        int pivotIndex = 0;
        //find pivot index
        while (array[pivotIndex] != pivotValue) {
            pivotIndex++;
        }
        //exchange pivot for last position
        array[pivotIndex] = array[endIndex];
        array[endIndex] = pivotValue;
        //call partition by QuickSort Impl
        return QuickSort.partition(array, startIndex, endIndex);
    }

    public static int selectRandomized(int[] array, int startIndex, int endIndex, int iThOrderStatistic) {
        if (startIndex == endIndex) {
            return array[startIndex];
        }
        // Math.max -> only positive > 0 to Random
        int pivot = QuickSort.partitionRandomized(array, startIndex, Math.max(endIndex, 1));

        // Count number of elements [startIndex ~ pivot] + 1 (pivot position)
        int countSubArrayElements = pivot - startIndex + 1;

        if (iThOrderStatistic == countSubArrayElements) {
            return array[pivot];
        } else if (iThOrderStatistic < countSubArrayElements) {
            return selectRandomized(array, startIndex, pivot - 1, iThOrderStatistic);
        } else {
            return selectRandomized(array, pivot + 1, endIndex,
                    iThOrderStatistic - countSubArrayElements);
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
}
