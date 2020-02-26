package searching.HashTable;

import java.security.Key;

public class Hashing {
    private int m = 1000;

    public int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }
}
