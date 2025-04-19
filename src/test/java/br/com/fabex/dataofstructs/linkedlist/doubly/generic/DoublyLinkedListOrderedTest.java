package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;


class DoublyLinkedListOrderedTest {

    protected final Random RANDOM = new Random();

    @Test
    void prependFirstElementWhenLinkedListIsEmptyTest() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        Element<Integer> newElement = new Element<>(44);

        //Act
        dll.prepend(newElement);

        // Assert
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(1, dll.getCountElements());
        Assertions.assertEquals(newElement, dll.getHead());
    }

    @Test
    void prependElementOrderedWhenLinkedListDoesHaveOneElementTest() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        dll.prepend(new Element<>(5));
        Element<Integer> newElement = new Element<>(4);

        //Act
        dll.prepend(newElement);

        // Assert
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(2, dll.getCountElements());
        Assertions.assertEquals(newElement, dll.getHead());
    }

    @Test
    void prependElementOrderedWhenLinkedListDoesHaveMoreOneElementTest() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        List<Integer> sequencedElements = RANDOM.ints(15, -100, 100)
                .boxed().toList();
        List<Integer> orderedElements = sequencedElements.stream().sorted().toList();
        sequencedElements.forEach(i -> dll.prepend(new Element<>(i)));

        // Assert & Act
        List<Integer> sortedLinkedList = dll.toList().stream().map(Element::getKey).sorted().toList();
        Assertions.assertIterableEquals(orderedElements, sortedLinkedList);
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(sequencedElements.size(), dll.getCountElements());
        Assertions.assertEquals(dll.getHead().getKey(), orderedElements.getFirst());
    }

    @Test
    void prependElementOrderedWhenAllElementIsSameTest() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        List<Integer> sequencedElements = List.of(-1, -1, -1, -1, -1, -1);
        List<Integer> orderedElements = sequencedElements.stream().sorted().toList();
        sequencedElements.forEach(i -> dll.prepend(new Element<>(i)));

        // Assert & Act
        List<Integer> sortedLinkedList = dll.toList().stream().map(Element::getKey).sorted().toList();
        Assertions.assertIterableEquals(orderedElements, sortedLinkedList);
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertEquals(sequencedElements.size(), dll.getCountElements());
        Assertions.assertEquals(dll.getHead().getKey(), orderedElements.getFirst());
    }

    @Test
    void insertThrowUnsupportedOperationExceptionTest() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        dll.prepend(new Element<>(5));

        // Assert & Act
        Assertions.assertThrows(UnsupportedOperationException.class, () -> dll.insert(dll.getHead(), new Element<>(10)));
    }

    @Test
    void toListWhenLinkedListIsEmpty() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();

        // Act
        List<Element<Integer>> list = dll.toList();

        // Assert
        Assertions.assertNotNull(list);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void toListWhenLinkedListIsNotEmpty() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        dll.prepend(new Element<>(15));
        dll.prepend(new Element<>(33));

        // Act
        List<Element<Integer>> list = dll.toList();

        // Assert
        Assertions.assertNotNull(list);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void toSetWhenLinkedListIsEmpty() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();

        // Act
        Set<Element<Integer>> set = dll.toSet();

        // Assert
        Assertions.assertNotNull(set);
        Assertions.assertEquals(0, set.size());
    }

    @Test
    void toSetWhenLinkedListIsNotEmpty() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        dll.prepend(new Element<>(15));
        dll.prepend(new Element<>(33));

        // Act
        Set<Element<Integer>> set = dll.toSet();

        // Assert
        Assertions.assertNotNull(set);
        Assertions.assertEquals(2, set.size());
    }

    @Test
    void toSetWhenLinkedListHasRepeatedElements() {
        //Arrange
        DoublyLinkedListOrdered<Integer> dll = new DoublyLinkedListOrdered<>();
        dll.prepend(new Element<>(3));
        dll.prepend(new Element<>(3));
        dll.prepend(new Element<>(3));

        // Act
        Set<Element<Integer>> set = dll.toSet();

        // Assert
        Assertions.assertNotNull(set);
        Assertions.assertEquals(1, set.size());
    }


}