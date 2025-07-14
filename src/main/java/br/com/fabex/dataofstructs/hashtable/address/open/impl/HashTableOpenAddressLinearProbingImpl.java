package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.address.open.AbstractHashTableOpenAddress;
import br.com.fabex.dataofstructs.hashtable.exception.HastTableOverFlowException;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.HashFunctionOpenAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl.HashFunctionLinearProbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashTableOpenAddressLinearProbingImpl<T extends AbstractHashTableOpenAddress.Storable> extends AbstractHashTableOpenAddress<T> {

    private static final Logger logger = LoggerFactory.getLogger(HashTableOpenAddressLinearProbingImpl.class);
    private final HashFunctionClosedAddressMethodEnum methodEnum;
    private final boolean reSize;

    public HashTableOpenAddressLinearProbingImpl(int size,
                                                 HashFunctionClosedAddressMethodEnum methodEnum) {
        this(size, methodEnum, false);
    }

    public HashTableOpenAddressLinearProbingImpl(int size,
                                                 HashFunctionClosedAddressMethodEnum methodEnum,
                                                 boolean reSize) {
        super(size);
        this.reSize = reSize;
        this.methodEnum = methodEnum;
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
        if (this.reSize && (this.elements == size() /* || arrived threshold Or MaxLimit of memory */)) {
            reHash();
        } else {
            throw new HastTableOverFlowException("HashTable OverFlow!");
        }
    }

    private void reHash() {
        logger.info("ReHashing ...");
        //ReSize (Doubling capacity HashTable) - Use another calculate here to improve increase of the table
        int newHashTableSize = this.tableSize * 2;
        this.tableSize = newHashTableSize;
        logger.info("new Capacity [{}]", newHashTableSize);

        //Get Old HashTable
        Storable[] oldHashTable = (Storable[]) this.table;

        //Reallocate new HashTable capacity
        this.table = new Storable[newHashTableSize];

        //Resetting count elements & COLLISIONS
        this.elements = 0;
        this.COLLISIONS = 0;

        //Change HashTable Function
        this.hashFunction = new HashFunctionLinearProbing<>(newHashTableSize, methodEnum);

        //Reallocating slots
        for (Storable item : oldHashTable) {
            if (item instanceof Deleted) {
                continue;
            }
            insert((T) item);
        }

    }

    @Override
    public void delete(T element) {
        int i = 0;
        int hashIndex = getHashIndex(element, i);
        while (null != table[hashIndex] && i < table.length) {
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
