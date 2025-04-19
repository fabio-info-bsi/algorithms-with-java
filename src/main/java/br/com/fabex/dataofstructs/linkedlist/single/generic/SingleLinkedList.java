package br.com.fabex.dataofstructs.linkedlist.single.generic;

public class SingleLinkedList<T> {
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
        head = element;
        countElements++;
    }

    /**
     * .
     *
     * @param pointer
     * @param element
     */
    public void insert(Element<T> pointer, Element<T> element) {
        element.next = pointer.next;
        pointer.next = element;
        countElements++;
    }

    public void delete(Element<T> element) {

        if(isEmpty()){
            return;
        }

        // first element
        if (head.equals(element)) {
            head = head.next;
            countElements--;
            return;
        }

        Element<T> foundPrev = head;
        while (foundPrev.next != null && !foundPrev.next.equals(element)) {
            foundPrev = foundPrev.next;
        }

        if (foundPrev.next != null) {
            foundPrev.next = foundPrev.next.next;
            countElements--;
        }
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
