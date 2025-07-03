package br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed;

import br.com.fabex.dataofstructs.hashtable.hashfunction.HashFunction;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.impl.HashFunctionDivision;
import br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed.impl.HashFunctionMultiplication;

public class HashFunctionClosedAddressFactory {

    private HashFunctionClosedAddressFactory() {
    }

    public static <T> HashFunction<T> createHashFunction(HashFunctionClosedAddressMethodEnum methodEnum, int sizeTable) {
        return switch (methodEnum) {
            case DIVISION -> new HashFunctionDivision<>(sizeTable);
            case MULTIPLICATION -> new HashFunctionMultiplication<>(sizeTable);
        };
    }
}
