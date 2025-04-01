package br.com.fabex.dataofstructs.stacks;

public class Stack {

    private int size, indexTop;
    private int[] stack;

    public Stack() {
        this(10);
    }

    public Stack(int length) {
        stack = new int[length];
    }

    /**
     * Return size of stack.
     *
     * @return int
     */
    public int getSize() {
        return stack.length;
    }

    /**
     * Return count elements of stack.
     *
     * @return size
     */
    public int getCount() {
        return size;
    }

    /**
     * Check if stack is empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return indexTop == 0;
    }

    /**
     * Adding element in stack.
     *
     * @param element
     */
    public void push(int element) {
        if (indexTop == stack.length) {
            throw new RuntimeException("Stack Overflow!");
        }
        stack[indexTop++] = element;
        size++;
    }

    /**
     * Removing element in stack.
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow!");
        }
        size--;
        return stack[--indexTop];
    }

    /**
     * Return element top in stack.
     *
     * @return
     */
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        return stack[indexTop - 1];
    }
}
