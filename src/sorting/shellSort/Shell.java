package sorting.shellSort;

public class Shell {

    public void sort(Comparable[] a){
        int n = a.length;
        int h = 1;
                while(h < n/3) h = 3*h +1;
                while(h >= 1) {
                    for (int i = h; i < n; i++) {
                        for (int j = i; j >= h && less(a[j], a[j - h]); j--) {
                            exchange(a, j, j - h);
                        }
                    }
                     h = h/3;
                }
        show(a);
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
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
