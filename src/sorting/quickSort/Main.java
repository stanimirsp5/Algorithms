package sorting.quickSort;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Comparable[] nums = {5,6,4,7,2,1,3,8,9};
        int[] numsNoComparable = {10,6,4,7,2,1,3,8,9};
        int[] numsNoComparable2 = {5,6,4,7,2,1,3,8,9};
        Comparable[] items = {"z","y","h","i","a","w"};
        int[] nums2 = {10,6,4,7,2,1,3,8,9,10,6,4,7,2,1,3,8,9};

        SortingPosition sp = new SortingPosition();
        QuickSort qs = new QuickSort();
        sp.position(nums);
        //qs.sort(numsNoComparable2);
    }
}
