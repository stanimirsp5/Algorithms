package searching;

import java.util.Arrays;

public class BinarySearch <Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int n;

    public BinarySearch(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size(){
        return n;
    }
    public Value get(Key key){
        //if(isEmpty()) return null;
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0){ System.out.println(vals[i]); return vals[i];}
        else{  System.out.println("null"); return null;}
    }
    // returns the number of keys smaller than given key.
    // for get(), the rank tells us precisely where the key is to be found, if it is in the table
    // for put(), the rank tells us where to update the value when the key is in the table and where to put it when the key is not in the table
    // move all larger keys one position to make room(working from back to front) and insert the given key and value into the proper position iin their respective arrays
    public int rank(Key key){
        int lo = 0, hi = n-1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) {
                hi = mid - 1;
            } else if(cmp > 0){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    public void put(Key key, Value val){
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        for (int j = n; j > i ; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    public void show(){
        System.out.println(Arrays.toString(keys));
    }
}
