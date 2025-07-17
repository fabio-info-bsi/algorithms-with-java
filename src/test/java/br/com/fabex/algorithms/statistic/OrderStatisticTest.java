package br.com.fabex.algorithms.statistic;

import br.com.fabex.algorithms.sorting.linear.SortBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class OrderStatisticTest extends SortBaseTest {

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.select(int[], int, int, int)` method, must return i-th of the statistic order of the arrange.")
    void selectTest1() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = RANDOM.nextInt(array.length) + 1;

        //Act
        int result = OrderStatistic.select(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[iThOrderStatistic - 1], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.select(int[], int, int, int)` method, must return 1-th statistic order (first).")
    void selectTest2() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = 1;

        //Act
        int result = OrderStatistic.select(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[0], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.select(int[], int, int, int)` method, must return k-th statistic order (last).")
    void selectTest3() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = array.length;

        //Act
        int result = OrderStatistic.select(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[iThOrderStatistic - 1], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.select(int[], int, int, int)` method, must return [arrange.size/2]-th statistic order (median).")
    void selectTest4() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = array.length / 2;

        //Act
        int result = OrderStatistic.select(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[iThOrderStatistic - 1], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.selectRandomized(int[], int, int, int)` method, must return i-th of the statistic order of the arrange.")
    void selectRandomizedTest1() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = RANDOM.nextInt(array.length) + 1;

        //Act
        int result = OrderStatistic.selectRandomized(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[iThOrderStatistic - 1], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.selectRandomized(int[], int, int, int)` method, must return 1-th statistic order (first).")
    void selectRandomizedTest2() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = 1;

        //Act
        int result = OrderStatistic.selectRandomized(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[0], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.selectRandomized(int[], int, int, int)` method, must return k-th statistic order (last).")
    void selectRandomizedTest3() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = array.length;

        //Act
        int result = OrderStatistic.selectRandomized(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[iThOrderStatistic - 1], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.selectRandomized(int[], int, int, int)` method, must return [arrange.size/2]-th statistic order (median).")
    void selectRandomizedTest4() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = array.length / 2;

        //Act
        int result = OrderStatistic.selectRandomized(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[iThOrderStatistic - 1], result);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.max(int[], int)` method, must return largest element.")
    void maxTest1() {
        //Arrange
        Arrays.sort(arrayCopy);
        int max = Arrays.stream(arrayCopy).max().orElse(-1);

        //Act
        int maxResult = OrderStatistic.max(array, array.length);

        //Assert
        Assertions.assertEquals(max, maxResult);
        Assertions.assertEquals(arrayCopy[arrayCopy.length - 1], maxResult);
    }

    @Test
    @DisplayName("Given a arrange of integer empty, when call `OrderStatistic.max(int[], int)` method, must throw a IllegalArgumentException.")
    void maxTest2() {
        //Arrange
        array = new int[0];

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> OrderStatistic.max(array, array.length));
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.min(int[], int)` method, must return smallest element.")
    void minTest1() {
        //Arrange
        Arrays.sort(arrayCopy);
        int min = Arrays.stream(arrayCopy).min().orElse(-1);

        //Act
        int minResult = OrderStatistic.min(array, array.length);

        //Assert
        Assertions.assertEquals(min, minResult);
        Assertions.assertEquals(arrayCopy[0], minResult);
    }

    @Test
    @DisplayName("Given a arrange of integer empty, when call `OrderStatistic.min(int[], int)` method, must throw a IllegalArgumentException.")
    void minTest2() {
        //Arrange
        array = new int[0];

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> OrderStatistic.min(array, array.length));
    }
}