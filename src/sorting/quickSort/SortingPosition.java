package sorting.quickSort;
import java.util.Arrays;
import java.util.Random;

public class SortingPosition {
    public void sort(Comparable[] items){
        shuffle(items);
        System.out.println(Arrays.toString(items));
        sort(items, 0, items.length-1);
        System.out.println(Arrays.toString(items));
    }

    private void sort(Comparable[] items,int lo, int hi){
        if(lo >= hi) return;
        int pivot = position(items, lo,hi);
        sort(items, lo ,pivot-1);
        sort(items, pivot +1 ,hi);
    }

    public static int position(Comparable[] items, int lo, int hi){
        Comparable k = items[lo];
        int i = lo, j = hi+1; // i searches for greater than pivot, j for smaller
        while (true){ // until i ang j crosses
            while(less(items[++i], k));
            while(less(k, items[--j]));
            if(i >= j) {
                exchange(items, lo,j);
                break;
            }
            exchange(items, i,j);
        }
        return j;
    }

    private static boolean less(Comparable a, Comparable b){
       return a.compareTo(b) < 0; // a > b => 1, a = b => 0, a < b => -1
    }

    private static void exchange(Comparable[] items, int i, int j){
        Comparable t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    private static void shuffle(Comparable[] items){
        Random rand = new Random();
        int n = items.length;
        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(n);
            exchange(items, r,i);
        }
    }

}
