package br.com.fabex.dataofstructs.hashtable;

public interface HashTable<T> {
    boolean isEmpty();

    boolean isFull();

    int capacity();

    int size();

    void insert(T element);

    void delete(T element);

    T search(T element);

    int indexOf(T element);
}
