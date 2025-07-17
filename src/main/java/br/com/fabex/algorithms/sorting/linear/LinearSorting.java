package br.com.fabex.algorithms.sorting.linear;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.function.UnaryOperator;


import static br.com.fabex.util.ArrayUtils.printArray;

public class LinearSorting {

    private static final Logger logger = LoggerFactory.getLogger(LinearSorting.class);

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

    /**
     * This algorithm is stable.
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        insertionSort(array, 0, array.length);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param endIndex
     */
    public static void insertionSort(int[] array, int endIndex) {
        insertionSort(array, 0, endIndex);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void insertionSort(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= startIndex && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param endIndex
     * @param operator
     */
    public static void insertionSort(int[] array, int endIndex, UnaryOperator<Integer> operator) {
        for (int i = 1; i < endIndex; i++) {
            int key = operator.apply(array[i]);
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && operator.apply(array[j]) > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = value;
        }
    }

    /**
     * This algorithm isn't stable.
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        selectionSort(array, array.length);
    }

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param endIndex
     */
    public static void selectionSort(int[] array, int endIndex) {
        selectionSort(array, 0, endIndex);
    }

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void selectionSort(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
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

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param endIndex
     * @param operator
     */
    public static void selectionSort(int[] array, int endIndex, UnaryOperator<Integer> operator) {
        for (int i = 0; i < endIndex; i++) {
            int minIndex = i;
            for (int j = i + 1; j < endIndex; j++) {
                if (operator.apply(array[j]) < operator.apply(array[minIndex])) {
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

    /**
     * This algorithm isn't stable.
     *
     * @param array
     */
    public static void bubbleSortNotStable(int[] array) {
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

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param operator
     */
    public static void bubbleSortNotStable(int[] array, UnaryOperator<Integer> operator) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (operator.apply(array[i]) > operator.apply(array[j])) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        bubbleSort(array, 0, array.length);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param endIndex
     */
    public static void bubbleSort(int[] array, int endIndex) {
        bubbleSort(array, 0, endIndex);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void bubbleSort(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex - 1; i++) {
            for (int j = startIndex; j < startIndex - (i - endIndex) - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param operator
     */
    public static void bubbleSort(int[] array, UnaryOperator<Integer> operator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (operator.apply(array[j]) > operator.apply(array[j + 1])) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        /* Initialize Array */
        int[] array = new int[10];
        Arrays.fill(array, Integer.MAX_VALUE);

        logger.debug("## Insert and Sort");

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
    }
}
