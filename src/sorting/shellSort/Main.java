package sorting.shellSort;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Comparable[] nums = {5,6,4,7,2,1,3,0,9};
        int[] numsNoComparable = {5,6,4,7,2,1,3,0,9};
        Comparable[] items = {"z","y","h","i","a","w"};
        int[] nums2 = {10,6,4,7,2,1,3,8,9,10,6,4,7,2,1,3,8,9};
        Shell shell = new Shell();
        Shell2 shell2 = new Shell2();
        Shell3 shell3 = new Shell3();
        shell3.sort(numsNoComparable);

    }
}
