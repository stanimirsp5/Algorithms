package sorting;

public class InsertionSort {

    public static void sort(Comparable[] a){
        int n = a.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exchange(a,j,j-1);
            }
        }
        //show(a);
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exchange(Comparable[] a, int i ,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a){
        // print the array on the single line
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
