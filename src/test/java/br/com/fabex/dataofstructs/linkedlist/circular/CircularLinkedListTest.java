package br.com.fabex.dataofstructs.linkedlist.circular;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CircularLinkedListTest {

    @Test
    void isEmptyTrueWhenLinkedListDoestNotHaveElementsTest(){
        //Act & Asserts
        Assertions.assertTrue(new CircularLinkedList<>().isEmpty());
    }

    @Test
    void isEmptyFalseWhenLinkedListDoestHaveElementsTest(){
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();
        dll.prepend(new CircularElement<>(91));

        //Act & Asserts
        Assertions.assertFalse(dll.isEmpty());
    }

    @Test
    void prependElementTest(){
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();
        CircularElement<Integer> element = new CircularElement<>(90);

        //Act
        dll.prepend(element);
        CircularElement<Integer> searched = dll.search(element);

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(90, searched.key);
        Assertions.assertEquals(1, dll.getCountElements());
    }

    @Test
    void InsertElementWhenLinkedListIsNotEmptyTest(){
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();
        dll.prepend(new CircularElement<>(23));
        CircularElement<Integer> elementPrev = new CircularElement<>(88);
        dll.prepend(elementPrev);
        dll.prepend(new CircularElement<>(50));
        CircularElement<Integer> elementNext = new CircularElement<>(15);

        //Act
        dll.insert(elementPrev, elementNext);

        //Asserts
        CircularElement<Integer> searched = dll.search(elementNext);
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(15, searched.key);
        Assertions.assertEquals(elementPrev.next, elementNext);
        Assertions.assertEquals(elementNext.prev, elementPrev);
        Assertions.assertEquals(4, dll.getCountElements());
    }

    @Test
    void searchFoundElementTest() {
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();

        dll.prepend(new CircularElement<>(23));
        dll.prepend(new CircularElement<>(33));
        dll.prepend(new CircularElement<>(45));

        //Act
        CircularElement<Integer> searched = dll.search(new CircularElement<>(23));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertNotNull(searched);
        Assertions.assertEquals(23, searched.key);
        Assertions.assertEquals(3, dll.getCountElements());
    }

    @Test
    void searchNotFoundElementTest() {
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();

        dll.prepend(new CircularElement<>(11));
        dll.prepend(new CircularElement<>(12));
        dll.prepend(new CircularElement<>(13));

        //Act
        CircularElement<Integer> searched = dll.search(new CircularElement<>(23));

        //Asserts
        Assertions.assertFalse(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    void deleteElementTest() {
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();

        CircularElement<Integer> element = new CircularElement<>(43);
        dll.prepend(element);

        //Act
        dll.delete(element);

        //Asserts
        CircularElement<Integer> searched = dll.search(element);
        Assertions.assertTrue(dll.isEmpty());
        Assertions.assertNull(searched);
    }

    @Test
    void deleteElementWhenCircularLinkedListIsEmptyTest() {
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();
        CircularElement<Integer> element = new CircularElement<>(43);

        //Act & Asserts
        Assertions.assertThrows(NullPointerException.class, () -> dll.delete(element));
    }

    @Test
    void deleteElementWhenIsHeadTest() {
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();
        dll.prepend(new CircularElement<>(12));
        CircularElement<Integer> head = dll.getHead();

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(head));
        Assertions.assertTrue(dll.isEmpty());
    }

    @Test
    void deleteElementWhenIsSentinelAndLinkedListIsNotEmptyTest() {
        //Arrange
        CircularLinkedList<Integer> dll = new CircularLinkedList<>();
        dll.prepend(new CircularElement<>(12));
        dll.prepend(new CircularElement<>(26));
        CircularElement<Integer> sentinel = dll.getHead().prev;

        //Act & Asserts
        Assertions.assertDoesNotThrow(() -> dll.delete(sentinel));
    }
}