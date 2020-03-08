package searching.HashTable;

public class LPH2<Key,Value> {
    private int n;
    private int m = 16;
    private Key[] keys;
    private Value[] values;

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void put(Key key,Value value){
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if(keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

}
