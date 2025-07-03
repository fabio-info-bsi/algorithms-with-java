package br.com.fabex.dataofstructs.hashtable;

import br.com.fabex.dataofstructs.hashtable.hashfunction.HashFunction;

public abstract class AbstractHashTable<T> implements HashTable<T> {
    protected Object[] table;
    protected int elements = 0;
    protected int COLLISIONS = 0;
    protected HashFunction<T> hashFunction;

    protected void initiateInternalTable(int size) {
        this.table = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return elements == 0;
    }

    @Override
    public boolean isFull() {
        return elements == table.length;
    }

    @Override
    public int size() {
        return elements;
    }

    //???
    public int getCOLLISIONS() {
        return COLLISIONS;
    }
}
