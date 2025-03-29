package br.com.fabex.algorithms.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class OrderStatisticTest {

    private final Random RANDOM = new Random();
    private int[] array, arrayCopy;

    @BeforeEach
    public void initialize() {
        int arraySize = 100;
        array = RANDOM.ints(arraySize, -10_000, 10_000).toArray();
        arrayCopy = new int[arraySize];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.select(int[], int, int, int)` method, must return i-th of the statistic order of the arrange.")
    public void selectTest1() {
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
    public void selectTest2() {
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
    public void selectTest3() {
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
    public void selectTest4() {
        //Arrange
        Arrays.sort(arrayCopy);
        int iThOrderStatistic = array.length / 2;

        //Act
        int result = OrderStatistic.select(array, 0, array.length - 1, iThOrderStatistic);

        //Assert
        Assertions.assertEquals(arrayCopy[iThOrderStatistic - 1], result);
        System.out.println(iThOrderStatistic + " | " + result);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayCopy));
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.selectRandomized(int[], int, int, int)` method, must return i-th of the statistic order of the arrange.")
    public void selectRandomizedTest1() {
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
    public void selectRandomizedTest2() {
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
    public void selectRandomizedTest3() {
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
    public void selectRandomizedTest4() {
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
    public void maxTest1() {
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
    public void maxTest2() {
        //Arrange
        array = new int[0];

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> OrderStatistic.max(array, array.length));
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `OrderStatistic.min(int[], int)` method, must return smallest element.")
    public void minTest1() {
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
    public void minTest2() {
        //Arrange
        array = new int[0];

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> OrderStatistic.min(array, array.length));
    }
}