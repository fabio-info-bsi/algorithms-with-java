package br.com.fabex.dataofstructs.hashtable.hashfunction.address.closed;

import br.com.fabex.dataofstructs.hashtable.hashfunction.HashFunction;

public interface HashFunctionClosedAddress<T> extends HashFunction<T> {
    int hash(T element);
}
