package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.sorting.linear.SortBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RadixSortTest extends SortBaseTest {

    @Test
    public void test1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        RadixSort.sort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    public void test2() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        RadixSort.sortByImplBubbleSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    public void test3() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        RadixSort.sortByImplInsertSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }
}