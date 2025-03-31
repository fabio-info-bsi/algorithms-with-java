package br.com.fabex.algorithms.sorting.comparison;

import br.com.fabex.algorithms.sorting.linear.SortBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest extends SortBaseTest {

    @Test
    public void sortImplTest() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        int[] arraySorted = MergeSort.sort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }

    @Test
    public void sortImplTest2() {
        //Arrange
        Arrays.sort(arrayCopy, 5, 15);

        //Act
        int[] arraySorted = MergeSort.sort(array, 5, 15);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }
}