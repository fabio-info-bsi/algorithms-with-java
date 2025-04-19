package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

public final class DoublyLinkedListOrdered<T extends Comparable<T>> extends DoublyLinkedList<T> {

    @Override
    public void insert(Element<T> pointer, Element<T> element) {
        throw new UnsupportedOperationException("Unsupported in Ordered LinkedList");
    }

    /**
     * Ordered insertion.
     * @param element
     */
    @Override
    public void prepend(Element<T> element) {
        Element<T> pointer = head;

        // First element
        if (null == pointer) {
            super.prepend(element);
            return;
        }

        while (element.getKey().compareTo(pointer.getKey()) > 0 && pointer.next != null) {
            pointer = pointer.next;
        }

        // When is the last element: largest or smallest (loop condition)
        if (pointer.getKey().compareTo(element.getKey()) < 0) {
            super.insert(pointer, element);
        } else {
            this.insertInternal(pointer, element);
        }
    }

    /**
     * Insert element before pointer.
     *
     * @param pointer
     * @param element
     */
    private void insertInternal(Element<T> pointer, Element<T> element) {
        element.next = pointer;
        element.prev = pointer.prev;
        if (pointer.prev != null) {
            pointer.prev.next = element;
        }
        pointer.prev = element;
        if (head == pointer) {
            head = element;
        }
        countElements++;
    }
}
