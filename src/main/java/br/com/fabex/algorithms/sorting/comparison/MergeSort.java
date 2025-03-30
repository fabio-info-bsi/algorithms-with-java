package br.com.fabex.algorithms.sorting.comparison;

import static br.com.fabex.util.ArrayUtils.printArray;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    public static int[] mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;
            return merge(mergeSort(array, start, middle), mergeSort(array, middle + 1, end));
        }
        return new int[]{array[start]};
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] merge = new int[array1.length + array2.length];
        int index = 0, i = 0, j = 0;

        while (i < array1.length && j < array2.length && index < merge.length) {
            if (array1[i] < array2[j]) {
                merge[index++] = array1[i++];
            } else {
                merge[index++] = array2[j++];
            }
        }

        for (; i < array1.length; i++)
            merge[index++] = array1[i];

        for (; j < array2.length; j++)
            merge[index++] = array2[j];

        return merge;
    }

    public static void main(String[] args) {
        int[] ints;

        ints = mergeSort(new int[]{10});
        printArray(ints);
        ints = mergeSort(new int[]{4, 3, 1, 2}, 0, 3);
        printArray(ints);
        ints = mergeSort(new int[]{4, 3, 1, 2, 6}, 0, 4);
        printArray(ints);
        ints = mergeSort(new int[]{4, 3, 1}, 0, 2);
        printArray(ints);
        ints = mergeSort(new int[]{4, 3, 2}, 0, 2);
        printArray(ints);
        ints = mergeSort(new int[]{4, 3, 5});
        printArray(ints);
        ints = mergeSort(new int[]{4, 3, 1, 2, 6, 5});
        printArray(ints);
    }
}
