package br.com.fabex.algorithms.sorting;

import java.util.Random;


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
}
