package br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;

public class HashFunctionMultiplication<T> implements HashFunctionClosedAddress<T> {

    protected int tableSize;
    /**
     * Constant range: 0 < A < 1
     */
    protected double constantA;

    public HashFunctionMultiplication(int tableSize) {
        this(tableSize, .14);
    }

    public HashFunctionMultiplication(int tableSize, double constant) {
        this.tableSize = tableSize;
        this.constantA = constant;
    }

    @Override
    public int hash(T element) {
        int key = element.hashCode();
        double fractionPart = (key * constantA) - Math.floor(key * constantA);
        return (int) (tableSize * fractionPart);
    }
}
