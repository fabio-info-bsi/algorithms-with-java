package br.com.fabex.algorithms.sorting.linear;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinearSortingTypeCarTest {

    private static final int SIZE = 100;
    private static final Random RANDOM = new Random();
    private static final String[] MODELOS = {
            "Gol", "Uno", "Palio", "Celta", "Corsa", "Fiesta", "Ka",
            "HB20", "Onix", "Kwid", "Sandero", "Logan", "Clio", "Fusca",
            "Civic", "Corolla", "Hilux", "S10", "Ranger", "Amarok"
    };
    private static final String[] CORES = {
            "Branco", "Preto", "Prata", "Cinza", "Vermelho",
            "Azul", "Verde", "Amarelo", "Laranja", "Bege"
    };

    /**
     * Representa um Car com modelo, número de série, cor e year.
     */
    record Car(String modelo, int numberOfSerie, String cor, int year) {
    }

    /**
     * Wrapper de {@link Car} com ordenação natural por <b>modelo</b> (alfabética).
     */
    record CarByModelo(Car car) implements Comparable<CarByModelo> {
        @Override
        public int compareTo(CarByModelo other) {
            return this.car.modelo().compareTo(other.car.modelo());
        }
    }

    /**
     * Wrapper de {@link Car} com ordenação natural por <b>year</b> (crescente).
     */
    record CarByYear(Car car) implements Comparable<CarByYear> {
        @Override
        public int compareTo(CarByYear other) {
            return Integer.compare(this.car.year(), other.car.year());
        }
    }

    /**
     * Wrapper de {@link Car} com ordenação natural por <b>número de série</b> (crescente).
     */
    record CarByNumberOfSerie(Car car) implements Comparable<CarByNumberOfSerie> {
        @Override
        public int compareTo(CarByNumberOfSerie other) {
            return Integer.compare(this.car.numberOfSerie(), other.car.numberOfSerie());
        }
    }

    private Car[] randomCars(int size) {
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++) {
            String modelo = MODELOS[RANDOM.nextInt(MODELOS.length)];
            int numeroDeSerie = RANDOM.nextInt(1_000_000);
            String cor = CORES[RANDOM.nextInt(CORES.length)];
            int ano = 1990 + RANDOM.nextInt(36); // 1990 – 2025
            cars[i] = new Car(modelo, numeroDeSerie, cor, ano);
        }
        return cars;
    }

    private CarByModelo[] wrapByModelo(Car[] cars) {
        CarByModelo[] wrapped = new CarByModelo[cars.length];
        for (int i = 0; i < cars.length; i++) {
            wrapped[i] = new CarByModelo(cars[i]);
        }
        return wrapped;
    }

    private CarByYear[] wrapByAno(Car[] cars) {
        CarByYear[] wrapped = new CarByYear[cars.length];
        for (int i = 0; i < cars.length; i++) {
            wrapped[i] = new CarByYear(cars[i]);
        }
        return wrapped;
    }

    private CarByNumberOfSerie[] wrapByNumeroDeSerie(Car[] cars) {
        CarByNumberOfSerie[] wrapped = new CarByNumberOfSerie[cars.length];
        for (int i = 0; i < cars.length; i++) {
            wrapped[i] = new CarByNumberOfSerie(cars[i]);
        }
        return wrapped;
    }

    @Test
    @DisplayName("Given an array of Car, when call `selectionSort(T[])` sorting by model, must order all elements by model.")
    void test15() {
        //Arrange
        LinearSortingTypeCarTest.CarByModelo[] cars = wrapByModelo(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByModelo[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.selectionSort(cars);

        //Assert
        /* The selectionSort algorithm is not stable; therefore, it was necessary to convert the array to the data type of the search index. */
        Assertions.assertArrayEquals(
                Arrays.stream(carsCopy).map(carByModelo -> carByModelo.car().modelo).toArray(),
                Arrays.stream(cars).map(carByModelo -> carByModelo.car().modelo).toArray());
    }

    @Test
    @DisplayName("Given an array of Car, when call `insertionSort(T[])` sorting by model, must order all elements by model.")
    void test16() {
        //Arrange
        LinearSortingTypeCarTest.CarByModelo[] cars = wrapByModelo(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByModelo[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.insertionSort(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }

    @Test
    @DisplayName("Given an array of Car, when call `bubbleSort(T[])` - stable version - sorting by model, must order all elements by model.")
    void test17() {
        //Arrange
        LinearSortingTypeCarTest.CarByModelo[] cars = wrapByModelo(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByModelo[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.bubbleSort(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }

    @Test
    @DisplayName("Given an array of Car, when call `bubbleSortNotStable(T[])` - not stable version - sorting by model, must order all elements by model.")
    void test18() {
        //Arrange
        LinearSortingTypeCarTest.CarByModelo[] cars = wrapByModelo(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByModelo[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.bubbleSortNotStable(cars);

        //Assert
        /* The bubbleSortNotStable algorithm is not stable; therefore, it was necessary to convert the array to the data type of the search index. */
        Assertions.assertArrayEquals(
                Arrays.stream(carsCopy).map(carByModelo -> carByModelo.car().modelo).toArray(),
                Arrays.stream(cars).map(carByModelo -> carByModelo.car().modelo).toArray());
    }

    @Test
    @DisplayName("Given an array of Car, when call `selectionSort(T[])` sorting by year, must order all elements by year.")
    void test19() {
        //Arrange
        LinearSortingTypeCarTest.CarByYear[] cars = wrapByAno(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByYear[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.selectionSort(cars);

        //Assert
        /* The selectionSort algorithm is not stable; therefore, it was necessary to convert the array to the data type of the search index. */
        Assertions.assertArrayEquals(
                Arrays.stream(carsCopy).map(carByModelo -> carByModelo.car().year).toArray(),
                Arrays.stream(cars).map(carByModelo -> carByModelo.car().year).toArray());
    }

    @Test
    @DisplayName("Given an array of Car, when call `insertionSort(T[])` sorting by year, must order all elements by year.")
    void test20() {
        //Arrange
        LinearSortingTypeCarTest.CarByYear[] cars = wrapByAno(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByYear[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.insertionSort(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }

    @Test
    @DisplayName("Given an array of Car, when call `bubbleSort(T[])` - stable version - sorting by year, must order all elements by year.")
    void test21() {
        //Arrange
        LinearSortingTypeCarTest.CarByYear[] cars = wrapByAno(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByYear[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.bubbleSort(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }

    @Test
    @DisplayName("Given an array of Car, when call `selectionSort(T[])` sorting by serial number, must order all elements by serial number.")
    void test22() {
        //Arrange
        LinearSortingTypeCarTest.CarByNumberOfSerie[] cars = wrapByNumeroDeSerie(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByNumberOfSerie[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.selectionSort(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }

    @Test
    @DisplayName("Given an array of Car, when call `insertionSort(T[])` sorting by serial number, must order all elements by serial number.")
    void test23() {
        //Arrange
        LinearSortingTypeCarTest.CarByNumberOfSerie[] cars = wrapByNumeroDeSerie(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByNumberOfSerie[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.insertionSort(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }

    @Test
    @DisplayName("Given an array of Car, when call `bubbleSort(T[])` - stable version - sorting by serial number, must order all elements by serial number.")
    void test24() {
        //Arrange
        LinearSortingTypeCarTest.CarByNumberOfSerie[] cars = wrapByNumeroDeSerie(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByNumberOfSerie[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.bubbleSort(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }

    @Test
    @DisplayName("Given an array of Car, when call `bubbleSortNotStable(T[])` - not stable version - sorting by serial number, must order all elements by serial number.")
    void test25() {
        //Arrange
        LinearSortingTypeCarTest.CarByNumberOfSerie[] cars = wrapByNumeroDeSerie(randomCars(SIZE));
        LinearSortingTypeCarTest.CarByNumberOfSerie[] carsCopy = Arrays.copyOf(cars, SIZE);
        Arrays.sort(carsCopy);

        //Act
        LinearSorting.bubbleSortNotStable(cars);

        //Assert
        Assertions.assertArrayEquals(carsCopy, cars);
    }
}
