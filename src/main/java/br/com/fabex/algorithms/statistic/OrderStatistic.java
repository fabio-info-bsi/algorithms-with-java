package br.com.fabex.algorithms.statistic;

import br.com.fabex.algorithms.sorting.comparison.QuickSort;
import br.com.fabex.algorithms.sorting.linear.LinearSorting;

import java.util.Arrays;

import static br.com.fabex.util.ArrayUtil.printArray;

public class OrderStatistic {

    public static int select(int[] array, int startIndex, int endIndex, int iThOrderStatistic) {
        while ((endIndex - startIndex + 1) % 5 != 0) {
            for (int j = startIndex + 1; j <= endIndex; j++) {
                if (array[startIndex] > array[j]) {
                    int temp = array[j];
                    array[j] = array[startIndex];
                    array[startIndex] = temp;
                }
            }
            if (iThOrderStatistic == 1) {
                return array[startIndex];
            }
            startIndex++;
            iThOrderStatistic--;
        }

        // Number of 5 element group
        int numberOfGroup = (endIndex - startIndex + 1) / 5;

        for (int i = startIndex, indexGroup = 0; i <= startIndex + numberOfGroup - 1; i++, indexGroup += 5) {
            //Sorting each group
            LinearSorting.insertionSort(array, indexGroup, (indexGroup + 5 - 1)); // (Work!)
            //LinearSorting.selectionSort(array, indexGroup, (indexGroup + 5 - 1)); // (Maybe it works too)
        }

        int pivotValue = select(array, (startIndex + (2 * numberOfGroup)), (startIndex + (3 * numberOfGroup) - 1), Math.max((numberOfGroup / 2), 1));
        int pivotIndex = partitionAround(array, startIndex, endIndex, pivotValue);

        // Count number of elements [startIndex ~ pivotIndex] + 1 (pivot position)
        int countSubArrayElements = pivotIndex - startIndex + 1;

        if (iThOrderStatistic == countSubArrayElements) {
            return array[pivotIndex];
        } else if (iThOrderStatistic < countSubArrayElements) {
            return select(array, startIndex, pivotIndex - 1, iThOrderStatistic);
        } else {
            return select(array, pivotIndex + 1, endIndex,
                    iThOrderStatistic - countSubArrayElements);
        }
    }

    private static int partitionAround(int[] array, int startIndex, int endIndex, int pivotValue) {
        int pivotIndex = 0;
        //find pivot index
        while (array[pivotIndex] != pivotValue) {
            pivotIndex++;
        }
        //exchange pivot for last position
        array[pivotIndex] = array[endIndex];
        array[endIndex] = pivotValue;
        //call partition by QuickSort Impl
        return QuickSort.partition(array, startIndex, endIndex);
    }

    public static int selectRandomized(int[] array, int startIndex, int endIndex, int iThOrderStatistic) {
        if (startIndex == endIndex) {
            return array[startIndex];
        }
        // Math.max -> only positive > 0 to Random
        int pivot = QuickSort.partitionRandomized(array, startIndex, Math.max(endIndex, 1));

        // Count number of elements [startIndex ~ pivot] + 1 (pivot position)
        int countSubArrayElements = pivot - startIndex + 1;

        if (iThOrderStatistic == countSubArrayElements) {
            return array[pivot];
        } else if (iThOrderStatistic < countSubArrayElements) {
            return selectRandomized(array, startIndex, pivot - 1, iThOrderStatistic);
        } else {
            return selectRandomized(array, pivot + 1, endIndex,
                    iThOrderStatistic - countSubArrayElements);
        }
    }

