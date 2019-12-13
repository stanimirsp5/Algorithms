package sorting.Heap;

import java.security.Key;
// PQ is maintained in a heap-ordered complete binary tree.
public class HeapPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n = 0;

    public void MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(Key v){
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = v;
        swim(n);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, n--);
        pq[n+1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j){
        //Comparable cpq = (Comparable)pq[i];
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= n){
            int j = 2*k;
            if(j < n && less(j, j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void show(){
        System.out.println(pq);
    }
}
