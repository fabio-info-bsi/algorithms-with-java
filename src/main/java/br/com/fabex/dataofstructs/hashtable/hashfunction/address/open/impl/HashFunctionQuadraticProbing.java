package br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressFactory;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.HashFunctionOpenAddress;

public class HashFunctionQuadraticProbing<T> implements HashFunctionOpenAddress<T> {

    protected int tableSize;
    protected HashFunctionClosedAddress<T> hashFunction;
    protected int c1;
    protected int c2;

    public HashFunctionQuadraticProbing(int tableSize, HashFunctionClosedAddressMethodEnum methodEnum, int c1, int c2) {
        this.tableSize = tableSize;
        this.hashFunction = (HashFunctionClosedAddress<T>) HashFunctionClosedAddressFactory
                .<T>createHashFunction(methodEnum, tableSize);
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public int hash(T element, int probe) {
        return (hashFunction.hash(element) + c1 * probe + c2 * probe * probe) % tableSize;
    }
}
