package br.com.fabex.algorithms.sorting;

import java.util.Arrays;

public class Main {

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

    private void printArray(int[] array) {
        System.out.print("[ ");
        for (int j : array) {
            if (j < Integer.MAX_VALUE) {
                System.out.print(j + " ");
            }
        }
        System.out.print("] \n");
    }

    public static void main(String[] args) {
        Main main = new Main();

        System.out.println("## Sort");

        int[] ints = main.sort(new int[]{4, 3, 1, 2});
        System.out.println(Arrays.toString(ints));
        ints = main.sort(new int[]{7, 5, 1, 8, 11, -1});
        System.out.println(Arrays.toString(ints));

        /* Initialize Array */
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.MAX_VALUE;

        System.out.println("## Insertion Sort");

        main.insertionSort(array, 1, 31);
        main.printArray(array);
        main.insertionSort(array, 2, 26);
        main.printArray(array);
        main.insertionSort(array, 3, 36);
        main.printArray(array);
        main.insertionSort(array, 4, 38);
        main.printArray(array);
        main.insertionSort(array, 5, 12);
        main.printArray(array);
        main.insertionSort(array, 1);
        main.printArray(array);
        main.insertionSort(array, 2);
        main.printArray(array);

    }
}
