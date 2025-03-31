package br.com.fabex.algorithms.sorting.comparison;


public class MergeSort {

    public static int[] sort(int[] array) {
        return sortImpl(array, 0, array.length - 1);
    }

    public static int[] sort(int[] array, int start, int end) {
        int[] arraySorted = sortImpl(array, start, end - 1);
        int[] arrayReordered = new int[array.length];
        System.arraycopy(array, 0, arrayReordered, 0, array.length);
        for (int i = start, j = 0; i < end; i++, j++) {
            arrayReordered[i] = arraySorted[j];
        }
        return arrayReordered;
    }

    private static int[] sortImpl(int[] array, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;
            return merge(sortImpl(array, start, middle), sortImpl(array, middle + 1, end));
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
}
