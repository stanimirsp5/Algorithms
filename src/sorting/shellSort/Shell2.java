package sorting.shellSort;

public class Shell2 {
    //{5,6,4,7,2,1,3,0,9};
    public void sort(Comparable[] a){
        int n = a.length;
        int h = 1;

        while(h < n/3) h = 3*h + 1;
        while(h >= 1) {
            for (int i = h; i < n; i++) {
                for (int k = i; k >= h && less(a[k], a[k - h]); k-= h) {
                    exchange(a, k, k - h);
                }
            }
            h = h/3;
        }
        show(a);
    }

    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private void exchange(Comparable[] a, int y, int z){
        Comparable t = a[y];
        a[y] = a[z];
        a[z] = t;
    }
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
