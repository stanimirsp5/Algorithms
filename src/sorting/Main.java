package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Comparable[] nums = {10,6,4,7,2,1,3,8,9};
        int[] numsNoComparable = {10,6,4,7,2,1,3,8,9};
        Comparable[] items = {"z","y","h","i","a","w"};
        int[] nums2 = {10,6,4,7,2,1,3,8,9,10,6,4,7,2,1,3,8,9};
        SelectionSort ss = new SelectionSort();
        InsertionSort is = new InsertionSort();
//        is.sort(items);

        SortCompare sortCompare = new SortCompare();
        sortCompare.timeRandomInput("Insertion", nums);
        sortCompare.timeRandomInput("Selection", nums);

    }
}
