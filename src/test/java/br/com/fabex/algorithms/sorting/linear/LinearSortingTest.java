package br.com.fabex.algorithms.sorting.linear;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.UnaryOperator;

public class LinearSortingTest {

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
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[])` method, must order all elements of arrange.")
    public void test1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.selectionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);

    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[], int, int)` method, must order the elements of arrange in between  `startIndex` e `endIndex` indexes.")
    public void test2() {
        //Arrange
        Arrays.sort(arrayCopy, 5, 11);

        //Act
        LinearSorting.selectionSort(array, 5, 11);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[], int)` method, must order the elements of until the `endIndex` index.")
    public void test3() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 20);

        //Act
        LinearSorting.selectionSort(array, 20);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[])` method, must order all elements of arrange.")
    public void test4() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.insertionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);

    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[], int, int)` method, must order the elements of arrange in between  `startIndex` e `endIndex` indexes.")
    public void test5() {
        //Arrange
        Arrays.sort(arrayCopy, 25, 50);

        //Act
        LinearSorting.insertionSort(array, 25, 50);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[], int)` method, must order the elements of until the `endIndex` index.")
    public void test6() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 60);

        //Act
        LinearSorting.insertionSort(array, 60);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[])` method - stable version, must order all elements of arrange.")
    public void test7() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.bubbleSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[], int, int)` method - stable version, must order the elements of arrange in between  `startIndex` e `endIndex` indexes.")
    public void test8() {
        //Arrange
        Arrays.sort(arrayCopy, 10, 35);

        //Act
        LinearSorting.bubbleSort(array, 10, 35);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[], int)` method - stable version, must order the elements of until the `endIndex` index.")
    public void test9() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 33);

        //Act
        LinearSorting.bubbleSort(array, 33);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSortNotStable(int[])` method - not stable version, must order all elements of arrange.")
    public void test10() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.bubbleSortNotStable(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[], int, UnaryOperator)` method, must order the elements of until the `endIndex` index.")
    public void test11() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 77);

        //Act
        UnaryOperator<Integer> operator = (num) -> num;
        LinearSorting.selectionSort(array, 77, operator);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[], int, UnaryOperator)` method, must order the elements of until the `endIndex` index.")
    public void test12() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 88);

        //Act
        UnaryOperator<Integer> operator = (num) -> num;
        LinearSorting.insertionSort(array, 88, operator);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[], UnaryOperator)` method - stable version, must order all elements of arrange.")
    public void test13() {

        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        UnaryOperator<Integer> operator = (num) -> num;
        LinearSorting.bubbleSort(array, operator);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

}