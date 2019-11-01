package sorting.mergeSort;

public class AbstractInPlaceMerge {

    private  static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
        show(a);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1, hi);
        merge(a,lo,mid,hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi){
        // Merge a[lo..mid] with a[mid+1..hi]
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) { // Copy a[lo..hi] to aux[lo..hi]
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi ; k++) {
            if(i > mid) a[k] = aux[j++];                        // left half exhausted (take from the right)
            else if(j > hi) a[k] = aux[i++];                    // right half exhausted (take from the left)
            else if(less(aux[j], aux[i])) a[k] = aux[j++];  // current key on right less than current key on left (take from the right)
            else a[k] = aux[i++];                               // current key on right  greater than or equal to current key on left (take from the left)
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
