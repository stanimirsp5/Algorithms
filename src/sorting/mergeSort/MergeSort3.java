package sorting.mergeSort;

//import org.jetbrains.annotations.Contract;

import java.util.Arrays;

public class MergeSort3 {

    private static int[] aux;

    public static void sort(int[] nums) throws InterruptedException {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        show(nums);
    }

    public static void sort(int[] nums,int lo,int hi){

        if(hi <= lo)return;

        int mid = lo + (hi - lo)/2;

        sort(nums, 0, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }
//    {6,4,8,0,9,5,7,1};
    public static void merge(int[] a, int lo, int mid, int hi){
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi ; k++) {
            // handle ArrayIndexOutOfBoundsException
            if(i > mid){  //last element
                a[k] = aux[j++];
            }
            else if(j > hi){
                a[k] = aux[i++];
            }
            else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

    //@Contract(pure = true)
    private static boolean less(int a, int b){
        return a < b;
    }
    static void show(int[] nums) throws InterruptedException {
        System.out.print("\r");
        Thread.sleep(500);
        System.out.print(Arrays.toString(nums));
    }
}

















