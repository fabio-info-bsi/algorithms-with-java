package br.com.fabex.algorithms.sorting.comparison;

import br.com.fabex.algorithms.sorting.linear.SortBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSortTest extends SortBaseTest {

    @Test
    public void sortTest1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        QuickSort.sort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    public void sortTest2() {
        //Arrange
        Arrays.sort(arrayCopy, 88, 100);

        //Act
        QuickSort.sort(array, 88, 100);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    public void sortRandomizedTest1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        QuickSort.sortRandomized(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    public void sortRandomizedTest2() {
        //Arrange
        Arrays.sort(arrayCopy, 23, 51);

        //Act
        QuickSort.sortRandomized(array, 23, 51);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }
}