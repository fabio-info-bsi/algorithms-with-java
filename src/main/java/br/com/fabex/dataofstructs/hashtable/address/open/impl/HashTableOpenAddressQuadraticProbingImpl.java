package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.address.open.AbstractHashTableOpenAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl.HashFunctionLinearProbing;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl.HashFunctionQuadraticProbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashTableOpenAddressQuadraticProbingImpl<T extends AbstractHashTableOpenAddress.Storable> extends AbstractHashTableOpenAddress<T> {

    private static final Logger logger = LoggerFactory.getLogger(HashTableOpenAddressQuadraticProbingImpl.class);
    private final HashFunctionClosedAddressMethodEnum methodEnum;
    private final boolean reSize;

    public HashTableOpenAddressQuadraticProbingImpl(int size,
                                                    HashFunctionClosedAddressMethodEnum methodEnum) {
        this(size, methodEnum, false);
    }

    public HashTableOpenAddressQuadraticProbingImpl(int size,
                                                    HashFunctionClosedAddressMethodEnum methodEnum,
                                                    boolean reSize) {
        super(size);
        this.reSize = reSize;
        this.methodEnum = methodEnum;
        this.hashFunction = new HashFunctionQuadraticProbing<>(size, methodEnum, 2, 3);
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    public void insert(T element) {

    }

    @Override
    public void delete(T element) {

    }

    @Override
    public T search(T element) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }
}
