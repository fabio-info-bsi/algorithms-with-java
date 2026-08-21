package br.com.fabex.algorithms.sorting.linear;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

class LinearSortingIntTest extends SortBaseTest {

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[])` method, must order all elements of arrange.")
    void test1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSortingInt.selectionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[], int, int)` method, must order the elements of arrange in between  `startIndex` e `endIndex` indexes.")
    void test2() {
        //Arrange
        Arrays.sort(arrayCopy, 5, 11);

        //Act
        LinearSortingInt.selectionSort(array, 5, 11);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[], int)` method, must order the elements of until the `endIndex` index.")
    void test3() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 20);

        //Act
        LinearSortingInt.selectionSort(array, 20);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[])` method, must order all elements of arrange.")
    void test4() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSortingInt.insertionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);

    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[], int, int)` method, must order the elements of arrange in between  `startIndex` e `endIndex` indexes.")
    void test5() {
        //Arrange
        Arrays.sort(arrayCopy, 25, 50);

        //Act
        LinearSortingInt.insertionSort(array, 25, 50);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[], int)` method, must order the elements of until the `endIndex` index.")
    void test6() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 60);

        //Act
        LinearSortingInt.insertionSort(array, 60);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[])` method - stable version, must order all elements of arrange.")
    void test7() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSortingInt.bubbleSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[], int, int)` method - stable version, must order the elements of arrange in between  `startIndex` e `endIndex` indexes.")
    void test8() {
        //Arrange
        Arrays.sort(arrayCopy, 10, 35);

        //Act
        LinearSortingInt.bubbleSort(array, 10, 35);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[], int)` method - stable version, must order the elements of until the `endIndex` index.")
    void test9() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 33);

        //Act
        LinearSortingInt.bubbleSort(array, 33);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSortNotStable(int[])` method - not stable version, must order all elements of arrange.")
    void test10() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSortingInt.bubbleSortNotStable(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `selectionSort(int[], int, UnaryOperator)` method, must order the elements of until the `endIndex` index.")
    void test11() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 77);

        //Act
        IntUnaryOperator operator = num -> num;
        LinearSortingInt.selectionSort(array, 77, operator);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `insertionSort(int[], int, UnaryOperator)` method, must order the elements of until the `endIndex` index.")
    void test12() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 88);

        //Act
        IntUnaryOperator operator = (num) -> num;
        LinearSortingInt.insertionSort(array, 88, operator);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSort(int[], UnaryOperator)` method - stable version, must order all elements of arrange.")
    void test13() {

        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        IntUnaryOperator operator = num -> num;
        LinearSortingInt.bubbleSort(array, operator);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of integer randomized, when call `bubbleSortNotStable(int[], UnaryOperator)` method - not stable version, must order all elements.")
    void test14() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        IntUnaryOperator operator = num -> num;
        LinearSortingInt.bubbleSortNotStable(array, operator);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

}