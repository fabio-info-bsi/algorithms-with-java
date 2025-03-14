package br.com.fabex.algorithms.sorting.linear;

import java.util.Arrays;


import static br.com.fabex.util.ArrayUtil.printArray;

public class LinearSorting {

    public static void insertAndSort(int[] array, int endIndex, int newElement) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i] > newElement) {
                int temp = array[i];
                for (int j = i + 1; j < endIndex; j++) {
                    int nextItem = array[j];
                    array[j] = temp;
                    temp = nextItem;
                }
                array[i] = newElement;
                return;
            }
        }
    }

    public static void insertionSort(int[] array, int endIndex) {
        for (int i = 1; i < endIndex; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
            int minIndex = i;
            for (int j = i + 1; j < endIndex; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { // if need to exchange!
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("## Sort");

        int[] ints = new int[]{1, 2, 3, 4};
        bubbleSort(ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{4, 3, 1, 2};
        bubbleSort(ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{7, 5, 1, 8, 11, -1};
        bubbleSort(ints);
        System.out.println(Arrays.toString(ints));


        /* Initialize Array */
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.MAX_VALUE;

        System.out.println("## Insertion Sort");

        insertAndSort(array, 1, 31);
        printArray(array);
        insertAndSort(array, 2, 26);
        printArray(array);
        insertAndSort(array, 3, 36);
        printArray(array);
        insertAndSort(array, 4, 38);
        printArray(array);
        insertAndSort(array, 5, 12);
        printArray(array);
        insertionSort(array, 1);
        printArray(array);
        insertionSort(array, 2);
        printArray(array);

        ints = new int[]{12, 10, 11};
        printArray(ints);
        insertionSort(ints, ints.length);
        printArray(ints);

        System.out.println("## Selection Sort");
        ints = new int[]{12, 10, 11};
        printArray(ints);
        selectionSort(ints, ints.length);
        printArray(ints);
        ints = new int[]{3, 3, 2, 1, 4, 6, 5, 7, -1};
        printArray(ints);
        selectionSort(ints, ints.length);
        printArray(ints);
    }
}
