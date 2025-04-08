package br.com.fabex.dataofstructs.linked.integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListIntegerTest {


    @Test
    public void isEmptyTrueWithoutElementsTest() {
        //Act & Asserts
        Assertions.assertTrue(new DoubleLinkedListInteger().isEmpty());
    }

    @Test
    public void isEmptyFalseWhenPrependElementsTest() {
        //Arrange
        DoubleLinkedListInteger doubleLinkedListInteger = new DoubleLinkedListInteger();
        ElementInteger elementInteger1 = new ElementInteger(1);
        doubleLinkedListInteger.prepend(elementInteger1);

        //Act & Asserts
        Assertions.assertFalse(doubleLinkedListInteger.isEmpty());
    }

    @Test
    public void prependSuccessWhenAddingElementsTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        dll.prepend(new ElementInteger(1));
        dll.prepend(new ElementInteger(2));
        ElementInteger elementIntegerHead = new ElementInteger(3);

        //Act
        dll.prepend(elementIntegerHead);

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(3, dll.getCountElements());
    }

    @Test
    public void insertFromElementSuccessWhenAddingElementsTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        dll.prepend(new ElementInteger(1));
        ElementInteger elementInteger2 = new ElementInteger(2);
        dll.prepend(elementInteger2);
        dll.prepend(new ElementInteger(3));
        ElementInteger elementIntegerHead = new ElementInteger(-1);
        dll.prepend(elementIntegerHead);

        ElementInteger newElementInteger = new ElementInteger(55);

        //Act
        dll.insertFromElement(elementInteger2, newElementInteger);

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(elementInteger2.next, newElementInteger);
        Assertions.assertEquals(5, dll.getCountElements());
    }

    @Test
    public void insertFromElementSuccessWhenThereIsOneElementTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();
        ElementInteger elementIntegerHead = new ElementInteger(-1);
        dll.prepend(elementIntegerHead);
        ElementInteger newElementInteger = new ElementInteger(10);

        //Act
        dll.insertFromElement(elementIntegerHead, newElementInteger);

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementIntegerHead, dll.getHead());
        Assertions.assertEquals(dll.getHead().next, newElementInteger);
        Assertions.assertEquals(2, dll.getCountElements());
    }

    @Test
    public void searchElementFoundTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        dll.prepend(new ElementInteger(58));
        ElementInteger searchedElement = new ElementInteger(79);
        dll.prepend(searchedElement);
        dll.prepend(new ElementInteger(66));
        dll.prepend(new ElementInteger(11));
        ElementInteger elementHead = new ElementInteger(-1);
        dll.prepend(elementHead);

        //Act
        ElementInteger searched = dll.search(new ElementInteger(79));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementHead, dll.getHead());
        Assertions.assertEquals(searchedElement, searched);
    }

    @Test
    public void searchElementNotFoundWhenLinkedListIsEmptyTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        //Act
        ElementInteger searched = dll.search(new ElementInteger(3));

        //Asserts
        Assertions.assertTrue(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    public void searchElementNotFoundWhenLinkedListIsNotEmptyTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        dll.prepend(new ElementInteger(23));
        dll.prepend(new ElementInteger(33));
        dll.prepend(new ElementInteger(43));
        dll.prepend(new ElementInteger(53));
        dll.prepend(new ElementInteger(90));

        //Act
        ElementInteger searched = dll.search(new ElementInteger(1));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    public void searchElementFoundWhenIsFirstHeadTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        dll.prepend(new ElementInteger(5));
        dll.prepend(new ElementInteger(7));
        dll.prepend(new ElementInteger(6));
        dll.prepend(new ElementInteger(9));
        ElementInteger elementHead = new ElementInteger(1);
        dll.prepend(elementHead);

        //Act
        ElementInteger searched = dll.search(new ElementInteger(1));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(elementHead, dll.getHead());
        Assertions.assertEquals(elementHead, searched);
    }

    @Test
    public void searchElementFoundWhenIsFirstTailTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        ElementInteger tail = new ElementInteger(99);
        dll.prepend(tail);
        dll.prepend(new ElementInteger(85));
        dll.prepend(new ElementInteger(62));
        dll.prepend(new ElementInteger(12));
        dll.prepend(new ElementInteger(1));

        //Act
        ElementInteger searched = dll.search(new ElementInteger(99));

        //Asserts
        Assertions.assertEquals(tail, searched);
    }

    @Test
    public void deleteElementWhenListIsEmptyTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(new ElementInteger(-1)));
    }

    @Test
    public void deleteElementWhenListIsEmptyAndSearchElementIsNullTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();

        //Act & Asserts
        Assertions.assertThrows(NullPointerException.class, () -> dll.delete(null));
    }

    @Test
    public void deleteElementWhenListIsEmptyAndESearchElementIsNotFoundTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();
        dll.prepend(new ElementInteger(85));
        dll.prepend(new ElementInteger(62));

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(new ElementInteger(-1)));
    }

    @Test
    public void deleteElementFoundTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();
        dll.prepend(new ElementInteger(99));
        ElementInteger deleting = new ElementInteger(85);
        dll.prepend(deleting);
        dll.prepend(new ElementInteger(62));

        //Act
        dll.delete(deleting);

        //Asserts
        ElementInteger searched = dll.search(deleting);
        Assertions.assertNull(searched);
        Assertions.assertEquals(2, dll.getCountElements());
    }

    @Test
    public void deleteElementFoundBySearchElementTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();
        dll.prepend(new ElementInteger(99));
        dll.prepend(new ElementInteger(85));
        dll.prepend(new ElementInteger(62));
        ElementInteger search = dll.search(new ElementInteger(85));

        //Act
        dll.delete(search);

        //Asserts
        ElementInteger searched = dll.search(search);
        Assertions.assertNull(searched);
        Assertions.assertEquals(2, dll.getCountElements());
    }

    @Test
    public void deleteWhenElementIsHeadTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();
        dll.prepend(new ElementInteger(100));
        ElementInteger startElementHead = new ElementInteger(101);
        dll.prepend(startElementHead);

        //Act
        dll.delete(startElementHead);

        //Asserts
        ElementInteger searchOldHead = dll.search(startElementHead);
        ElementInteger searchNewHead = dll.search(new ElementInteger(100));
        Assertions.assertNull(searchOldHead);
        Assertions.assertNotEquals(startElementHead, dll.getHead());
        Assertions.assertEquals(searchNewHead, dll.getHead());
        Assertions.assertEquals(1, dll.getCountElements());
    }

    @Test
    public void deleteWhenElementIsTailTest() {
        //Arrange
        DoubleLinkedListInteger dll = new DoubleLinkedListInteger();
        ElementInteger elementTail = new ElementInteger(101);
        dll.prepend(elementTail);
        dll.prepend(new ElementInteger(80));

        //Act
        dll.delete(elementTail);

        //Asserts
        ElementInteger searchOldTail = dll.search(elementTail);
        ElementInteger searchNewTail = dll.search(new ElementInteger(80));
        Assertions.assertNull(searchOldTail);
        Assertions.assertEquals(1, dll.getCountElements());
    }
}