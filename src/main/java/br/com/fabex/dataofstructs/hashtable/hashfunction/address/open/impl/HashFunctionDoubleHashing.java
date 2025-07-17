package br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.HashFunctionOpenAddress;

public class HashFunctionDoubleHashing<T> implements HashFunctionOpenAddress<T> {

    protected int tableSize;
    protected HashFunctionClosedAddress<T> hashFunction1;
    protected HashFunctionClosedAddress<T> hashFunction2;

    public HashFunctionDoubleHashing(int tableSize, HashFunctionClosedAddress<T> hashFunction1,
                                     HashFunctionClosedAddress<T> hashFunction2) {
        this.tableSize = tableSize;
        this.hashFunction1 = hashFunction1;
        this.hashFunction2 = hashFunction2;
    }

    @Override
    public int hash(T element, int probe) {
        return Math.abs((hashFunction1.hash(element) + probe * hashFunction2.hash(element)) % tableSize);
    }
}
