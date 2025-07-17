package br.com.fabex.dataofstructs.hashtable.address.closed;

import br.com.fabex.dataofstructs.hashtable.AbstractHashTable;
import br.com.fabex.dataofstructs.linkedlist.doubly.generic.DoublyLinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractHashTableClosedAddress<T> extends AbstractHashTable<T> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHashTableClosedAddress.class);

    @Override
    protected void initiateInternalTable(int size) {
        this.table = new DoublyLinkedList[size];
    }

    protected abstract DoublyLinkedList<T> getLinkedListByIndex(int hashIndex
    );

    public void showDisplay() {
        logger.debug("HashTable:");
        for (int i = 0; i < table.length; i++) {
            StringBuilder row = new StringBuilder(String.valueOf(i));
            if (null != table[i]) {
                getLinkedListByIndex(i).toList().forEach(element -> row.append(" => ").append(element));
            }
            logger.debug("{}", row);
        }
    }
}
