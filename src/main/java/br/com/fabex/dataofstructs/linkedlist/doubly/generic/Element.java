package br.com.fabex.dataofstructs.linkedlist.doubly.generic;

import java.util.Objects;

public class Element<T> {
    private final T key;
    Element<T> prev, next;

    public Element(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public Element<T> getPrev() {
        return prev;
    }

    public Element<T> getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Element<?> element)) return false;
        return Objects.equals(key, element.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public String toString() {
        return "{" + "key=" + key + "}";
    }
}
