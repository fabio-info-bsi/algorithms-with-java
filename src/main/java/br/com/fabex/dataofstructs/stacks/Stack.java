package br.com.fabex.dataofstructs.stacks;

public class Stack {

    private int size, top;
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
        return top == 0;
    }

    public void push(int element) {
        if (top == stack.length) {
            throw new RuntimeException("Overflow!");
        }
        stack[top++] = element;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        size--;
        return stack[--top];
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        return stack[top - 1];
    }
}
