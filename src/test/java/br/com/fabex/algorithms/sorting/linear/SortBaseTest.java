package br.com.fabex.algorithms.sorting.linear;

import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class SortBaseTest {

    protected final Random RANDOM = new Random();
    protected int[] array, arrayCopy;

    @BeforeEach
    public void initialize() {
        int arraySize = getSizeArray();
        array = getArrayRandomized(arraySize, getRandomNumberLowerBound(), getRandomNumberUpperBound());
        arrayCopy = new int[arraySize];
        copyArrayOriginToTarget(array, arrayCopy);
    }

    protected int[] getArrayRandomized(int size, int lowerBound, int upperBound) {
        return RANDOM.ints(size, lowerBound, upperBound).toArray();
    }

    protected void copyArrayOriginToTarget(int[] origin, int[] target) {
        System.arraycopy(origin, 0, target, 0, origin.length);
    }

    protected int getRandomNumberUpperBound() {
        return 1_000_000;
    }

    protected int getRandomNumberLowerBound() {
        return -1_000_000;
    }

    protected int getSizeArray() {
        return 100;
    }
}
