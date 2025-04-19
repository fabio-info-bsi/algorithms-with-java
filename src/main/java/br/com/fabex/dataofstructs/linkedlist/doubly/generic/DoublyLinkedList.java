package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DoublyLinkedList<T> {
    protected Element<T> head;
    protected int countElements;

    public Element<T> search(Element<T> element) {
        Element<T> found = head;
        while (found != null && found.getKey() != element.getKey()) {
            found = found.next;
        }
        return found;
    }

    public void prepend(Element<T> element) {
        element.next = head;
        element.prev = null;
        if (head != null) {
            head.prev = element;
        }
        head = element;
        countElements++;
    }

    /**
     * Insert element after pointer.
     * @param pointer
     * @param element
     */
    public void insert(Element<T> pointer, Element<T> element) {
        element.next = pointer.next;
        element.prev = pointer;
        if (pointer.next != null) {
            pointer.next.prev = element;
        }
        pointer.next = element;
        countElements++;
    }

    public void delete(Element<T> element) {
        if (element.prev != null) {
            element.prev.next = element.next;
        } else {
            head = element.next;
        }

        if (element.next != null) {
            element.next.prev = element.prev;
        }
        countElements--;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Element<T> getHead() {
        return head;
    }

    public int getCountElements() {
        return countElements;
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
