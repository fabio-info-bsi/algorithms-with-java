package br.com.fabex.dataofstructs.queues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class QueueTest {

    @Test
    public void isEmptyTest1() {
        Assertions.assertTrue(new Queue().isEmpty());
    }

    @Test
    public void enqueueTest1() {
        //Arrange
        Queue queue = new Queue();

        //Act
        queue.enqueue(115);

        //Asserts
        Assertions.assertFalse(queue.isEmpty());
    }


    @Test
    public void enqueueTest2() {
        //Arrange
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        //Act & Asserts
        Assertions.assertThrows(RuntimeException.class, () -> queue.enqueue(4));
    }

    @Test
    public void isFullTest1() {
        //Arrange
        Queue queue = new Queue(2);
        queue.enqueue(2);
        queue.enqueue(3);

        //Act & Asserts
        Assertions.assertTrue(queue.isFull());
    }

    @Test
    public void isFullTest2() {
        //Act & Asserts
        Assertions.assertFalse(new Queue(2).isFull());
    }

    @Test
    public void dequeueTest1() {
        //Arrange
        Queue queue = new Queue(3);
        queue.enqueue(7); //head
        queue.enqueue(8);
        queue.enqueue(9);

        //Act
        int dequeue = queue.dequeue();


        //Asserts
        Assertions.assertEquals(7, dequeue);
        Assertions.assertFalse(queue.isFull());
    }

    @Test
    public void dequeueTest2() {
        //Arrange
        Queue queue = new Queue(3);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9); //head
        queue.dequeue();
        queue.dequeue();

        //Act
        int dequeue = queue.dequeue();


        //Asserts
        Assertions.assertEquals(9, dequeue);
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void dequeueTest3() {
        //Act & Asserts
        Assertions.assertThrows(RuntimeException.class, () -> new Queue().dequeue());
    }

    @Test
    public void enqueueAndDequeueTest1() {
        //Arrange
        Queue queue = new Queue(2);
        queue.enqueue(21);
        queue.enqueue(35);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(57);//head
        queue.enqueue(91);


        //Act
        int dequeue = queue.dequeue();

        //Asserts
        Assertions.assertEquals(57, dequeue);
        Assertions.assertFalse(queue.isFull());
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    public void enqueueAndDequeueTest2() {
        //Arrange
        Queue queue = new Queue(2);
        queue.enqueue(21);
        queue.enqueue(35);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(57);
        queue.enqueue(91);
        queue.dequeue();


        //Act
        int dequeue = queue.dequeue();

        //Asserts
        Assertions.assertEquals(91, dequeue);
        Assertions.assertFalse(queue.isFull());
        Assertions.assertTrue(queue.isEmpty());
    }
}