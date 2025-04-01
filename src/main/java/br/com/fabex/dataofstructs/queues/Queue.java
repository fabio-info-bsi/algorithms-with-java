package br.com.fabex.dataofstructs.queues;

public class Queue {
    private int indexHead = 1, indexTail = 1, size;
    private int[] queue;

    public Queue() {
        this(10);
    }

    public Queue(int length) {
        this.queue = new int[length];
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow!");
        }

        queue[indexTail - 1] = element;
        if (indexTail == queue.length) {
            indexTail = 1;
        } else {
            indexTail++;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow!");
        }

        int element = queue[indexHead - 1];
        if (indexHead == queue.length) {
            indexHead = 1;
        } else {
            indexHead++;
        }
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return queue.length == size;
    }
}
