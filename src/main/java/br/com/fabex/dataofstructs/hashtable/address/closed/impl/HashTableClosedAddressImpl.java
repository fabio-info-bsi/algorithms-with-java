package br.com.fabex.dataofstructs.hashtable.address.closed.impl;

import br.com.fabex.dataofstructs.hashtable.address.closed.AbstractHashTableClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressFactory;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.linkedlist.doubly.generic.DoublyLinkedList;
import br.com.fabex.dataofstructs.linkedlist.doubly.generic.Element;

public class HashTableClosedAddressImpl<T> extends AbstractHashTableClosedAddress<T> {

    public HashTableClosedAddressImpl(HashFunctionClosedAddressMethodEnum methodEnum, int desiredSize) {
        //Inicialmente apenas com metodo de multiplicação
        this.hashFunction = HashFunctionClosedAddressFactory.createHashFunction(methodEnum, desiredSize);
        this.initiateInternalTable(desiredSize);
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public void insert(T element) {
        System.out.println(element.hashCode());
        //Element<T> nodeLinkedList = new Element<>(element);
        int hashIndex = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);
        if (null != table[hashIndex]) {
            DoublyLinkedList<T> doublyLinkedList = getDoublyLinkedListByIndex(hashIndex);
            T search = doublyLinkedList.search(element);
            if (null != search) {
                //crazy!
                //search.setKey(element);
                //doublyLinkedList.
                //return;
            }
            doublyLinkedList.prepend(element);
            COLLISIONS++;
        } else {
            table[hashIndex] = new DoublyLinkedList<T>();
            getDoublyLinkedListByIndex(hashIndex).prepend(element);
        }
        this.elements++;
    }

    @Override
    public void delete(T element) {

        this.elements--;
    }

    @Override
    public T search(T element) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    private DoublyLinkedList<T> getDoublyLinkedListByIndex(int hashIndex) {
        return (DoublyLinkedList<T>) table[hashIndex];
    }
}
