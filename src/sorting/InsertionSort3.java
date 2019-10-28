package sorting;

import java.util.Arrays;

public class InsertionSort3 {

    public static void sort(Comparable[] items) throws InterruptedException {

        for (int i = 1; i < items.length; i++) { // it begins from 1 to always access next element

            for (int j = i; j > 0 && less(items[j], items[j-1]); j--) {
                exchange(items,j, j-1);
            }
        }
        show(items);
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
