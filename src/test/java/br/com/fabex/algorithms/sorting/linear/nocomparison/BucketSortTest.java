package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.sorting.linear.SortBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BucketSortTest extends SortBaseTest {

    @Test
    public void sortTest1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        int[] arraySorted = BucketSort.sort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }

    @Test
    public void sortPositiveNumbersTest1() {
        //Arrange
        int[] array = getArrayRandomized(10, 0, 1_000_000);
        int[] arrayCopy = new int[10];
        copyArrayOriginToTarget(array, arrayCopy);
        Arrays.sort(arrayCopy);

        //Act
        int[] arraySorted = BucketSort.sortPositiveNumbers(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }
}