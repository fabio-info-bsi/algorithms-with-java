package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.address.open.AbstractHashTableOpenAddress;
import br.com.fabex.dataofstructs.hashtable.exception.HastTableOverFlowException;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class HashTableOpenAddressLinearProbingImplTest {

    static class CustomStorableTest extends AbstractHashTableOpenAddress.Deleted {
        Long id;
        String name;

        public CustomStorableTest(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public CustomStorableTest(Long id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            CustomStorableTest customObjectTest = (CustomStorableTest) o;
            return Objects.equals(id, customObjectTest.id);
        }

        @Override
        public String toString() {
            return "{ id=" + id + ", name='" + name + '}';
        }
    }

    @Test
    void capacityWhenNotExistElementsTest() {
        //Act & Asserts
        Assertions.assertEquals(10, new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION).capacity());
    }

    @Test
    void capacityWhenExistElementsTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htca = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
        htca.insert(new CustomStorableTest(1L, "Carlos"));
        htca.insert(new CustomStorableTest(2L, "Edgar"));

        //Act & Asserts
        Assertions.assertEquals(10, htca.capacity());
    }

    @Test
    void insertWithHashFunctionDivisionWhenIsFullTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
        htoalp.insert(new CustomStorableTest(1L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(21L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(31L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(41L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(51L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(61L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(71L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(81L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(91L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(10L, "JhowJhow"));

        //Act & Asserts
        Assertions.assertTrue(htoalp.isFull());
        Assertions.assertEquals(10, htoalp.size());
    }

    @Test
    void insertWithHashFunctionDivisionWhenExistCollisionTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
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
    void insertWithHashFunctionDivisionWhenIsFulAndThrowHashTableOverFlowExceptionTes() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(1, HashFunctionClosedAddressMethodEnum.DIVISION);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        CustomStorableTest newElement = new CustomStorableTest(2L, "Lucas");
        //Act
        HastTableOverFlowException exception = Assertions.assertThrows(HastTableOverFlowException.class,
                () -> htoalp.insert(newElement));
        //Asserts
        Assertions.assertEquals("HashTable OverFlow!", exception.getMessage());
        Assertions.assertEquals(HastTableOverFlowException.class, exception.getClass());
        Assertions.assertTrue(htoalp.isFull());
        Assertions.assertEquals(1, htoalp.size());
    }

    @Test
    void insertWithHashFunctionDivisionWhenThereIsDeleteAndInsertTheEqualElementInSameSlotTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(3, HashFunctionClosedAddressMethodEnum.DIVISION);
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
    void insertWithHashFunctionDivisionWhenThereIsDeleteAndInsertTheEqualElementInSameSlotWithCollisionInSameSlotTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(3, HashFunctionClosedAddressMethodEnum.DIVISION);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        htoalp.insert(new CustomStorableTest(2L, "Lucas"));
        htoalp.showDisplay();
        CustomStorableTest elementDeleted = new CustomStorableTest(1L);
        htoalp.delete(elementDeleted);
        htoalp.showDisplay();
        htoalp.insert(new CustomStorableTest(1L, "Franklin"));

        //Act
        htoalp.insert(new CustomStorableTest(11L, "Bruna"));
        htoalp.showDisplay();

        //Asserts
        CustomStorableTest searched = htoalp.search(elementDeleted);
        Assertions.assertNotNull(searched);
        Assertions.assertEquals("Franklin", searched.name);
        Assertions.assertEquals(3, htoalp.size());
        Assertions.assertEquals(1, htoalp.indexOf(elementDeleted));
        Assertions.assertEquals(1, htoalp.getCOLLISIONS());
    }

    @Test
    void deleteWithHashFunctionDivisionWhenHashTableIsEmptyTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> htoalp.delete(new CustomStorableTest(1L)));
    }

    @Test
    void deleteWithHashFunctionDivisionWhenHashTableIsNotEmptyAndNotFoundElementToDeleteTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
        htoalp.insert(new CustomStorableTest(8L, "Marco"));
        htoalp.insert(new CustomStorableTest(11L, "Charles"));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> htoalp.delete(new CustomStorableTest(12L)));
    }

    @Test
    void deleteWithHashFunctionDivisionWhenHashTableIsNotEmptyAndFoundElementToDeleteTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(3, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
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

    @Test
    void searchWithHashFunctionDivisionWhenFoundElementTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(1, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
        htoalp.insert(new CustomStorableTest(1L, "Edgar"));
        htoalp.insert(new CustomStorableTest(51L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(61L, "Eduar"));
        htoalp.insert(new CustomStorableTest(71L, "Murilo"));
        htoalp.insert(new CustomStorableTest(81L, "Carlos"));
        htoalp.insert(new CustomStorableTest(91L, "Santana"));
        htoalp.insert(new CustomStorableTest(10L, "Marco"));
        htoalp.insert(new CustomStorableTest(11L, "Salah"));
        htoalp.insert(new CustomStorableTest(12L, "Hermes"));
        htoalp.insert(new CustomStorableTest(13L, "Renato"));
        CustomStorableTest findElement = new CustomStorableTest(100L);

        //Act
        CustomStorableTest search = htoalp.search(findElement);

        //Asserts
        Assertions.assertNull(search);
    }

    @Test
    void searchWithHashFunctionDivisionWhenFoundElementAndHashTableIsNotFullTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(4, HashFunctionClosedAddressMethodEnum.DIVISION);
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
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(4, HashFunctionClosedAddressMethodEnum.DIVISION);
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
    void indexOfWithHashFunctionDivisionWhenHashFunctionIndexIsNullInFirstSlot() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(10, HashFunctionClosedAddressMethodEnum.DIVISION);
        htoalp.insert(new CustomStorableTest(1L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(21L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(31L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(41L, "JhowJhow"));
        htoalp.showDisplay();

        //Act
        //Slot[6] is null And hashIndex -> table[6]
        int index = htoalp.indexOf(new CustomStorableTest(61L));

        //Asserts
        Assertions.assertEquals(-1, index);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenFoundElementTest() {
        //Arrange
        HashTableOpenAddressLinearProbingImpl<CustomStorableTest> htoalp = new HashTableOpenAddressLinearProbingImpl<>(4, HashFunctionClosedAddressMethodEnum.DIVISION);
        htoalp.insert(new CustomStorableTest(1L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(21L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(31L, "JhowJhow"));
        htoalp.insert(new CustomStorableTest(41L, "JhowJhow"));

        //Act
        int index = htoalp.indexOf(new CustomStorableTest(41L));

        //Asserts
        Assertions.assertEquals(0, index);
    }
}