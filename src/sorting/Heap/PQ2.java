package sorting.Heap;

import java.util.ArrayList;
public class PQ2 {

    private ArrayList<Integer> pq =  new ArrayList<>();;
    //private int n = pq.size()-1;

    public int getMax(){
        return pq.get(0);
    }

    public void deleteMax(){
//        int maxNum = getMax();
//        int minNum = pq.get(pq.size()-1);
        exch(0,pq.size()-1);
        pq.remove(pq.size()-1);
        sink();
    }

    public void insert(int num){
        pq.add(num);
        swim(pq.size()-1);
    }

    private void swim(int k){
        while (k > 0 && less(k/2, k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(){
        int k = 0;
        int n = pq.size()-1;
        // moving down until both children are smaller or equal
        // or until reach the bottom
        while (2*k <= n){
            int j = 2*k;
            if(j < n && less(j, j+1)) j++;
            if(!less(k,j)) break; // until both children are smaller or equal
            exch(k,j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        boolean bigger= pq.get(i) < pq.get(j);
        return bigger;
    }

    private void exch(int i, int j){
        int t = pq.get(i);
        pq.set(i,pq.get(j));
        pq.set(j,t);
    }

    public void show(){
        System.out.println(pq);
    }
}
