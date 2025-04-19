package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    public void isEmptyTrueWithoutElementsTest() {
        //Act & Asserts
        Assertions.assertTrue(new DoublyLinkedList<Integer>().isEmpty());
    }

    @Test
    public void isEmptyFalseWhenPrependElementsTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Element<Integer> element = new Element<>(1);
        dll.prepend(element);

        //Act & Asserts
        Assertions.assertFalse(dll.isEmpty());
    }

    @Test
    public void prependSuccessWhenAddingElementsTest() {
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
    public void insertSuccessWhenAddingElementsTest() {
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
    public void insertTest() {
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
    public void searchElementFoundTest() {
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
    public void searchElementNotFoundWhenLinkedListIsEmptyTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        //Act
        Element<Integer> searched = dll.search(new Element<>(3));

        //Asserts
        Assertions.assertTrue(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    public void searchElementNotFoundWhenLinkedListIsNotEmptyTest() {
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
    public void searchElementFoundWhenIsFirstHeadTest() {
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
    public void searchElementFoundWhenIsFirstTailTest() {
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
    public void deleteElementWhenListIsEmptyTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(new Element<>(-1)));
    }

    @Test
    public void deleteElementWhenListIsEmptyAndSearchElementIsNullTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        //Act & Asserts
        Assertions.assertThrows(NullPointerException.class, () -> dll.delete(null));
    }

    @Test
    public void deleteElementWhenListIsEmptyAndESearchElementIsNotFoundTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.prepend(new Element<>(85));
        dll.prepend(new Element<>(62));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(new Element<>(-1)));
    }

    @Test
    public void deleteElementFoundTest() {
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
    public void deleteElementFoundBySearchElementTest() {
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
    public void deleteWhenElementIsHeadTest() {
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
    public void deleteWhenElementIsTailTest() {
        //Arrange
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Element<Integer> elementIntegerTail = new Element<>(101);
        dll.prepend(elementIntegerTail);
        dll.prepend(new Element<>(80));

        //Act
        dll.delete(elementIntegerTail);

        //Asserts
        Element<Integer> searchOldTail = dll.search(elementIntegerTail);
        Element<Integer> searchNewTail = dll.search(new Element<>(80));
        Assertions.assertNull(searchOldTail);
        Assertions.assertEquals(1, dll.getCountElements());
    }
}