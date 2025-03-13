package br.com.fabex.algorithms.sorting.comparison;

import java.util.Random;

import static br.com.fabex.util.ArrayUtil.printArray;


public class QuickSort {

    private final Random RANDOM = new Random();

    public void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = partition(array, startIndex, endIndex); // Partition array (rearranging)
            sort(array, startIndex, middleIndex - 1); //Smaller side
            sort(array, middleIndex + 1, endIndex); //Bigger side
        }
    }

    public void sortRandomized(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = partitionRandomized(array, startIndex, endIndex); // Partition array (rearranging) randomized
            sortRandomized(array, startIndex, middleIndex - 1); //Smaller side
            sortRandomized(array, middleIndex + 1, endIndex); //Bigger side
        }
    }

    private int partition(int[] array, int startIndex, int pivotIndex) {
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

    private int partitionRandomized(int[] array, int startIndex, int endIndex) {
        int i = RANDOM.nextInt(endIndex) + 1;
        int temp = array[i];
        array[i] = array[endIndex];
        array[endIndex] = temp;
        return partition(array, startIndex, endIndex);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        //int[] array = {2, 8, 7, 1, 3, 5, 6, 4};
        //int[] array = {3, 3, 2, 1, 4, 6, 5, 7};
        //int[] array = {2, -1, 3, 4};
        int[] array = {9, 8, 7};
        //int[] array = {7, 8, 9};
        //int[] array = {2, 8, 7};
        //int[] array = {2, 8, 7, 1};
        //quickSort.sort(array, 0, array.length - 1);
        quickSort.sortRandomized(array, 0, array.length - 1);
        printArray(array);
    }
}
