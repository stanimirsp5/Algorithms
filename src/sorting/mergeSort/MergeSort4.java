package sorting.mergeSort;

import java.util.Arrays;

public class MergeSort4 {

    public static int[] aux;

    public void sort(int[] nums){
        aux = new int[nums.length];
        sort(nums,0,nums.length-1);
        System.out.print(Arrays.toString(nums));
    }

    private void sort(int[] nums, int lo, int hi){

        if(hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        sort(nums, 0, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo,mid,hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi){
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        for (int k = lo; k <= hi; k++) {

            if(i > mid){
                nums[k] = aux[j++];
            }else if(j > hi){
                nums[k] = aux[i++];
            }
            else if(less(aux[i], aux[j])){
                // reversed merge sort
                nums[k] = aux[j++];
            }else{
                nums[k] = aux[i++];
            }

        }

    }

    private boolean less(int a, int b){
        return a < b;
    }

}
