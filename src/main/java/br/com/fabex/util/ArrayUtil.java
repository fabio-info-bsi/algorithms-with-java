package br.com.fabex.util;

import java.util.Arrays;

public class ArrayUtil {

    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int j : array) {
            if (j < Integer.MAX_VALUE) {
                System.out.print(j + " ");
            }
        }
        System.out.print("] \n");
    }

    public static void printArray(int[] array, int endIndex) {
        System.out.print("[ ");
        for (int j = 0; j <= endIndex; j++) {
            if (array[j] < Integer.MAX_VALUE) {
                System.out.print(array[j] + " ");
            }
        }
        System.out.print("] \n");
    }

    public static void printReverseArray(int[] array) {
        System.out.print("[ ");
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.print("] \n");
    }

    public static int maxElementArrayByStream(int[] array, int size) {
        return Arrays.stream(array).limit(size).max().orElseThrow(() -> new IllegalArgumentException("Array empty"));
    }

    public static int maxElement(int[] array, int size) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array empty");
        }
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}
