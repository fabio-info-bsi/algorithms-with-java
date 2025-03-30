package br.com.fabex.algorithms.sorting.linear.nocomparison;

import br.com.fabex.algorithms.sorting.linear.SortBaseTest;
import br.com.fabex.algorithms.statistic.OrderStatistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.UnaryOperator;

class CountingSortTest extends SortBaseTest {

    @Test
    public void sortTest1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        int[] arraySorted = CountingSort.sort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }

    @Test
    public void sortTest2() {
        //Arrange
        Arrays.sort(arrayCopy);
        int min = OrderStatistic.selectRandomized(array, 0, array.length - 1, 0);
        int max = OrderStatistic.selectRandomized(array, 0, array.length - 1, array.length);
        UnaryOperator<Integer> unaryOperator = (num) -> num;

        //Act
        int[] arraySorted = CountingSort.sort(array, array.length, unaryOperator, min, max);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }

    @Test
    public void sortPositiveNumbersTest1() {
        //Arrange
        int[] array = getArrayRandomized(10, 0, 10_000);
        int[] arrayCopy = new int[10];
        copyArrayOriginToTarget(array, arrayCopy);
        Arrays.sort(arrayCopy);

        //Act
        int[] arraySorted = CountingSort.sortPositiveNumbers(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, arraySorted);
    }
}