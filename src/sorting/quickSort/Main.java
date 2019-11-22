package sorting.quickSort;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Comparable[] nums = {5,6,4,7,2,1,3,8,9};
        int[] numsNoComparable = {10,6,4,7,2,1,3,8,9};
        int[] numsNoComparable2 = {5,9,0,6,1,3};
        Comparable[] items = {"z","y","h","i","a","w"};
        int[] nums2 = {10,6,4,7,2,1,3,8,9,10,6,4,7,2,1,3,8,9};

        SortingPosition sp = new SortingPosition();
        sp.position(nums);
        QuickSort qs = new QuickSort();
        //qs.sort(numsNoComparable2);
    }
}
