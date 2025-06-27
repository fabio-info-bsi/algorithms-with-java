package br.com.fabex.dataofstructs.queues;

import br.com.fabex.dataofstructs.queues.exceptions.QueueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueImproveTest {

    @Test
    void isEmptyTest1() {
        Assertions.assertTrue(new QueueImprove().isEmpty());
    }

    @Test
    void enqueueTest1() {
        //Arrange
        QueueImprove queue = new QueueImprove();

        //Act
        queue.enqueue(115);

        //Asserts
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertFalse(queue.isFull());
        Assertions.assertEquals(1, queue.getCountElements());
    }


    @Test
    void enqueueTest2() {
        //Arrange
        QueueImprove queue = new QueueImprove(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        //Act & Asserts
        QueueException queueException = Assertions.assertThrows(QueueException.class, () -> queue.enqueue(4));
        Assertions.assertEquals("Queue Overflow!", queueException.getMessage());
        Assertions.assertEquals(3, queue.getCountElements());
    }

    @Test
    void isFullTest1() {
        //Arrange
        QueueImprove queue = new QueueImprove(2);
        queue.enqueue(2);
        queue.enqueue(3);

        //Act & Asserts
        Assertions.assertTrue(queue.isFull());
        Assertions.assertEquals(2, queue.getCountElements());
    }

    @Test
    void isFullTest2() {
        //Act & Asserts
        Assertions.assertFalse(new QueueImprove(2).isFull());
    }

    @Test
    void isFullTest3() {
        //Arrange
        QueueImprove queue = new QueueImprove(1);
        queue.enqueue(-2);

        //Act & Asserts
        Assertions.assertTrue(queue.isFull());
        Assertions.assertEquals(1, queue.getCountElements());
    }

    @Test
    void isFullTest4() {
        //Arrange
        QueueImprove queue = new QueueImprove(5);
        queue.enqueue(-2);

        //Act & Asserts
        Assertions.assertFalse(queue.isFull());
        Assertions.assertEquals(1, queue.getCountElements());
    }

    @Test
    void dequeueTest1() {
        //Arrange
        QueueImprove queue = new QueueImprove(3);
        queue.enqueue(7); //head
        queue.enqueue(8);
        queue.enqueue(9);

        //Act
        int dequeue = queue.dequeue();


        //Asserts
        Assertions.assertEquals(7, dequeue);
        Assertions.assertFalse(queue.isFull());
        Assertions.assertEquals(2, queue.getCountElements());
    }

    @Test
    void dequeueTest2() {
        //Arrange
        QueueImprove queue = new QueueImprove(3);
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
        Assertions.assertEquals(0, queue.getCountElements());
    }

    @Test
    void dequeueTest3() {
        //Act & Asserts
        QueueImprove queue = new QueueImprove();
        QueueException queueException = Assertions.assertThrows(QueueException.class, queue::dequeue);
        Assertions.assertEquals("Queue Underflow!", queueException.getMessage());
    }

    @Test
    void enqueueAndDequeueTest1() {
        //Arrange
        QueueImprove queue = new QueueImprove(2);
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
        Assertions.assertEquals(1, queue.getCountElements());

    }

    @Test
    void enqueueAndDequeueTest2() {
        //Arrange
        QueueImprove queue = new QueueImprove(2);
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
        Assertions.assertEquals(0, queue.getCountElements());
    }
}