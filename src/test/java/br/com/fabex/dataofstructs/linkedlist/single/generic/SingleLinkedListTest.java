package br.com.fabex.dataofstructs.linkedlist.single.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleLinkedListTest {

    @Test
    void prependFirstElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();

        // Act
        Element<Integer> element = new Element<>(3);
        sll.prepend(element);

        // Asserts
        Assertions.assertEquals(sll.getHead(), element);
        Assertions.assertEquals(1, sll.getCountElements());
    }

    @Test
    void prependManyElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();

        // Act
        sll.prepend(new Element<>(3));
        sll.prepend(new Element<>(2));
        Element<Integer> element = new Element<>(1);
        sll.prepend(element);

        // Asserts
        Assertions.assertEquals(sll.getHead(), element);
        Assertions.assertEquals(3, sll.getCountElements());
    }

    @Test
    void deleteWhenThereIsOneElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.prepend(new Element<>(-1));

        // Act
        sll.delete(new Element<>(-1));

        // Asserts
        Assertions.assertTrue(sll.isEmpty());
        Assertions.assertEquals(0, sll.getCountElements());
    }

    @Test
    void deleteLastElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.prepend(new Element<>(3));
        sll.prepend(new Element<>(2));
        sll.prepend(new Element<>(1));

        // Act
        sll.delete(new Element<>(3));

        // Asserts
        Assertions.assertEquals(2, sll.getCountElements());
    }

    @Test
    void deleteFirstElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.prepend(new Element<>(15));
        sll.prepend(new Element<>(21));
        Element<Integer> element = new Element<>(13);
        sll.prepend(element);
        sll.prepend(new Element<>(33));

        // Act
        sll.delete(new Element<>(33));

        // Asserts
        Assertions.assertEquals(sll.getHead(), element);
        Assertions.assertEquals(3, sll.getCountElements());
    }

    @Test
    void deleteSecondElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.prepend(new Element<>(15));
        Element<Integer> element = new Element<>(21);
        sll.prepend(element);

        // Act
        sll.delete(new Element<>(15));

        // Asserts
        Assertions.assertEquals(1, sll.getCountElements());
        Assertions.assertEquals(sll.getHead(), element);
    }

    @Test
    void deleteMiddleElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.prepend(new Element<>(22));
        sll.prepend(new Element<>(33));
        Element<Integer> element44 = new Element<>(44);
        sll.prepend(element44);
        sll.prepend(new Element<>(55));
        Element<Integer> element66 = new Element<>(66);
        sll.prepend(element66);
        sll.prepend(new Element<>(77));
        sll.prepend(new Element<>(88));

        // Act
        sll.delete(new Element<>(55));

        // Asserts
        Assertions.assertEquals(element44, element66.getNext());
        Assertions.assertEquals(6, sll.getCountElements());
    }

    @Test
    void deleteElementWhenLinkedListIsEmptyTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();

        // Act
        sll.delete(new Element<>(-1));

        // Asserts
        Assertions.assertTrue(sll.isEmpty());
        Assertions.assertEquals(0, sll.getCountElements());
    }

    @Test
    void deleteElementNotFoundTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.prepend(new Element<>(789));

        // Act
        sll.delete(new Element<>(-1));

        // Asserts
        Assertions.assertEquals(1, sll.getCountElements());
    }

    @Test
    void insertElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        Element<Integer> element = new Element<>(78);
        sll.prepend(element);
        // Act
        sll.insert(element, new Element<>(10));

        // Asserts
        Assertions.assertEquals(2, sll.getCountElements());
    }

    @Test
    void insertAfterElementTest() {
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        Element<Integer> element719 = new Element<>(719);
        sll.prepend(element719);
        sll.prepend(new Element<>(729));
        sll.prepend(new Element<>(739));
        // Act
        Element<Integer> element749 = new Element<>(749);
        sll.insert(element719, element749);

        // Asserts
        Assertions.assertEquals(element719.getNext(), element749);
        Assertions.assertEquals(4, sll.getCountElements());
    }


    @Test
    public void searchElementFoundTest() {
        //Arrange
        SingleLinkedList<Integer> dll = new SingleLinkedList<>();

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
        SingleLinkedList<Integer> dll = new SingleLinkedList<>();

        //Act
        Element<Integer> searched = dll.search(new Element<>(3));

        //Asserts
        Assertions.assertTrue(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    public void searchElementNotFoundWhenLinkedListIsNotEmptyTest() {
        //Arrange
        SingleLinkedList<Integer> dll = new SingleLinkedList<>();

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
        SingleLinkedList<Integer> dll = new SingleLinkedList<>();

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
        SingleLinkedList<Integer> dll = new SingleLinkedList<>();

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

}