package br.com.fabex.dataofstructs.hashtable.address.open.impl;

import br.com.fabex.dataofstructs.hashtable.address.open.AbstractHashTableOpenAddress;

import java.util.Objects;

public class CustomStorableTest implements AbstractHashTableOpenAddress.Storable {
    Long id;
    String name;

    public CustomStorableTest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomStorableTest(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomStorableTest customObjectTest = (CustomStorableTest) o;
        return Objects.equals(id, customObjectTest.id);
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", name='" + name + '}';
    }
}