    public static int max(int[] array, int size) {
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

    public static int min(int[] array, int size) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array empty");
        }
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array;
//        System.out.println("## Select Order Statistic Randomized ");
//
//        array = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
//        printArray(array);
//        //5th order statistic
//        System.out.println(selectRandomized(array, 0, array.length - 1, 5));
//        printArray(array);
//
//        System.out.println(" - - - - - - - - - - - - - - - - - ");
//        array = new int[]{9, 8, 7, 0};
//        printArray(array);
//        //3rd order statistic
//        System.out.println(selectRandomized(array, 0, array.length - 1, 3));
//        printArray(array);
//
//        System.out.println(" - - - - - - - - - - - - - - - - - ");
//        array = new int[]{3, 3, 2, 1, 4, 6, 5, 7};
//        printArray(array);
//        //1st order statistic (or 0st order statistic)
//        System.out.println(selectRandomized(array, 0, array.length - 1, 0));
//        printArray(array);
//
//        System.out.println(" - - - - - - - - - - - - - - - - - ");
//        array = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
//        printArray(array);
//        //1st order statistic (or 0st order statistic)
//        System.out.println(selectRandomized(array, 0, array.length - 1, 0));
//        printArray(array);
//        System.out.println();
//
//        System.out.println(" - - - - - - - - - - - - - - - - - ");
//        array = new int[]{70, 90, 802, 2, 24, 45, 75, 66, 71};
//        printArray(array);
//        //n th order statistic (or maximum)
//        System.out.println(selectRandomized(array, 0, array.length - 1, array.length));
//        printArray(array);
//        System.out.println(" - - - - - - - - - - - - - - - - - ");
//        array = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, 67151};
//        printArray(array);
//        //n th order statistic (or maximum)
//        System.out.println(selectRandomized(array, 0, array.length - 1, array.length));
//        printArray(array);
//
//        System.out.println();
        System.out.println("## Select Order Statistic");
        //array = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, -67151};
        //array = new int[]{31, 26, 36, 250, 38, 12, 301, 1, 2, 10, 11, 8, -67151, -14};
        //array = new int[]{70, 90, -802, 2, 24, 45, 75, 66, 71};
        //array = new int[]{-523, -756, 809, 210, -391, 587, 936, 843, -9, 386, -95, 828, 353, 715, -145, 609, -767, -585, 850, -429, 675, 9, 484, -647, -862, -857, -265, -525, -72, 919, 755, -395, -816, 805, -813, -578, 455, -180, 242, 325, 1000, 629, -361, 935, -851, 23, 887, 648, 132, -618, -358, -521, -598, 772, -269, -159, 287, 477, 83, -568, 507, -258, 337, 394, 90, 534, -395, 465, 693, -367, 321, -631, -83, -7, 280, 127, 716, 371, 435, 229, 248, 497, 759, -31, -710, -227, -71, 556, 835, 380, -372, 643, -571, 274, 489, 141, -53, 926, -545, 504, -256, 708, 663, 849, 911, -347, -107, 110, 542, -105, -349, 954, -693, -180, -292, 524, -907, -933, 697, -272, -883, -753, -413, -526, 801, 831, 929, 520, 945, 784, -946, 953, -567, -860, -141, 914, 29, -9, -496, -633, -726, -954, -654, 708, 307, 264, -92, -289, 765, 103, -975, -456, 863, -73, -997, 959, -226, -890, -816, 755, -7, 300, 213, -634, 830, 588, 654, -707, -857, -464, 435, 388, 321, -871, -295, 668, -825, 617, -275, 293, 492, 961, 211, -764, 885, -720, 530, -459, 910, -706, 409, -415, -430, -643, 272, -211, 242, -375, 4, -210};
        array = new int[]{-10001, 2, 3, 5, 8, 7, -523, -756, 809, 210, -391, 587, 936, 843, -9, 386, -95, 828, 353, 715, -145, 609, -767, -585, 850, -429, 675, 9, 484, -647, -862, -857, -265, -525, -72, 919, 755, -395, -816, 805, -813, -578, 455, -180, 242, 325, 1000, 629, -361, 935, -851, 23, 887, 648, 132, -618, -358, -521, -598, 772, -269, -159, 287, 477, 83, -568, 507, -258, 337, 394, 90, 534, -395, 465, 693, -367, 321, -631, -83, -7, 280, 127, 716, 371, 435, 229, 248, 497, 759, -31, -710, -227, -71, 556, 835, 380, -372, 643, -571, 274, 489, 141, -53, 926, -545, 504, -256, 708, 663, 849, 911, -347, -107, 110, 542, -105, -349, 954, -693, -180, -292, 524, -907, -933, 697, -272, -883, -753, -413, -526, 801, 831, 929, 520, 945, 784, -946, 953, -567, -860, -141, 914, 29, -9, -496, -633, -726, -954, -654, 708, 307, 264, -92, -289, 765, 103, -975, -456, 863, -73, -997, 959, -226, -890, -816, 755, -7, 300, 213, -634, 830, 588, 654, -707, -857, -464, 435, 388, 321, -871, -295, 668, -825, 617, -275, 293, 492, 961, 211, -764, 885, -720, 530, -459, 910, -706, 409, -415, -430, -643, 272, -211, 242, -375, 4, -210, 1};
        printArray(array);
        int iThOrderStatistic = array.length;///2;
        int result = select(array, 0, array.length - 1, iThOrderStatistic);
        int result2 = selectRandomized(array, 0, array.length - 1, iThOrderStatistic);
        System.out.println("select: " + result);
        System.out.println("selectRandomized: " + result2);
        System.out.println(Arrays.stream(array).min());
        System.out.println(Arrays.stream(array).max());
        printArray(array);
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        Arrays.sort(copy);
        printArray(copy);
        System.out.println(result == copy[iThOrderStatistic - 1]);
        //System.out.println(Arrays.equals(array, copy));

        System.out.println();

        System.out.println(" - - - - - - - - - - - - - - - - - ");
    }
}
