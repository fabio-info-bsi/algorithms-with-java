package br.com.fabex.dataofstructs.linkedlist.doubly.integer;

public class ElementInteger {
    int key;
    ElementInteger prev, next;

    ElementInteger() {
    }

    public ElementInteger(int key) {
        this.key = key;
    }

    ElementInteger(int key, ElementInteger prev, ElementInteger next) {
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}
