package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

public final class DoublyLinkedListOrdered<T extends Comparable<T>> extends DoublyLinkedList<T> {

    @Override
    public void insert(Element<T> pointer, Element<T> element) {
        throw new UnsupportedOperationException("Unsupported in Ordered LinkedList");
    }

    /**
     * Ordered insertion.
     *
     * @param element
     */
    @Override
    public void prepend(Element<T> element) {
        // First element or element is smallest
        if (null == head || element.getKey().compareTo(head.getKey()) <= 0) {
            super.prepend(element);
            return;
        }

        Element<T> pointer = head;
        while (pointer.next != null && element.getKey().compareTo(pointer.next.getKey()) > 0) {
            pointer = pointer.next;
        }

        super.insert(pointer, element);
    }
}
