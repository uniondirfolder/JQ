package com.nvv.itstep.hw.d0;

import com.nvv.itstep.hw.d09092021_p1.ConstructorException;
import com.nvv.itstep.hw.d09092021_p1.MemorySerializer;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class Pair<K, V> implements Serializable, Comparable<Pair<K, V>> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Pair<K, V> getSerializeCopy() throws ConstructorException {
        try {
            Pair<K, V> _new = new MemorySerializer<Pair<K, V>>().serialize(this);
            return _new;
        } catch (IOException | ClassNotFoundException e) {
            throw new ConstructorException(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.equals(pair.key) && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }


    @Override
    public int compareTo(Pair<K, V> o) {
        if (this.equals(o)) return 0;
        boolean i = o.key.equals(o.key);
        boolean j = o.value.equals(o.value);
        if(i && j) return 0;
        if(key.getClass().getTypeName().equals(value.getClass().getTypeName())){
            return 1;
        }
        return  -1;
    }
}
