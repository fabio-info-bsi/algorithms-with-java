package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.address.open.AbstractHashTableOpenAddress;
import br.com.fabex.dataofstructs.hashtable.exception.ProbingFailedException;
import br.com.fabex.dataofstructs.hashtable.exception.HastTableOverflowException;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.impl.HashFunctionQuadraticProbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashTableOpenAddressQuadraticProbingImpl<T extends AbstractHashTableOpenAddress.Storable> extends AbstractHashTableOpenAddress<T> {

    private static final Logger logger = LoggerFactory.getLogger(HashTableOpenAddressQuadraticProbingImpl.class);
    private final HashFunctionClosedAddressMethodEnum methodEnum;
    private final boolean reSize;
    /* Constant HashFunction */
    private final int c1;
    private final int c2;

    public HashTableOpenAddressQuadraticProbingImpl(int size,
                                                    HashFunctionClosedAddressMethodEnum methodEnum) {
        this(size, methodEnum, true);
    }

    public HashTableOpenAddressQuadraticProbingImpl(int size,
                                                    HashFunctionClosedAddressMethodEnum methodEnum,
                                                    boolean reSize) {
        this(size, methodEnum, 1, 1, reSize);
    }

    public HashTableOpenAddressQuadraticProbingImpl(int size,
                                                    HashFunctionClosedAddressMethodEnum methodEnum,
                                                    int c1,
                                                    int c2,
                                                    boolean reSize) {
        super(size);
        this.c1 = c1;
        this.c2 = c2;
        this.reSize = reSize;
        this.methodEnum = methodEnum;
        this.hashFunction = new HashFunctionQuadraticProbing<>(size, methodEnum, c1, c2);
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

        //Insertion Fails: why? (Is full, Not found slot available, Threshold, Max Limit of Memory)
        if (this.reSize /* && (your best suitable conditions - above ↑ )*/) {
            reHash();
            //After resize HashTable insert new element
            insert(element);
        } else {
            //If HashTable no resizable (this.reSize), verify if HashTable isFull then throw exception!
            if (isFull()) {
                throw new HastTableOverflowException("HashTable OverFlow!");
            } else {
                throw new ProbingFailedException("Failed to insert element: no available slot after quadratic probing.");

            }
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
        this.COLLISIONS = 0;

        //Change HashTable Function with new Table Size
        logger.debug("Updating HashTable Function with new Table Size");
        this.hashFunction = new HashFunctionQuadraticProbing<>(newHashTableSize, methodEnum, c1, c2);

        logger.debug("Reallocating slots");
        for (Storable item : oldHashTable) {
            if (null == item || item instanceof Deleted) {
                logger.debug("Ignoring deleted slot or Null {}", item);
                continue;
            }
            int hashIndex;
            int i = 0;
            do {
                hashIndex = getHashIndex((T) item, i);
                if (null == table[hashIndex]) {
                    elements++;
                    table[hashIndex] = item;
                    break;
                }
                COLLISIONS++;
                i++;
            } while (i != this.tableSize);

            //Never pass here because always size HashTable is doubling
            if (i == this.tableSize) {
                logger.error("Element no relocate {}", item);
            }
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
