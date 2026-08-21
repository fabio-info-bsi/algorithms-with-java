package br.com.fabex.algorithms.sorting.linear;

public class LinearSorting {

    private LinearSorting() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        insertionSort(array, 0, array.length);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param endIndex
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array, int endIndex) {
        insertionSort(array, 0, endIndex);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= startIndex && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        selectionSort(array, array.length);
    }

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param endIndex
     * @param <T>
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array, int endIndex) {
        selectionSort(array, 0, endIndex);
    }

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @param <T>
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            int minIndex = i;
            for (int j = i + 1; j < endIndex; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { // if need to exchange!
                T temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * This algorithm isn't stable.
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSortNotStable(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    T temp = array[i];
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
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        bubbleSort(array, 0, array.length);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param endIndex
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array, int endIndex) {
        bubbleSort(array, 0, endIndex);
    }

    /**
     * This algorithm is stable.
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex - 1; i++) {
            for (int j = startIndex; j < startIndex - (i - endIndex) - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
