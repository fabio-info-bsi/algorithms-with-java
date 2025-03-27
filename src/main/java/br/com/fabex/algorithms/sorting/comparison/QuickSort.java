package br.com.fabex.algorithms.sorting.comparison;

import java.util.Random;

import static br.com.fabex.util.ArrayUtil.printArray;


public class QuickSort {

    private static final Random RANDOM = new Random();

    public static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // Partition array (rearranging)
            int pivot = partition(array, startIndex, endIndex);

            sort(array, startIndex, pivot - 1); //Smaller side
            sort(array, pivot + 1, endIndex); //Bigger side
        }
    }

    public static void sortRandomized(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // Partition array (rearranging) randomized
            int pivot = partitionRandomized(array, startIndex, endIndex);

            sortRandomized(array, startIndex, pivot - 1); //Smaller side
            sortRandomized(array, pivot + 1, endIndex); //Bigger side
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

    public static void main(String[] args) {

        int[] array;
        System.out.println("## Merge Sort ");

        array = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        printArray(array);
        sort(array, 0, array.length - 1);
        printArray(array);

        array = new int[]{3, 3, 2, 1, 4, 6, 5, 7};
        printArray(array);
        sort(array, 0, array.length - 1);
        printArray(array);

        array = new int[]{2, -1, 3, 4};
        printArray(array);
        sort(array, 0, array.length - 1);
        printArray(array);

        System.out.println("## Merge Sort Randomized");

        array = new int[]{9, 8, 7};
        printArray(array);
        sortRandomized(array, 0, array.length - 1);
        printArray(array);

        array = new int[]{2, 8, 7, 1};
        printArray(array);
        sortRandomized(array, 0, array.length - 1);
        printArray(array);

        array = new int[]{31, 26, 36, -250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
        printArray(array);
        sortRandomized(array, 0, array.length - 1);
        printArray(array);

        array = new int[]{3, 3, 2, 1, 4, 6, 5, 7};
        printArray(array);
        sortRandomized(array, 0, array.length - 1);
        printArray(array);

    }
}
