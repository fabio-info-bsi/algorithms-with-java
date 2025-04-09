package br.com.fabex.dataofstructs.linkedlist.doubly.integer;

public class DoubleLinkedListInteger {
    private ElementInteger head;
    private int countElements;

    public ElementInteger search(ElementInteger elementInteger) {
        ElementInteger found = head;
        while (found != null && found.key != elementInteger.key) {
            found = found.next;
        }
        return found;
    }

    public void prepend(ElementInteger newElementInteger) {
        newElementInteger.next = head;
        newElementInteger.prev = null;
        if (head != null) {
            head.prev = newElementInteger;
        }
        head = newElementInteger;
        countElements++;
    }

    public void insert(ElementInteger pointer, ElementInteger newElementInteger) {
        newElementInteger.next = pointer.next;
        newElementInteger.prev = pointer;
        if (pointer.next != null) {
            pointer.next.prev = newElementInteger;
        }
        pointer.next = newElementInteger;
        countElements++;
    }

    public void delete(ElementInteger elementInteger) {
        if (elementInteger.prev != null) {
            elementInteger.prev.next = elementInteger.next;
        } else {
            head = elementInteger.next;
        }

        if (elementInteger.next != null) {
            elementInteger.next.prev = elementInteger.prev;
        }
        countElements--;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public ElementInteger getHead() {
        return head;
    }

    public int getCountElements() {
        return countElements;
    }

}
