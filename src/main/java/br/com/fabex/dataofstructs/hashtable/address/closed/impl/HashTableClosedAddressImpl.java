package br.com.fabex.dataofstructs.hashtable.address.closed.impl;

import br.com.fabex.dataofstructs.hashtable.address.closed.AbstractHashTableClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddress;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressFactory;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import br.com.fabex.dataofstructs.linkedlist.doubly.generic.DoublyLinkedList;
import br.com.fabex.dataofstructs.linkedlist.doubly.generic.Element;

import java.util.Optional;

public class HashTableClosedAddressImpl<T> extends AbstractHashTableClosedAddress<T> {

    public HashTableClosedAddressImpl(HashFunctionClosedAddressMethodEnum methodEnum, int desiredSize) {
        //Inicialmente apenas com metodo de multiplicação
        this.hashFunction = HashFunctionClosedAddressFactory.createHashFunction(methodEnum, desiredSize);
        this.initiateInternalTable(desiredSize);
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    public void insert(T element) {
        int hashIndex = getHashIndex(element);
        Element<T> newElementLinkedList = new Element<>(element);
        if (null != table[hashIndex]) {
            DoublyLinkedList<T> linkedList = getLinkedListByIndex(hashIndex);
            Element<T> search = linkedList.search(newElementLinkedList);
            //if exist element, then update
            if (null != search) {
                linkedList.update(search, element);
                return;
            }
            linkedList.prepend(newElementLinkedList);
            COLLISIONS++;
        } else {
            table[hashIndex] = new DoublyLinkedList<T>();
            getLinkedListByIndex(hashIndex).prepend(newElementLinkedList);
        }
        this.elements++;
    }

    @Override
    public void delete(T element) {
        int hashIndex = getHashIndex(element);
        if (null != table[hashIndex]) {
            DoublyLinkedList<T> linkedList = getLinkedListByIndex(hashIndex);
            //Search and Delete element in LinkedList if exist
            Optional.ofNullable(linkedList.search(new Element<>(element)))
                    .ifPresent(linkedList::delete);
            //Cleaning slot if LinkedList is empty
            if (linkedList.isEmpty()) {
                table[hashIndex] = null;
            }
            this.elements--;
        }
    }

    @Override
    public T search(T element) {
        int hashIndex = getHashIndex(element);
        if (null != table[hashIndex]) {
            Element<T> searched = getLinkedListByIndex(hashIndex).search(new Element<>(element));
            return Optional.ofNullable(searched).orElse(new Element<>(null)).getKey();
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        int hashIndex = getHashIndex(element);
        int foundIndex = -1;
        if (null != table[hashIndex]) {
            foundIndex = Optional.ofNullable(getLinkedListByIndex(hashIndex).search(new Element<>(element)))
                    .isPresent() ? hashIndex : -1;
        }
        return foundIndex;
    }

    @Override
    protected DoublyLinkedList<T> getLinkedListByIndex(int hashIndex) {
        return (DoublyLinkedList<T>) table[hashIndex];
    }

    private int getHashIndex(T element) {
        return ((HashFunctionClosedAddress<T>) hashFunction).hash(element);
    }
}
