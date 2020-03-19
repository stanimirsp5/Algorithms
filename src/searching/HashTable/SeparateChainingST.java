package searching.HashTable;

import searching.SequentialSearch;

// Hashing with separate chaining symbol table
public class SeparateChainingST<Key, Value> {
    private static final int INIT_CAPACITY= 997;
    private int m; // hash table size
    private SequentialSearch<Key, Value>[] st;

    public SeparateChainingST(){
        this(INIT_CAPACITY);
    }
    public SeparateChainingST(int m){
        // create m linked lists
        this.m = m;
        st = (SequentialSearch<Key, Value>[]) new SequentialSearch[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearch();
        }
    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }
    public void put(Key key, Value val){
        st[hash(key)].put(key, val);
    }
    //public Iterable<Key>keys(){}
}
