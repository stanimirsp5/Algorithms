package sorting;

public class SelectionSort {
    public static void sort(Comparable[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i; // index of min entry
            for (int j = i+1; j < n; j++) {
                if(less(nums[j], nums[min])){
                    min = j;
                }
            }
            exchange(nums,i,min);
        }
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
    public static boolean isSorted(Comparable[] a){
        // test whether array entries are in order
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
}
