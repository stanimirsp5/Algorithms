package sorting.quickSort;

import sorting.shuffle.Shuffle;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] a){
        //Shuffle.shuffle(a);
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a, int lo, int hi){
        if(hi <= lo)return;
        int j = partition(a, lo, hi); // sort the array by using the partition()
        sort(a, lo, j-1);       // Sort left part
        sort(a, j + 1, hi);     // Sort right part
    }

    private static int partition(int[]a, int lo, int hi){ // Partition into a[lo..j-1], a[j], a[j + 1..hi] and return j
        int i = lo, j = hi + 1; // left and right scan indices
        int v = a[lo];
        while(true){ // exits when i and j cross
            while(less(a[++i], v)){
                if( i == hi){
                    break;
                }
            }
            while(less(v, a[--j])){
                if(j == lo){
                    break;
                }
            }
            if( i >= j){
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    public static boolean less(int a, int b){
        return a < b;
    }

    private static void exchange(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
//        int t = i;
//        a[i] = a[j];
//        a[j] = a[t];

//        Comparable t = a[i];
//        a[i] = a[j];
//        a[j] = t;
    }

}
