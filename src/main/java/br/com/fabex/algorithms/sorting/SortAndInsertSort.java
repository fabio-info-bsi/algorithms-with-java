package br.com.fabex.algorithms.sorting;

import java.util.Arrays;


import static br.com.fabex.algorithms.sorting.Utils.printArray;
import static br.com.fabex.algorithms.sorting.Utils.printReverseArray;

public class SortAndInsertSort {

    private void insertionSort(int[] array, int newItem) {
        insertionSort(array, array.length, newItem);
    }

    private void insertionSort(int[] array, int endIndex, int newItem) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i] > newItem) {
                int temp = array[i];
                for (int j = i + 1; j < endIndex; j++) {
                    int nextItem = array[j];
                    array[j] = temp;
                    temp = nextItem;
                }
                array[i] = newItem;
                return;
            }
        }
    }

    private void insertionSortEnhancement(int[] array, int... newItems) {
        for (int index = 0, endIndex = 1; index < newItems.length; index++, endIndex++) {
            insertionSortEnhancement(array, newItems[index]);
        }
    }

    private void insertionSortEnhancement(int[] array, int newItem) {
        for (int i = 0; i < array.length; i++) {
            if (newItem > array[i]) {
                int temp = array[i];
                int j = i + 1;
                while (j < array.length) {
                    int nextItem = array[j];
                    array[j] = temp;
                    temp = nextItem;
                    j++;
                }
                array[i] = newItem;
                return;
            }
        }
    }

    /**
     * Correct
     *
     * @param array
     * @return
     */
    private int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    public static void main(String[] args) {
        SortAndInsertSort sortAndInsertSort = new SortAndInsertSort();

        System.out.println("## Sort");

        int[] ints;
        ints = sortAndInsertSort.sort(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
        ints = sortAndInsertSort.sort(new int[]{4, 3, 1, 2});
        System.out.println(Arrays.toString(ints));
        ints = sortAndInsertSort.sort(new int[]{7, 5, 1, 8, 11, -1});
        System.out.println(Arrays.toString(ints));


        /* Initialize Array */
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.MAX_VALUE;

        System.out.println("## Insertion Sort");

        sortAndInsertSort.insertionSort(array, 1, 31);
        printArray(array);
        sortAndInsertSort.insertionSort(array, 2, 26);
        printArray(array);
        sortAndInsertSort.insertionSort(array, 3, 36);
        printArray(array);
        sortAndInsertSort.insertionSort(array, 4, 38);
        printArray(array);
        sortAndInsertSort.insertionSort(array, 5, 12);
        printArray(array);
        sortAndInsertSort.insertionSort(array, 1);
        printArray(array);
        sortAndInsertSort.insertionSort(array, 2);
        printArray(array);

        int[] array1 = new int[7];
        sortAndInsertSort.insertionSortEnhancement(array1, 31, 26, 36, 38, 12, 1, 2);
        printReverseArray(array1);

        array1 = new int[7];
        sortAndInsertSort.insertionSortEnhancement(array1, 4, 5, 6, 3);
        printReverseArray(array1);
    }
}
