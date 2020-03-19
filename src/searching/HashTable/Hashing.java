package searching.HashTable;

import java.security.Key;

public class Hashing<Key, Value> {
    private int m = 1000;

    public int hash(Key key){
        int hashed = (key.hashCode() & 0x7fffffff) % m;
        return hashed;
    }

}
