package br.com.fabex.dataofstructs.hashtable.address.open;

import br.com.fabex.dataofstructs.hashtable.AbstractHashTable;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.open.HashFunctionOpenAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractHashTableOpenAddress<T extends AbstractHashTableOpenAddress.Storable> extends AbstractHashTable<T> {
    private static final Logger logger = LoggerFactory.getLogger(AbstractHashTableOpenAddress.class);

    public static interface Storable {
    }

    protected static class Deleted implements Storable {
        @Override
        public String toString() {
            return "Deleted{}";
        }
    }

    protected int tableSize;
    protected final Deleted elementDeleted = new Deleted();

    protected AbstractHashTableOpenAddress(int size) {
        this.tableSize = size;
        this.initiateInternalTable(size);
    }

    @Override
    protected void initiateInternalTable(int size) {
        this.table = new Storable[size];
    }

    protected int getHashIndex(T element, int probe) {
        return ((HashFunctionOpenAddress<T>) hashFunction).hash(element, probe);
    }

    public void showDisplay() {
        logger.debug("HashTable:");
        for (int i = 0; i < table.length; i++) {
            logger.debug("{} => {}", i, table[i]);
        }
    }
}
