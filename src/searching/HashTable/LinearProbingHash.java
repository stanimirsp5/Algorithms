package searching.HashTable;

public class LinearProbingHash<Key, Value> {
    private int n; // number of key-value pairs in the table
    private int m = 16; // size of linear-probing table
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHash(){
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }
    private void resize(){}
    public void put(Key key, Value val){
        if(n >= m/2) resize(2*m); // double m
        int i;
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

}
