package br.com.fabex.dataofstructs.queues;

import br.com.fabex.dataofstructs.queues.exceptions.QueueException;

public class QueueImprove {
    private int indexHead = 0;
    private int indexTail = 0;
    private int[] queue;

    public QueueImprove() {
        this(10);
    }

    public QueueImprove(int length) {
        this.queue = new int[length];
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new QueueException("Queue Overflow!");
        }

        queue[indexTail % queue.length] = element;
        indexTail++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new QueueException("Queue Underflow!");
        }

        int element = queue[indexHead % queue.length];
        indexHead++;
        return element;
    }

    public boolean isEmpty() {
        return this.indexHead == this.indexTail;
    }

    public boolean isFull() {
        return Math.abs(indexHead - indexTail) == queue.length;
    }
}
