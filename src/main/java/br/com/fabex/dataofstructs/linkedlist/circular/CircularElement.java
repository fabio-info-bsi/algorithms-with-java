package br.com.fabex.dataofstructs.linkedlist.circular;

public class CircularElement<T> {
    T key;
    CircularElement<T> prev, next;

    public CircularElement() {
    }

    public CircularElement(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public CircularElement<T> getPrev() {
        return prev;
    }

    public CircularElement<T> getNext() {
        return next;
    }
}
