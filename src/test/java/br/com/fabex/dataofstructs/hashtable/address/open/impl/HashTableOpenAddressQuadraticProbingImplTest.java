package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.exception.HastTableOverflowException;
import br.com.fabex.dataofstructs.hashtable.exception.ProbingFailedException;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;


class HashTableOpenAddressQuadraticProbingImplTest {

    @Test
    void capacityWhenNotExistElementsTest() {
        //Act & Asserts
        Assertions.assertEquals(10, new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, true).capacity());
    }

    @Test
    void capacityWhenExistElementsTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htca = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
        htca.insert(new CustomStorableTest(1L, "Carlos"));
        htca.insert(new CustomStorableTest(2L, "Edgar"));

        //Act & Asserts
        Assertions.assertEquals(10, htca.capacity());
    }

    @Test
    void insertWithHashFunctionDivisionWhenIsFullTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(0L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(1L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(2L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(3L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(4L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(5L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(6L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(7L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(8L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(9L, "JhowJhow"));

        //Act & Asserts
        Assertions.assertTrue(htoalp.isFull());
        Assertions.assertEquals(10, htoalp.size());
    }

    @Test
    void insertWithHashFunctionDivisionWhenExistCollisionTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        htoalp.insert(new CustomStorableTest(21L, "Lucas"));
        //Act & Asserts
        htoalp.showDisplay();
        Assertions.assertEquals(1, htoalp.getCOLLISIONS());
        Assertions.assertEquals(2, htoalp.size());
    }

    @Test
    void insertWithHashFunctionDivisionWhenThereIsEqualElementTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));

        //Act
        htoalp.insert(new CustomStorableTest(1L, "Lucas"));

        //Asserts
        CustomStorableTest searched = htoalp.search(new CustomStorableTest(1L));
        Assertions.assertNotNull(searched);
        Assertions.assertEquals("Lucas", searched.name);
        Assertions.assertEquals(0, htoalp.getCOLLISIONS());
        Assertions.assertEquals(1, htoalp.size());
    }

    @Test
    void insertWithHashFunctionDivisionWhenIsFulAndThrowHashTableOverFlowExceptionTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(1, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, false);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        CustomStorableTest newElement = new CustomStorableTest(2L, "Lucas");
        //Act
        HastTableOverflowException exception = Assertions.assertThrows(HastTableOverflowException.class,
                () -> htoalp.insert(newElement));
        //Asserts
        Assertions.assertEquals("HashTable OverFlow!", exception.getMessage());
        Assertions.assertEquals(HastTableOverflowException.class, exception.getClass());
        Assertions.assertTrue(htoalp.isFull());
        Assertions.assertEquals(1, htoalp.capacity());
    }

    @Test
    void insertWithHashFunctionDivisionWhenNotFountSlotAvailableAndThrowProbingFailedExceptionTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(28, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, false);
        LongStream.rangeClosed(0, 27).forEach(i -> htoalp.insert(new CustomStorableTest(i, "Hi, " + i + "!")));
        htoalp.showDisplay();

        CustomStorableTest deleteElement = new CustomStorableTest(15L);
        htoalp.delete(deleteElement);
        htoalp.showDisplay();

        CustomStorableTest newElement = new CustomStorableTest(1650L, "Lucas");

        //Act
        ProbingFailedException exception = Assertions.assertThrows(ProbingFailedException.class,
                () -> htoalp.insert(newElement));
        htoalp.showDisplay();

        //Asserts
        Assertions.assertEquals("Failed to insert element: no available slot after quadratic probing.", exception.getMessage());
        Assertions.assertEquals(ProbingFailedException.class, exception.getClass());
        Assertions.assertFalse(htoalp.isFull());
        Assertions.assertEquals(28, htoalp.capacity());
    }

    @Test
    void insertWithHashFunctionDivisionWhenThereIsDeleteAndInsertTheEqualElementInSameSlotTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(3, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        htoalp.insert(new CustomStorableTest(2L, "Lucas"));
        htoalp.showDisplay();
        CustomStorableTest elementDeleted = new CustomStorableTest(1L);
        htoalp.delete(elementDeleted);
        htoalp.showDisplay();

        //Act
        htoalp.insert(new CustomStorableTest(1L, "Franklin"));
        htoalp.showDisplay();

        //Asserts
        CustomStorableTest searched = htoalp.search(elementDeleted);
        Assertions.assertNotNull(searched);
        Assertions.assertEquals("Franklin", searched.name);
        Assertions.assertEquals(2, htoalp.size());
        Assertions.assertEquals(1, htoalp.indexOf(elementDeleted));
        Assertions.assertEquals(0, htoalp.getCOLLISIONS());
    }

    @Test
    void insertWithHashFunctionDivisionWhenThereIsDeleteAndInsertTheEqualElementInTheSameSlotWithCollisionInTheSameSlotTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(3, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        htoalp.insert(new CustomStorableTest(2L, "Lucas"));
        htoalp.showDisplay();
        CustomStorableTest elementDeleted = new CustomStorableTest(1L);
        htoalp.delete(elementDeleted);
        htoalp.showDisplay();
        htoalp.insert(new CustomStorableTest(1L, "Franklin"));
        htoalp.showDisplay();

        //Act
        htoalp.insert(new CustomStorableTest(11L, "Bruna"));
        htoalp.showDisplay();

        //Asserts
        CustomStorableTest searched = htoalp.search(elementDeleted);
        Assertions.assertNotNull(searched);
        Assertions.assertEquals("Franklin", searched.name);
        Assertions.assertEquals(3, htoalp.size());
        Assertions.assertEquals(1, htoalp.indexOf(elementDeleted));
        Assertions.assertEquals(2, htoalp.getCOLLISIONS());
    }

    @Test
    void reHashWhenInsertNotFoundSlotAvailableAndIncreaseSizeTableTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(28, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        LongStream.rangeClosed(0, 27).forEach(i -> htoalp.insert(new CustomStorableTest(i, "Hi, " + i + "!")));

        CustomStorableTest newElement = new CustomStorableTest(129L, "Lucas");
        int oldSize = htoalp.capacity();
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
        int oldSize = htoalp.capacity();
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
        int initialSize = htoalp.capacity();
        LongStream.rangeClosed(0, 50).forEach(i -> htoalp.insert(new CustomStorableTest(i * 2, "Hi, " + i + "!")));
        LongStream.rangeClosed(51, 100).forEach(i -> htoalp.insert(new CustomStorableTest(i * 3, "Hi, " + (i * 3) + "!")));
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
        Assertions.assertNotEquals(initialSize, htoalp.capacity());
        Assertions.assertEquals(128, htoalp.capacity());
        Assertions.assertEquals(102, htoalp.size());
    }

    @Test
    void searchWithHashFunctionDivisionWhenFoundElementTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(1, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        CustomStorableTest findElement = new CustomStorableTest(1L);

        //Act
        CustomStorableTest search = htoalp.search(findElement);

        //Asserts
        Assertions.assertNotNull(search);
        Assertions.assertEquals(findElement.hashCode(), search.hashCode());
        Assertions.assertEquals("Edgar", search.name);
    }

    @Test
    void searchWithHashFunctionDivisionWhenNotFoundElementAndHashTableIsNotFullTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        htoalp.insert(new CustomStorableTest(51L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(61L, "Eduar"));
        htoalp.insert(new CustomStorableTest(71L, "Murilo"));
        htoalp.insert(new CustomStorableTest(81L, "Carlos"));
        htoalp.insert(new CustomStorableTest(91L, "Santana"));
        htoalp.insert(new CustomStorableTest(10L, "Marco"));
        CustomStorableTest findElement = new CustomStorableTest(100L);

        //Act
        CustomStorableTest search = htoalp.search(findElement);

        //Asserts
        Assertions.assertNull(search);
    }

    @Test
    void searchWithHashFunctionDivisionWhenNotFoundElementAndHashTableIsFullTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(0L, "Edgar"));
        htoalp.insert(new CustomStorableTest(1L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(2L, "Eduar"));
        htoalp.insert(new CustomStorableTest(3L, "Murilo"));
        htoalp.insert(new CustomStorableTest(4L, "Santana"));
        htoalp.insert(new CustomStorableTest(5L, "Marco"));
        htoalp.insert(new CustomStorableTest(6L, "Salah"));
        htoalp.insert(new CustomStorableTest(7L, "Hermes"));
        htoalp.insert(new CustomStorableTest(8L, "Renato"));
        htoalp.insert(new CustomStorableTest(9L, "Carlos"));
        CustomStorableTest findElement = new CustomStorableTest(10L);

        //Act
        CustomStorableTest search = htoalp.search(findElement);

        //Asserts
        Assertions.assertNull(search);
    }

    @Test
    void searchWithHashFunctionDivisionWhenFoundElementAndHashTableIsNotFullTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(4, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(11L, "Mendes"));
        htoalp.insert(new CustomStorableTest(22L, "Lucia"));
        htoalp.insert(new CustomStorableTest(33L, "Hermes"));

        //Act
        CustomStorableTest search = htoalp.search(new CustomStorableTest(33L));

        //Asserts
        Assertions.assertNotNull(search);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenNotFoundElementTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(4, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(21L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(31L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(41L, "JhowJhow"));

        //Act
        int index = htoalp.indexOf(new CustomStorableTest(61L));

        //Asserts
        Assertions.assertEquals(-1, index);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenHashFunctionIndexIsNullInFirstSlotTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(21L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(31L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(41L, "JhowJhow"));
        htoalp.showDisplay();

        //Act
        int index = htoalp.indexOf(new CustomStorableTest(61L));

        //Asserts
        Assertions.assertEquals(-1, index);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenFoundElementTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(4, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(1L, "JhowCabote"));
        htoalp.insert(new CustomStorableTest(21L, "JhowCelestino"));
        htoalp.insert(new CustomStorableTest(31L, "JhowKauak"));
        htoalp.insert(new CustomStorableTest(41L, "JhowKubaiaxe"));

        //Act
        int index = htoalp.indexOf(new CustomStorableTest(41L));

        //Asserts
        Assertions.assertEquals(6, index);
    }

    @Test
    void deleteWithHashFunctionDivisionWhenHashTableIsEmptyTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> htoalp.delete(new CustomStorableTest(1L)));
    }

    @Test
    void deleteWithHashFunctionDivisionWhenHashTableIsNotEmptyAndNotFoundElementToDeleteTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(8L, "Marco"));
        htoalp.insert(new CustomStorableTest(11L, "Charles"));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> htoalp.delete(new CustomStorableTest(12L)));
    }

    @Test
    void deleteWithHashFunctionDivisionWhenHashTableIsNotEmptyAndFoundElementToDeleteTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(8L, "Marco"));
        htoalp.insert(new CustomStorableTest(11L, "Charles"));

        //Act
        htoalp.delete(new CustomStorableTest(11L));

        //Asserts
        Assertions.assertFalse(htoalp.isEmpty());
    }

    @Test
    void deleteWithHashFunctionDivisionWhenHashTableIsFullAndFoundElementToDeleteTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(3, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(8L, "Marco"));
        htoalp.insert(new CustomStorableTest(11L, "Charles"));
        htoalp.insert(new CustomStorableTest(16L, "Anthony"));

        //Act
        htoalp.delete(new CustomStorableTest(16L));

        //Asserts
        Assertions.assertFalse(htoalp.isFull());
    }

    @Test
    void deleteWithHashFunctionDivisionWhenElementIsDeletedAndAnotherElementIsInsertedInSameSlotTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        //Slot[8]
        htoalp.insert(new CustomStorableTest(8L, "Marco"));
        htoalp.showDisplay();
        htoalp.delete(new CustomStorableTest(8L));
        htoalp.showDisplay();

        //Act
        htoalp.insert(new CustomStorableTest(8L, "Fabio"));
        htoalp.showDisplay();

        //Asserts
        CustomStorableTest searched = htoalp.search(new CustomStorableTest(8L));
        Assertions.assertNotNull(searched);
        Assertions.assertEquals("Fabio", searched.name);
        Assertions.assertEquals(8, htoalp.indexOf(searched));

    }

    @Test
    void deleteWithHashFunctionDivisionWhenThereIsOnlyOneElementTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(8L, "Marco"));
        htoalp.showDisplay();

        //Act
        htoalp.delete(new CustomStorableTest(8L));
        htoalp.showDisplay();

        //Asserts
        Assertions.assertTrue(htoalp.isEmpty());
        Assertions.assertEquals(0, htoalp.size());
    }

    @Test
    void deleteWithHashFunctionDivisionWhenDeleteManyElementsTest() {
        //Arrange
        HashTableOpenAddressQuadraticProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressQuadraticProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION, 2, 3, true);
        htoalp.insert(new CustomStorableTest(-1L, "Marco"));
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        htoalp.insert(new CustomStorableTest(4L, "Carlos"));
        htoalp.insert(new CustomStorableTest(6L, "Santana"));
        htoalp.insert(new CustomStorableTest(8L, "Marco"));
        htoalp.insert(new CustomStorableTest(11L, "Charles"));
        htoalp.showDisplay();

        //Act
        htoalp.delete(new CustomStorableTest(-1L));
        htoalp.delete(new CustomStorableTest(4L));
        htoalp.delete(new CustomStorableTest(6L));
        htoalp.delete(new CustomStorableTest(8L));
        htoalp.showDisplay();

        //Asserts
        Assertions.assertEquals(2, htoalp.size());

    }
}