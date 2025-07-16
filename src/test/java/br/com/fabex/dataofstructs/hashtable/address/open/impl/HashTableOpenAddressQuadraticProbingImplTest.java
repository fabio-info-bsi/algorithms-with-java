package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;


class HashTableOpenAddressQuadraticProbingImplTest {

    @Test
    void capacity() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void search() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void reHashWhenInsertNotFoundSlotAvailableAndIncreaseSizeTableTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(28, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        LongStream.rangeClosed(0, 27).forEach(i -> htoalp.insert(new CustomStorableTest(i, "Hi, " + i + "!")));

        CustomStorableTest newElement = new CustomStorableTest(129L, "Lucas");
        int oldSize = htoalp.size();
        htoalp.showDisplay();

        //Act
        htoalp.insert(newElement);
        htoalp.showDisplay();

        //Asserts
        Assertions.assertFalse(htoalp.isFull());
        Assertions.assertNotNull(htoalp.search(newElement));
        Assertions.assertNotEquals(-1, htoalp.indexOf(newElement));
        Assertions.assertNotEquals(oldSize, htoalp.capacity());
        Assertions.assertEquals(56, htoalp.capacity());
        Assertions.assertEquals(29, htoalp.size());
    }

    @Test
    void reHashWhenThereAreSlotsDeletedAndIncreaseSizeTableTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(28, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        LongStream.rangeClosed(0, 27).forEach(i -> htoalp.insert(new CustomStorableTest(i, "Hi, " + i + "!")));
        int oldSize = htoalp.size();
        htoalp.showDisplay();
        CustomStorableTest deleteElement = new CustomStorableTest(15L);
        htoalp.delete(deleteElement);
        htoalp.showDisplay();
        CustomStorableTest newElement = new CustomStorableTest(163L, "Lucas");

        //Act
        htoalp.insert(newElement);
        htoalp.showDisplay();

        //Asserts
        Assertions.assertNull(htoalp.search(deleteElement));
        Assertions.assertEquals(-1, htoalp.indexOf(deleteElement));
        Assertions.assertNotNull(htoalp.search(newElement));
        Assertions.assertNotEquals(-1, htoalp.indexOf(newElement));
        Assertions.assertFalse(htoalp.isFull());
        Assertions.assertNotEquals(oldSize, htoalp.capacity());
        Assertions.assertEquals(56, htoalp.capacity());
        Assertions.assertEquals(28, htoalp.size());
    }

    @Test
    void reHashWhenThereAreCollisionInReallocatingSlotsTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(2, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        LongStream.rangeClosed(0, 50).forEach(i -> htoalp.insert(new CustomStorableTest(i * 2, "Hi, " + i + "!")));
        LongStream.rangeClosed(51, 100).forEach(i -> htoalp.insert(new CustomStorableTest(i * 3, "Hi, " + (i * 3) + "!")));
        int oldSize = htoalp.size();
        htoalp.showDisplay();
        CustomStorableTest deleteElement = new CustomStorableTest(15L);
        htoalp.delete(deleteElement);
        htoalp.showDisplay();
        CustomStorableTest newElement = new CustomStorableTest(1630L, "Lucas");

        //Act
        htoalp.insert(newElement);
        htoalp.showDisplay();

        //Asserts
        Assertions.assertNull(htoalp.search(deleteElement));
        Assertions.assertEquals(-1, htoalp.indexOf(deleteElement));
        Assertions.assertNotNull(htoalp.search(newElement));
        Assertions.assertNotEquals(-1, htoalp.indexOf(newElement));
        Assertions.assertFalse(htoalp.isFull());
        Assertions.assertNotEquals(oldSize, htoalp.capacity());
        Assertions.assertEquals(128, htoalp.capacity());
        Assertions.assertEquals(102, htoalp.size());
    }
}