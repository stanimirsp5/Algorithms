package sorting.quickSort;

import java.util.Arrays;

public class QuickSort3 {

    public void sort(Comparable[] items){
        sort(items,0, items.length);
    }
    private void sort(Comparable[] items, int lo, int hi){
        if(hi <= lo)return;
        int v = position(items, lo,hi);
        sort(items, lo, v);
        sort(items, v+1, hi);
        System.out.println(Arrays.toString(items));
    }
    //{5,9,7,1,2,}
    private int position(Comparable[] items, int lo, int hi){
        Comparable v = items[lo];
        int i = lo, j = hi;

        while (true) {
            while (less(items[++i], v)) ;
            while (less(v, items[--j])) ;

            if(i >= j) break;

            exchange(items, i, j);

        }
        exchange(items, lo, j);
        return j;
    }

    private boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    private void exchange(Comparable[] items, int i, int j){
        Comparable t = items[i];
        items[i] = items[j];
        items[j] = t;
    }


}
