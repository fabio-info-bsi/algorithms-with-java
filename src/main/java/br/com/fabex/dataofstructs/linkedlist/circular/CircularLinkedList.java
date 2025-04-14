package br.com.fabex.dataofstructs.linkedlist.circular;


public class CircularLinkedList<T> {
    private final CircularElement<T> sentinel;
    private int countElements;

    public CircularLinkedList() {
        sentinel = new CircularElement<>();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public CircularElement<T> search(CircularElement<T> element) {
        CircularElement<T> found = sentinel;
        // Ugly impl ?! :(
        while (found.key != element.key) {
            found = found.next;
            if (found.equals(sentinel)) return null;
        }
        return found;
        // Beautiful impl ?! :)
        //do {
        //    found = found.next;
        //} while (found.key != element.key && found != sentinel);
        //return found.key != null ? found : null;
    }

    public void prepend(CircularElement<T> element) {
        insert(sentinel, element);
    }

    public void insert(CircularElement<T> pointer, CircularElement<T> element) {
        element.next = pointer.next;
        element.prev = pointer;
        pointer.next.prev = element;
        pointer.next = element;
        countElements++;
    }

    public void delete(CircularElement<T> element) {
        element.prev.next = element.next;
        element.next.prev = element.prev;
        countElements--;
    }

    public boolean isEmpty() {
        return sentinel.next.equals(sentinel) && sentinel.prev.equals(sentinel);
    }

    public CircularElement<T> getHead() {
        return sentinel.next;
    }

    public int getCountElements() {
        return countElements;
    }
}
