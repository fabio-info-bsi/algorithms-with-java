package br.com.fabex.algorithms.sorting.comparison;

import br.com.fabex.algorithms.sorting.linear.SortBaseTest;
import br.com.fabex.util.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HeapSortTest extends SortBaseTest {

    @Test
    public void heapSortTest1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        HeapSort.sort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    public void heapExtractMaxTest1() {
        //Arrange
        Arrays.sort(arrayCopy);
        int max = Arrays.stream(arrayCopy).max().orElse(-1);

        //Act
        int maxResult = HeapSort.heapExtractMax(array);

        //Assert
        Assertions.assertEquals(max, maxResult);
        Assertions.assertEquals(arrayCopy[arrayCopy.length - 1], maxResult);
    }

    @Test
    public void heapInsertTest1() {
        //Arrange
        int[] array = new int[9], arrayCopy = new int[]{4, 10, 14, 7, 9, 3, 2, 8, 1};
        Arrays.sort(arrayCopy);

        //Act
        HeapSort heapSort = new HeapSort(array);
        heapSort.heapInsert(4, 10, 14, 7, 9, 3, 2, 8, 1);
        int [] arraySorted = heapSort.sort();
        ArrayUtils.printArray(arraySorted);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }

    @Test
    public void heapInsertTest2() {
        //Arrange
        int[] arrayCopy = new int[10];

        //Act
        HeapSort heapSort = new HeapSort(10);
        heapSort.heapInsert( 150);
        heapSort.heapInsert( 31);
        heapSort.heapInsert( 26);
        heapSort.heapInsert( 36);
        heapSort.heapInsert( 38);
        heapSort.heapInsert( 12);
        heapSort.heapInsert( -1);
        heapSort.heapInsert( -2);
        heapSort.heapInsert( -90);
        heapSort.heapInsert( -150);
        int [] arraySorted = heapSort.sort();
        copyArrayOriginToTarget(arraySorted, arrayCopy);
        Arrays.sort(arrayCopy);
        ArrayUtils.printArray(arraySorted);

        //Assert
        Assertions.assertArrayEquals(arraySorted, arrayCopy);
    }

}