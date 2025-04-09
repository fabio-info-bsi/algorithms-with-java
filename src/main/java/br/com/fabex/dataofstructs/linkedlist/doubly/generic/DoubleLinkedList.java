package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

public class DoubleLinkedList<T> {
    private Element<T> head;
    private int countElements;

    public Element<T> search(Element<T> element) {
        Element<T> found = head;
        while (found != null && found.key != element.key) {
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

}
