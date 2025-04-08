package br.com.fabex.dataofstructs.linked.integer;

public class DoubleLinkedListInteger {
    private ElementInteger head;
    private int countElements;

    public ElementInteger search(ElementInteger element) {
        ElementInteger found = head;
        while (found != null && found.key != element.key) {
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

    public void insertFromElement(ElementInteger pointer, ElementInteger newElementInteger) {
        newElementInteger.next = pointer.next;
        newElementInteger.prev = pointer;
        if (pointer.next != null) {
            pointer.next.prev = newElementInteger;
        }
        pointer.next = newElementInteger;
        countElements++;
    }

    public void delete(ElementInteger element) {
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

    public ElementInteger getHead() {
        return head;
    }

    public int getCountElements() {
        return countElements;
    }

}
