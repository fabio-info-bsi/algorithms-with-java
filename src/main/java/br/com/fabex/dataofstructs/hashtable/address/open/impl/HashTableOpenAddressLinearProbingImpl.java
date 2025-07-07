package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.address.open.AbstractHashTableOpenAddress;
import br.com.fabex.dataofstructs.hashtable.exception.HastTableOverFlowException;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.HashFunctionOpenAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl.HashFunctionLinearProbing;

public class HashTableOpenAddressLinearProbingImpl<T extends AbstractHashTableOpenAddress.Storable> extends AbstractHashTableOpenAddress<T> {

    public HashTableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethodEnum methodEnum) {
        super(size);
        this.hashFunction = new HashFunctionLinearProbing<>(size, methodEnum);
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    public void insert(T element) {
        int hashIndex;
        int i = 0;
        do {
            hashIndex = getHashIndex(element, i);
            if (null == table[hashIndex] || table[hashIndex].equals(element)
                    || table[hashIndex].equals(elementDeleted)) {
                //For count new element
                if (null == table[hashIndex] || table[hashIndex].equals(elementDeleted)) {
                    elements++;
                }
                table[hashIndex] = element;
                return;
            }
            COLLISIONS++;
            i++;
        } while (i != table.length);
        throw new HastTableOverFlowException("HashTable OverFlow!");
    }

    @Override
    public void delete(T element) {
        int i = 0;
        int hashIndex = getHashIndex(element, i);
        while (null != table[hashIndex] && i < table.length) { //is deleted
            if (table[hashIndex].equals(element)) {
                table[hashIndex] = elementDeleted;
                elements--;
            }
            i++;
            hashIndex = getHashIndex(element, i);
        }
    }

    @Override
    public T search(T element) {
        int i = 0;
        int hashIndex = getHashIndex(element, i);
        while (null != table[hashIndex] && i < table.length) {
            if (table[hashIndex].equals(element)) {
                return (T) table[hashIndex];
            }
            i++;
            hashIndex = getHashIndex(element, i);
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        int hashIndex;
        int i = 0;
        do {
            hashIndex = getHashIndex(element, i);
            if (null != table[hashIndex] && table[hashIndex].equals(element)) {
                return hashIndex;
            }
            i++;
        } while (i != table.length);
        return -1;
    }

    private int getHashIndex(T element, int probe) {
        return ((HashFunctionOpenAddress<T>) hashFunction).hash(element, probe);
    }
}
