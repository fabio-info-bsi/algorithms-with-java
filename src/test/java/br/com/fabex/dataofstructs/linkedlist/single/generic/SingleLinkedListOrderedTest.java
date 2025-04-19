package br.com.fabex.dataofstructs.linkedlist.single.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class SingleLinkedListOrderedTest {

    protected final Random RANDOM = new Random();

    @Test
    void prependFirstElementWhenLinkedListIsEmptyTest() {
        //Arrange
        SingleLinkedListOrdered<Integer> dll = new SingleLinkedListOrdered<>();
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
        SingleLinkedListOrdered<Integer> dll = new SingleLinkedListOrdered<>();
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
        SingleLinkedListOrdered<Integer> dll = new SingleLinkedListOrdered<>();
        List<Integer> sequencedElements = RANDOM.ints(25, -1000, 1000)
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
        SingleLinkedListOrdered<Integer> dll = new SingleLinkedListOrdered<>();
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
}