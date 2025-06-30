package br.com.fabex.dataofstructs.hashtable.address.closed;

import br.com.fabex.dataofstructs.hashtable.AbstractHashTable;
import br.com.fabex.dataofstructs.linkedlist.doubly.generic.DoublyLinkedList;

public abstract class AbstractHashTableClosedAddress<T extends Comparable<T>> extends AbstractHashTable<T> {

    @Override
    protected void initiateInternalTable(int size) {
        this.table = new DoublyLinkedList[size];
    }
}
