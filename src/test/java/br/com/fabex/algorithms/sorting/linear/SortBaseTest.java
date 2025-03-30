package br.com.fabex.algorithms.sorting.linear;

import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class SortBaseTest {

    protected final Random RANDOM = new Random();
    protected int[] array, arrayCopy;

    @BeforeEach
    public void initialize() {
        int arraySize = 100;
        array = RANDOM.ints(arraySize, -1_000_000, 1_000_000).toArray();
        arrayCopy = new int[arraySize];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
    }

}
