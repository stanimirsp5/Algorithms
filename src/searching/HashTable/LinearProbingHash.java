package searching.HashTable;

public class LinearProbingHash<Key, Value> {
    private int n; // number of key-value pairs in the table
    private int m = 16; // size of linear-probing table
    private Key[] keys; // parallel arrays as BinarySearchTree()
    private Value[] vals;

    public LinearProbingHash(int m){
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }
    private void resize(int cap){
        LinearProbingHash<Key, Value> t;
        t = new LinearProbingHash<Key, Value>(cap);
        //t = new LinearProbingHash<Key, Value>();
        for (int i = 0; i < m; i++) {
            if(keys[i] != null){
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        m = t.m;
    }
    public void put(Key key, Value val){
        if(n >= m/2) resize(2*m); // double m
        int i;
        // if key doesn't hashes to empty entry
        // scan sequentially to find empty position
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    public Value get(Key key){
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % m) {
            if(keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }
    public void delete(Key key){
        //if(!contains(key)) return;
        int i = hash(key);
        while(!key.equals(keys[i])){
            i = (i + 1) % m;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % m;
        while(keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            n--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % m;
        }
        n--;
        if(n > 0 && n <= m/8){
            resize(m/2);
        }
    }

}
