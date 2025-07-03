package br.com.fabex.dataofstructs.hashtable.hashfunction.address.open;

import br.com.fabex.dataofstructs.hashtable.hashfunction.HashFunction;

public interface HashFunctionOpenAddress<T> extends HashFunction<T> {
    int hash(T element, int probe);
}
