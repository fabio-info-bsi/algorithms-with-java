package br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;

public class HashFunctionMultiplication<T> implements HashFunctionClosedAddress<T> {

    protected int tableSize;

    public HashFunctionMultiplication(int tableSize) {
        this.tableSize = tableSize;
    }

    @Override
    public int hash(T element) {
        return 0;
    }
}
