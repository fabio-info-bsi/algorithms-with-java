package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.address.open.AbstractHashTableOpenAddress;
import br.com.fabex.dataofstructs.hashtable.exception.HastTableOverflowException;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
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
            collisions++;
            i++;
        } while (i != table.length);
        if (this.reSize && (this.elements == size() /*|| Arrived threshold || MaxLimit of memory */)) {
            reHash();
            //After resize HashTable insert new element
            insert(element);
        } else {
            throw new HastTableOverflowException("HashTable OverFlow!");
        }
    }

    private void reHash() {
        logger.debug("ReHashing start");

        //ReSize (Doubling capacity HashTable) - Use another calculate here to improve increase of the table
        logger.debug("Calculating new capacity ({} x 2)", this.tableSize);
        int newHashTableSize = this.tableSize * 2;

        this.tableSize = newHashTableSize;
        logger.debug("New capacity HashTable [{}]", newHashTableSize);

        //Get Old HashTable
        Storable[] oldHashTable = (Storable[]) this.table;

        //Reallocate new HashTable capacity
        this.table = new Storable[newHashTableSize];

        logger.debug("Resetting count elements & COLLISIONS");
        this.elements = 0;
        this.collisions = 0;

        //Change HashTable Function with new Table Size
        logger.debug("Updating HashTable Function with new Table Size");
        this.hashFunction = new HashFunctionLinearProbing<>(newHashTableSize, methodEnum);

        //Reallocating slots
        for (Storable item : oldHashTable) {
            insert((T) item);
        }
        logger.debug("ReHashing finished");
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
}
