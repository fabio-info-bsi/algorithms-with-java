package br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressFactory;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.HashFunctionOpenAddress;

public class HashFunctionLinearProbing<T> implements HashFunctionOpenAddress<T> {

    protected int tableSize;
    protected HashFunctionClosedAddress<T> hashFunction;

    public HashFunctionLinearProbing(int tableSize, HashFunctionClosedAddressMethodEnum methodEnum) {
        this.tableSize = tableSize;
        this.hashFunction = (HashFunctionClosedAddress<T>) HashFunctionClosedAddressFactory
                .<T>createHashFunction(methodEnum, tableSize);
    }

    @Override
    public int hash(T element, int probe) {
        return Math.abs((hashFunction.hash(element) + probe) % tableSize);
    }
}
