package sorting.Heapsort;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Comparable[] nums = {5,9,7,1,2,4,3,8,6};
        Comparable[] shortNums = {5,9,7,1,2,};
        Comparable[] orderedNums = {0,1,2,3,4,5,6,7,8,9};
        int[] numsNoComparable = {10,6,4,7,2,1,3,8,9};
        int[] numsNoComparable2 = {5,6,4,7,2,1,3,8,9};
        Comparable[] items = {"z","y","h","i","a","w"};
        int[] nums2 = {10,6,4,7,2,1,3,8,9,10,6,4,7,2,1,3,8,9};

        Heapsort hs = new Heapsort();
        //hs.sort(nums);
        Heap hp = new Heap();
        hp.insert(-6);
        hp.insert(544);
        hp.insert(6);
        hp.insert(11);
        hp.insert(2);
        hp.insert(56);
        hp.delMax();
        hp.show();
    }
}