package sorting.mergeSort;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] numsArr = {6,4,0,89,51,3,68,7,1};
        Comparable[] nums = {10,6,4,7,2,1,3,8,9};
        Merging merging = new Merging();
        merging.sort(numsArr);
        AbstractInPlaceMerge abstractInPlaceMerge = new AbstractInPlaceMerge();
        //abstractInPlaceMerge.sort(nums);
        Mergesort2 ms2 = new Mergesort2();
        //ms2.sort(numsArr);

    }
}
