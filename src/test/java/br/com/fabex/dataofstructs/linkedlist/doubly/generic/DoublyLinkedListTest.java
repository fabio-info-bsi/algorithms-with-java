package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    void isEmptyTrueWithoutElementsTest() {
        //Act & Asserts
        Assertions.assertTrue(new DoublyLinkedList<Integer>().isEmpty());
    }

    @Test
    void isEmptyFalseWhenPrependElementsTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Element<Integer> element = new Element<>(1);
        dll.prepend(element);

        //Act & Asserts
        Assertions.assertFalse(dll.isEmpty());
    }

    @Test
    void prependSuccessWhenAddingElementsTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.prepend(new Element<>(1));
        dll.prepend(new Element<>(2));
        Element<Integer> elementIntegerHead = new Element<>(3);

        //Act
        dll.prepend(elementIntegerHead);

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(3, dll.getCountElements());
    }

    @Test
    void insertSuccessWhenAddingElementsTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.prepend(new Element<>(1));
        Element<Integer> elementInteger2 = new Element<>(2);
        dll.prepend(elementInteger2);
        dll.prepend(new Element<>(3));
        Element<Integer> elementIntegerHead = new Element<>(-1);
        dll.prepend(elementIntegerHead);

        Element<Integer> newElement = new Element<>(55);

        //Act
        dll.insert(elementInteger2, newElement);

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(elementInteger2.next, newElement);
        Assertions.assertEquals(5, dll.getCountElements());
    }

    @Test
    void insertTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Element<Integer> elementIntegerHead = new Element<>(-1);
        dll.prepend(elementIntegerHead);
        Element<Integer> newElement = new Element<>(10);

        //Act
        dll.insert(elementIntegerHead, newElement);

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(dll.getHead().next, newElement);
        Assertions.assertEquals(2, dll.getCountElements());
    }

    @Test
    void searchElementFoundTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.prepend(new Element<>(58));
        Element<Integer> searchedElement = new Element<>(79);
        dll.prepend(searchedElement);
        dll.prepend(new Element<>(66));
        dll.prepend(new Element<>(11));
        Element<Integer> elementIntegerHead = new Element<>(-1);
        dll.prepend(elementIntegerHead);

        //Act
        Element<Integer> searched = dll.search(new Element<>(79));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(searchedElement, searched);
    }

    @Test
    void searchElementNotFoundWhenLinkedListIsEmptyTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        //Act
        Element<Integer> searched = dll.search(new Element<>(3));

        //Asserts
        Assertions.assertTrue(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    void searchElementNotFoundWhenLinkedListIsNotEmptyTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.prepend(new Element<>(23));
        dll.prepend(new Element<>(33));
        dll.prepend(new Element<>(43));
        dll.prepend(new Element<>(53));
        dll.prepend(new Element<>(90));

        //Act
        Element<Integer> searched = dll.search(new Element<>(1));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    void searchElementFoundWhenIsFirstHeadTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.prepend(new Element<>(5));
        dll.prepend(new Element<>(7));
        dll.prepend(new Element<>(6));
        dll.prepend(new Element<>(9));
        Element<Integer> elementIntegerHead = new Element<>(1);
        dll.prepend(elementIntegerHead);

        //Act
        Element<Integer> searched = dll.search(new Element<>(1));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(elementIntegerHead, searched);
    }

    @Test
    void searchElementFoundWhenIsFirstTailTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        Element<Integer> tail = new Element<>(99);
        dll.prepend(tail);
        dll.prepend(new Element<>(85));
        dll.prepend(new Element<>(62));
        dll.prepend(new Element<>(12));
        dll.prepend(new Element<>(1));

        //Act
        Element<Integer> searched = dll.search(new Element<>(99));

        //Asserts
        Assertions.assertEquals(tail, searched);
    }

    @Test
    void deleteElementWhenListIsEmptyTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(new Element<>(-1)));
    }

    @Test
    void deleteElementWhenListIsEmptyAndSearchElementIsNullTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        //Act & Asserts
        Assertions.assertThrows(NullPointerException.class, () -> dll.delete(null));
    }

    @Test
    void deleteElementWhenListIsEmptyAndESearchElementIsNotFoundTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.prepend(new Element<>(85));
        dll.prepend(new Element<>(62));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(new Element<>(-1)));
    }

    @Test
    void deleteElementFoundTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.prepend(new Element<>(99));
        Element<Integer> deleting = new Element<>(85);
        dll.prepend(deleting);
        dll.prepend(new Element<>(62));

        //Act
        dll.delete(deleting);

        //Asserts
        Element<Integer> searched = dll.search(deleting);
        Assertions.assertNull(searched);
        Assertions.assertEquals(2, dll.getCountElements());
    }

    @Test
    void deleteElementFoundBySearchElementTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.prepend(new Element<>(99));
        dll.prepend(new Element<>(85));
        dll.prepend(new Element<>(62));
        Element<Integer> search = dll.search(new Element<>(85));

        //Act
        dll.delete(search);

        //Asserts
        Element<Integer> searched = dll.search(search);
        Assertions.assertNull(searched);
        Assertions.assertEquals(2, dll.getCountElements());
    }

    @Test
    void deleteWhenElementIsHeadTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.prepend(new Element<>(100));
        Element<Integer> startElementIntegerHead = new Element<>(101);
        dll.prepend(startElementIntegerHead);

        //Act
        dll.delete(startElementIntegerHead);

        //Asserts
        Element<Integer> searchOldHead = dll.search(startElementIntegerHead);
        Element<Integer> searchNewHead = dll.search(new Element<>(100));
        Assertions.assertNull(searchOldHead);
        Assertions.assertNotEquals(startElementIntegerHead, dll.getHead());
        Assertions.assertEquals(searchNewHead, dll.getHead());
        Assertions.assertEquals(1, dll.getCountElements());
    }

    @Test
    void deleteWhenElementIsTailTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Element<Integer> elementIntegerTail = new Element<>(101);
        dll.prepend(elementIntegerTail);
        dll.prepend(new Element<>(80));

        //Act
        dll.delete(elementIntegerTail);

        //Asserts
        Element<Integer> searchOldTail = dll.search(elementIntegerTail);
        Assertions.assertNull(searchOldTail);
        Assertions.assertEquals(1, dll.getCountElements());
    }

    @Test
    void updateWhenElementIsHeadTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Element<Integer> startElementIntegerHead = new Element<>(18);
        dll.prepend(startElementIntegerHead);
        Element<Integer> searchHead = new Element<>(18);
        Element<Integer> searched = dll.search(searchHead);

        //Act
        int newKey = 15;
        dll.update(searched, newKey);

        //Asserts
        Element<Integer> searchUpdatedHead = dll.search(new Element<>(newKey));
        Assertions.assertEquals(startElementIntegerHead, dll.getHead());
        Assertions.assertEquals(searchUpdatedHead, dll.getHead());
        Assertions.assertEquals(newKey, searchUpdatedHead.getKey());
        Assertions.assertEquals(newKey, dll.getHead().getKey());
        Assertions.assertEquals(1, dll.getCountElements());
    }

    @Test
    void updateWhenThereAreElementTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.prepend(new Element<>(87));
        dll.prepend(new Element<>(97));
        Element<Integer> elementIntegerInMiddle = new Element<>(77);
        dll.prepend(elementIntegerInMiddle);
        dll.prepend(new Element<>(17));
        dll.prepend(new Element<>(15));
        Element<Integer> searchTail = new Element<>(77);
        Element<Integer> searched = dll.search(searchTail);

        //Act
        int newKey = 91;
        dll.update(searched, newKey);

        //Asserts
        Element<Integer> searchUpdatedElementValue = dll.search(new Element<>(newKey));
        Assertions.assertEquals(elementIntegerInMiddle, searchUpdatedElementValue);
        Assertions.assertEquals(elementIntegerInMiddle.getKey(), searchUpdatedElementValue.getKey());
        Assertions.assertEquals(newKey, searchUpdatedElementValue.getKey());
        Assertions.assertEquals(5, dll.getCountElements());
    }
}