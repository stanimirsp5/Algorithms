package sorting.mergeSort;

import java.util.Arrays;

public class Merging {
    static int[] mergedArray = new int[6];
    static int[] arrayOne = {2,6,9};
    static int[] arrayTwo = {1,4,5};
    static int[] aux =  new int[9];
//    static int[] nums = {9,5,6,1,3,4};
//{6,4,0,89,51,3,68,7,1}

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if(hi <= lo) return;
//        int middle = nums.length /2;
        int middle = lo + (hi - lo)/2;

        sort(nums,lo,middle);
        sort(nums,middle + 1,hi);
        merge(nums,lo,middle,hi);
    }
    private static void merge(int[] a, int lo,int mid, int hi){
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
        System.out.println(Arrays.toString(a));

    }
    private static boolean less(int middArr, int minIn){
        if(middArr < minIn){
            return true;
        }
        return false;
    }
//    private static void merge(int[] nums, int lo,int middle, int hi){
////        System.out.print(Arrays.toString(nums));
////        System.out.print(" lower:" + lo);
////        System.out.print(" middle:" + middle);
////        System.out.println(" high:" + hi);
//        int minIn = lo;
//        int middArr = middle + 1;
////        int minIn = lo, middArr = mid + 1;
//
//        for (int k = lo; k <= hi ; k++) { // Copy a[lo..hi] to aux[lo..hi]
//            aux[k] = nums[k];
//        }
//
//        for (int k = lo; k <= hi ; k++) {
//            if(minIn > middle)nums[k] = aux[middArr++];
//            else if(middArr > hi) nums[k] = aux[minIn++];
//            else if(less(aux[middArr], aux[minIn])) aux[k] = aux[middArr++];
//            else nums[k] = aux[minIn++];
//        }
////     for (int k = lo; k <= hi ; k++) {
////        if(minIn > mid)a[k] = aux[middArr++];
////        else if(middArr > hi) a[k] = aux[minIn++];
////        else if(less(aux[middArr], aux[minIn])) aux[k] = aux[middArr++];
////        else a[k] = aux[minIn];
////    }
//    }

    //    private static void merge(int[] arrayOne, int[] arrayTwo){
//        int i = 0;
//        int j = 0;
//        int m = 0;
//        while(i < arrayOne.length && j < arrayTwo.length) {
//            if (arrayOne[i] < arrayTwo[j]) {
//                mergedArray[m++] = arrayOne[i++];
//                // i++;
//            } else{// if (arrayOne[i] > arrayTwo[j]) {
//                mergedArray[m++] = arrayTwo[j++];
//                //j++;
//            }
//            //m++;
//        }
//    }

}
