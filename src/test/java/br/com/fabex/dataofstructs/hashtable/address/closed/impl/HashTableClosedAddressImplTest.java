package br.com.fabex.dataofstructs.hashtable.address.closed.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class HashTableClosedAddressImplTest {

    static class CustomObjectTest {
        Long id;
        String name;

        public CustomObjectTest(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public CustomObjectTest(Long id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            CustomObjectTest customObjectTest = (CustomObjectTest) o;
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
        Assertions.assertEquals(10, new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10).capacity());
    }

    @Test
    void capacityWhenExistElementsTest() {
        //Arrange
        HashTableClosedAddressImpl<Object> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert(new CustomObjectTest(1L, "Carlos"));
        htca.insert(new CustomObjectTest(2L, "Edgar"));

        //Act & Asserts
        Assertions.assertEquals(10, htca.capacity());
    }

    @Test
    void insertWithHashFunctionDivisionWhenExistCollisionTest() {
        //Arrange
        HashTableClosedAddressImpl<String> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert("Marco");
        htca.insert("Santana");
        htca.insert("Junior");
        htca.insert("Silva");
        htca.insert("Carlos");
        htca.insert("Franklin");
        htca.insert("Edgar");

        htca.showDisplay();

        //Act & Asserts
        Assertions.assertEquals(7, htca.size());
        Assertions.assertEquals(1, htca.getCOLLISIONS());
    }

    @Test
    void insertWithHashFunctionDivisionWhenNotExistCollisionTest() {
        //Arrange
        HashTableClosedAddressImpl<String> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert("Marco");
        htca.insert("Fabio");

        //Act & Asserts
        Assertions.assertEquals(2, htca.size());
        Assertions.assertEquals(0, htca.getCOLLISIONS());
    }

    @Test
    void insertWithHashFunctionDivisionWhenExistElementTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert(new CustomObjectTest(1L, "Marco"));
        CustomObjectTest newElement = new CustomObjectTest(2L, "Fabio");
        htca.insert(newElement);
        CustomObjectTest updateElement = new CustomObjectTest(2L, "Fabex");

        //Act
        htca.insert(updateElement);

        //Asserts
        CustomObjectTest search = htca.search(new CustomObjectTest(2L));
        Assertions.assertNotNull(search);
        Assertions.assertEquals(search, updateElement);
        Assertions.assertEquals(search.name, updateElement.name);
        Assertions.assertNotEquals(newElement.name, updateElement.name);
        Assertions.assertNotEquals(newElement.name, search.name);
        Assertions.assertEquals(2, htca.size());
        Assertions.assertEquals(0, htca.getCOLLISIONS());
    }

    @Test
    void insertWithHashFunctionDivisionWhenNotExistElementsTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        CustomObjectTest newElement = new CustomObjectTest(1L, "Fabio");

        //Act
        htca.insert(newElement);

        //Asserts
        CustomObjectTest search = htca.search(new CustomObjectTest(1L));
        Assertions.assertNotNull(search);
        Assertions.assertEquals(newElement, search);
        Assertions.assertEquals("Fabio", search.name);
        Assertions.assertEquals(1, htca.size());
    }

    @Test
    void deleteWithHashFunctionDivisionWhenNotFoundElementsTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);

        //Act
        htca.delete(new CustomObjectTest(-1L));

        //Asserts
        Assertions.assertEquals(0, htca.size());
    }

    @Test
    void deleteWithHashFunctionDivisionWhenExistElementAndExistsOnlyOneElementInLinkedListTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert(new CustomObjectTest(1L, "Fabio"));
        htca.insert(new CustomObjectTest(2L, "Junior"));
        htca.insert(new CustomObjectTest(3L, "Marco"));

        //Act
        htca.delete(new CustomObjectTest(1L));

        //Asserts
        Assertions.assertEquals(2, htca.size());
    }

    @Test
    void deleteWithHashFunctionDivisionWhenFoundElementAndExistsMoreTheOneElementInLinkedListTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        //Same Slot -> LinkedList
        htca.insert(new CustomObjectTest(1L, "Fabio"));
        htca.insert(new CustomObjectTest(11L, "Edgar"));
        //Another Slots
        htca.insert(new CustomObjectTest(2L, "Junior"));
        htca.insert(new CustomObjectTest(3L, "Marco"));

        //Act
        htca.delete(new CustomObjectTest(11L));

        //Asserts
        CustomObjectTest search = htca.search(new CustomObjectTest(11L));
        Assertions.assertNull(search);
        Assertions.assertEquals(3, htca.size());
    }

    @Test
    void searchWithHashFunctionDivisionWhenFoundElementTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert(new CustomObjectTest(1L, "Fabio"));
        htca.insert(new CustomObjectTest(2L, "Junior"));
        htca.insert(new CustomObjectTest(3L, "Marco"));

        //Act
        CustomObjectTest search = htca.search(new CustomObjectTest(2L));

        //Asserts
        Assertions.assertNotNull(search);
        Assertions.assertEquals("Junior", search.name);
        Assertions.assertEquals(2L, search.id);
    }

    @Test
    void searchWithHashFunctionDivisionWhenNotFoundElementTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert(new CustomObjectTest(1L, "Fabio"));
        htca.insert(new CustomObjectTest(2L, "Junior"));
        htca.insert(new CustomObjectTest(3L, "Marco"));

        //Act
        CustomObjectTest search = htca.search(new CustomObjectTest(5L));

        //Asserts
        Assertions.assertNull(search);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenIndexIsNotNullAndFoundElementAndExistsOnlyOneElementInLinkedListTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert(new CustomObjectTest(1L, "Fabio"));

        //Act
        int index = htca.indexOf(new CustomObjectTest(1L));

        //Asserts
        Assertions.assertEquals(1, index);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenIndexIsNotNullAndFoundElementAndExistsMoreTheOneElementInLinkedList() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        //Same Slot -> LinkedList
        htca.insert(new CustomObjectTest(1L, "Fabio"));
        htca.insert(new CustomObjectTest(11L, "Edgar"));

        //Act
        int index = htca.indexOf(new CustomObjectTest(1L));

        //Asserts
        Assertions.assertEquals(1, index);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenIndexIsNotNullAndNotFoundElementInLinkedList() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        //Same Slot -> LinkedList
        htca.insert(new CustomObjectTest(1L, "Fabio"));
        htca.insert(new CustomObjectTest(11L, "Edgar"));

        //Act
        int index = htca.indexOf(new CustomObjectTest(21L));

        //Asserts
        Assertions.assertEquals(-1, index);
    }

    @Test
    void indexOfWithHashFunctionDivisionWhenNotExistsElementTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);

        //Act
        int index = htca.indexOf(new CustomObjectTest(1L));

        //Asserts
        Assertions.assertEquals(-1, index);
    }

    @Test
    void insertWithHashFunctionMultiplicationWhenExistCollisionTest() {
        //Arrange
        HashTableClosedAddressImpl<CustomObjectTest> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.MULTIPLICATION, 10);
        //Same Slot
        htca.insert(new CustomObjectTest(-95L, "Fabio"));
        htca.insert(new CustomObjectTest(-88L, "Edgar"));

        //Act & Asserts
        Assertions.assertEquals(2, htca.size());
        Assertions.assertEquals(1, htca.getCOLLISIONS());
    }
}