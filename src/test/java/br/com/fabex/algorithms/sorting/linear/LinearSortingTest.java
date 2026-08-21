package br.com.fabex.algorithms.sorting.linear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class LinearSortingTest {

    private static final int SIZE = 100;
    private final Random RANDOM = new Random();

    protected Integer[] array, arrayCopy;

    @BeforeEach
    void initialize() {
        array = RANDOM.ints(SIZE, -1_000_000, 1_000_000)
                .boxed()
                .toArray(Integer[]::new);
        arrayCopy = Arrays.copyOf(array, SIZE);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `selectionSort(T[])` method, must order all elements of arrange.")
    void test1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.selectionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `selectionSort(T[], int, int)` method, must order the elements of arrange in between `startIndex` e `endIndex` indexes.")
    void test2() {
        //Arrange
        Arrays.sort(arrayCopy, 5, 11);

        //Act
        LinearSorting.selectionSort(array, 5, 11);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `selectionSort(T[], int)` method, must order the elements until the `endIndex` index.")
    void test3() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 20);

        //Act
        LinearSorting.selectionSort(array, 20);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `insertionSort(T[])` method, must order all elements of arrange.")
    void test4() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.insertionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `insertionSort(T[], int, int)` method, must order the elements of arrange in between `startIndex` e `endIndex` indexes.")
    void test5() {
        //Arrange
        Arrays.sort(arrayCopy, 25, 50);

        //Act
        LinearSorting.insertionSort(array, 25, 50);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `insertionSort(T[], int)` method, must order the elements until the `endIndex` index.")
    void test6() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 60);

        //Act
        LinearSorting.insertionSort(array, 60);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `bubbleSort(T[])` method - stable version, must order all elements of arrange.")
    void test7() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.bubbleSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `bubbleSort(T[], int, int)` method - stable version, must order the elements of arrange in between `startIndex` e `endIndex` indexes.")
    void test8() {
        //Arrange
        Arrays.sort(arrayCopy, 10, 35);

        //Act
        LinearSorting.bubbleSort(array, 10, 35);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `bubbleSort(T[], int)` method - stable version, must order the elements until the `endIndex` index.")
    void test9() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 33);

        //Act
        LinearSorting.bubbleSort(array, 33);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of Integer randomized, when call `bubbleSortNotStable(T[])` method - not stable version, must order all elements of arrange.")
    void test10() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.bubbleSortNotStable(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Given a arrange of String randomized, when call `selectionSort(T[])` method, must order all elements lexicographically.")
    void test12() {
        //Arrange
        String[] strings = randomStrings(SIZE);
        String[] stringsCopy = Arrays.copyOf(strings, SIZE);
        Arrays.sort(stringsCopy);

        //Act
        LinearSorting.selectionSort(strings);

        //Assert
        Assertions.assertArrayEquals(stringsCopy, strings);
    }

    @Test
    @DisplayName("Given a arrange of String randomized, when call `insertionSort(T[])` method, must order all elements lexicographically.")
    void test13() {
        //Arrange
        String[] strings = randomStrings(SIZE);
        String[] stringsCopy = Arrays.copyOf(strings, SIZE);
        Arrays.sort(stringsCopy);

        //Act
        LinearSorting.insertionSort(strings);

        //Assert
        Assertions.assertArrayEquals(stringsCopy, strings);
    }

    @Test
    @DisplayName("Given a arrange of String randomized, when call `bubbleSort(T[])` method - stable version, must order all elements lexicographically.")
    void test14() {
        //Arrange
        String[] strings = randomStrings(SIZE);
        String[] stringsCopy = Arrays.copyOf(strings, SIZE);
        Arrays.sort(stringsCopy);

        //Act
        LinearSorting.bubbleSort(strings);

        //Assert
        Assertions.assertArrayEquals(stringsCopy, strings);
    }

    private String[] randomStrings(int size) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            char[] chars = new char[5];
            for (int c = 0; c < chars.length; c++) {
                chars[c] = (char) ('a' + RANDOM.nextInt(26));
            }
            arr[i] = new String(chars);
        }
        return arr;
    }
}
