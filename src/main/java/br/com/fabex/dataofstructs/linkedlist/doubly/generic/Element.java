package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

public class Element<T> {
    T key;
    Element<T> prev, next;

    public Element() {
    }

    public Element(T key) {
        this.key = key;
    }

    public Element(T key, Element<T> prev, Element<T> next) {
        this.key = key;
        this.prev = prev;
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public Element<T> getPrev() {
        return prev;
    }

    public void setPrev(Element<T> prev) {
        this.prev = prev;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }
}
