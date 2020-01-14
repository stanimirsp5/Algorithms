package searching;

import java.util.HashMap;

public class BinarySearch2 {
    HashMap<Integer,Integer> nums = new HashMap<Integer,Integer>();
    public int search(int searchedNum){
        fillMap();
        int lo = 0, hi = nums.size(), indexOfSearchedNum = 0;
        while (lo <= hi){
            int mid = (lo + hi)/2;
            if(mid == searchedNum){
                indexOfSearchedNum = mid;
            }else if(mid > searchedNum){ // go left
               hi = mid -1;
            }else if(mid < searchedNum) { // go right
               lo = mid + 1;
            }
        }
//        int num = nums[indexOfSearchedNum];
        int keys = (int)nums.keySet().toArray()[indexOfSearchedNum];
        return keys;
    }

    private void fillMap(){
        nums.put(1, 546);
        nums.put(2, 5);
        nums.put(3, 46);
        nums.put(4, 9);
        nums.put(5, 0);
        nums.put(6, 8);
        nums.put(7, 78);
        nums.put(8, 4);
        nums.put(9, 18);
        // do it like array
    }

}
