package br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.impl.HashFunctionDivision;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.impl.HashFunctionMultiplication;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.HashFunctionOpenAddress;

public class HashFunctionLinearProbing<T> implements HashFunctionOpenAddress<T> {

    protected int tableSize;
    protected HashFunctionClosedAddress<T> hashFunction;

    public HashFunctionLinearProbing(int tableSize, HashFunctionClosedAddressMethodEnum methodEnum) {
        this.tableSize = tableSize;
        if (methodEnum.equals(HashFunctionClosedAddressMethodEnum.DIVISION)) {
            this.hashFunction = new HashFunctionDivision<>(tableSize);
        } else {
            this.hashFunction = new HashFunctionMultiplication<>(tableSize);
        }
    }

    @Override
    public int hash(T element, int probe) {
        return (hashFunction.hash(element) + probe) % tableSize;
    }
}
