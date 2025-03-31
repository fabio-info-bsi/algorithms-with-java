package br.com.fabex.algorithms.sorting.comparison;

import java.util.Random;

import static br.com.fabex.util.ArrayUtils.printArray;


public class QuickSort {

    private static final Random RANDOM = new Random();

    public static void sort(int[] array) {
        sortImpl(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int startIndex, int endIndex) {
        sortImpl(array, startIndex, endIndex - 1);
    }

    private static void sortImpl(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // Partition array (rearranging)
            int pivot = partition(array, startIndex, endIndex);

            sortImpl(array, startIndex, pivot - 1); //Smaller side
            sortImpl(array, pivot + 1, endIndex); //Bigger side
        }
    }


    public static void sortRandomized(int[] array) {
        sortRandomizedImpl(array, 0, array.length - 1);
    }

    public static void sortRandomized(int[] array, int startIndex, int endIndex) {
        sortRandomizedImpl(array, startIndex, endIndex - 1);
    }

    private static void sortRandomizedImpl(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // Partition array (rearranging) randomized
            int pivot = partitionRandomized(array, startIndex, endIndex);

            sortRandomizedImpl(array, startIndex, pivot - 1); //Smaller side
            sortRandomizedImpl(array, pivot + 1, endIndex); //Bigger side
        }
    }

    public static int partition(int[] array, int startIndex, int pivotIndex) {
        int pivotValue = array[pivotIndex], i = startIndex - 1, temp;
        for (int j = startIndex; j <= pivotIndex - 1; j++) {
            if (array[j] <= pivotValue) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[i + 1];
        array[i + 1] = pivotValue; //or array[pivotIndex]
        array[pivotIndex] = temp;
        return i + 1;
    }

    public static int partitionRandomized(int[] array, int startIndex, int endIndex) {
        int pivot = RANDOM.nextInt(endIndex - startIndex + 1) + startIndex;
        int temp = array[pivot];
        array[pivot] = array[endIndex];
        array[endIndex] = temp;
        return partition(array, startIndex, endIndex);
    }
}
