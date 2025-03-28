package br.com.fabex.algorithms.sorting.linear;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.UnaryOperator;

class LinearSortingTest {

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
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array completo com algoritmo selectionSort")
    public void test1() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.selectionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);

    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array de acordo com os índices de início e fim com algoritmo selectionSort")
    public void test2() {
        //Arrange
        Arrays.sort(arrayCopy, 5, 11);

        //Act
        LinearSorting.selectionSort(array, 5, 11);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array até o índice de fim com algoritmo selectionSort")
    public void test3() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 20);

        //Act
        LinearSorting.selectionSort(array, 20);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array completo com algoritmo insertionSort")
    public void test4() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.insertionSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);

    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array de acordo com os índices de início e fim com algoritmo insertionSort")
    public void test5() {
        //Arrange
        Arrays.sort(arrayCopy, 25, 50);

        //Act
        LinearSorting.insertionSort(array, 25, 50);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array até o índice de fim com algoritmo insertionSort")
    public void test6() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 60);

        //Act
        LinearSorting.insertionSort(array, 60);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array completo com algoritmo bubbleSort(stable)")
    public void test7() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.bubbleSort(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array de acordo com os índices de início e fim com algoritmo bubbleSort(stable)")
    public void test8() {
        //Arrange
        Arrays.sort(arrayCopy, 10, 35);

        //Act
        LinearSorting.bubbleSort(array, 10, 35);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array até o índice de fim com algoritmo bubbleSort(stable)")
    public void test9() {
        //Arrange
        Arrays.sort(arrayCopy, 0, 33);

        //Act
        LinearSorting.bubbleSort(array, 33);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array completo com algoritmo bubbleSortNotStable")
    public void test10() {
        //Arrange
        Arrays.sort(arrayCopy);

        //Act
        LinearSorting.bubbleSortNotStable(array);

        //Assert
        Assertions.assertArrayEquals(arrayCopy, array);
    }

    @Test
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array até o índice de fim com algoritmo selectionSort (UnaryOperator)")
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
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array até o índice de fim com algoritmo (UnaryOperator)")
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
    @DisplayName("Dado um conjunto de elementos em um array randomized, deve ordenar array completo com algoritmo bubbleSort(stable) (UnaryOperator)")
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