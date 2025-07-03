package br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;

public class HashFunctionDivision<T> implements HashFunctionClosedAddress<T> {

    protected int tableSize;

    public HashFunctionDivision(int tableSize) {
        this.tableSize = tableSize;
    }

    @Override
    public int hash(T element) {
        int hashKey;
        int key = element.hashCode();
        hashKey = key % tableSize;
        return Math.abs(hashKey);
    }
}
