package sorting.Heap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Comparable[] nums = {5,9,7,1,2,4,3,8,6};
        Comparable[] shortNums = {5,9,7,1,2,};
        Comparable[] orderedNums = {0,1,2,3,4,5,6,7,8,9};
        int[] numsNoComparable = {10,6,4,7,2,1,3,8,9};
        int[] numsNoComparable2 = {5,6,4,7,2,1,3,8,9};
        Comparable[] items = {"z","y","h","i","a","w"};
        int[] nums2 = {10,6,4,7,2,1,3,8,9,10,6,4,7,2,1,3,8,9};

        //HeapPriorityQueue pq = new HeapPriorityQueue();
        PQ2 pq = new PQ2();
        //pq.insert("Z");
//        pq.insert("A");
//        pq.insert("B");
//        pq.insert("qwe");
//        pq.insert(5);
//        pq.insert(43);
//        pq.insert(1);
//        pq.insert(897);
//        pq.insert(8);

        pq.insert(-6);
        pq.insert(544);
        pq.insert(6);
        pq.insert(11);
        pq.insert(2);
        pq.insert(56);
        //pq.deleteMax();
        pq.show();

    }
}