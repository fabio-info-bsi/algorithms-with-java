package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class DoubleLinkedListOrdered<T extends Comparable<T>> extends DoubleLinkedList<T> {

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

    public List<Element<T>> toList() {
        List<Element<T>> elements = new ArrayList<>();
        Element<T> pointer = head;
        while (pointer != null) {
            elements.add(pointer);
            pointer = pointer.next;
        }
        return elements;
    }

    public Set<Element<T>> toSet() {
        Set<Element<T>> elements = new LinkedHashSet<>();
        Element<T> pointer = head;
        while (pointer != null) {
            elements.add(pointer);
            pointer = pointer.next;
        }
        return elements;
    }
}
