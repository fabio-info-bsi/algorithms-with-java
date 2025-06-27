package br.com.fabex.dataofstructs.stacks;

public class StackImprove {

    private int indexTop;
    private int[] stack;

    public StackImprove() {
        this(10);
    }

    public StackImprove(int length) {
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
        return this.indexTop;
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
