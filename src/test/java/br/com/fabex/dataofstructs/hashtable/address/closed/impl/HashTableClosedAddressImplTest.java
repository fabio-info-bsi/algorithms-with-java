package br.com.fabex.dataofstructs.hashtable.address.closed.impl;

import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.HashFunctionClosedAddressMethodEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableClosedAddressImplTest {

    @Test
    void capacity() {
    }

    @Test
    void insert() {
        //Arrange
        HashTableClosedAddressImpl<String> htca = new HashTableClosedAddressImpl<>(HashFunctionClosedAddressMethodEnum.DIVISION, 10);
        htca.insert("Fabex santana");
        htca.insert("Fabex");
        htca.insert("Fabex Hen");
        htca.insert("Fabex");
        htca.insert("Marco");
        htca.insert("Fabio");


        //Act

        //Asserts
    }

    @Test
    void delete() {
    }

    @Test
    void search() {
    }

    @Test
    void indexOf() {
    }
}