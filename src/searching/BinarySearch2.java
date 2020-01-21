package searching;

import java.util.HashMap;

public class BinarySearch2 {
    HashMap<Integer,Integer> nums = new HashMap<Integer,Integer>();
//    int[] numsArr = new int[]{546,5,46,9,0,8,78,4,18};
    int[] numsArr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

    int n = numsArr.length -1; // collection size

    public void get(int searchedNum){
        fillMap();
        //int index = search(searchedNum);
        int index = get(searchedNum, 0, n-1,(n-1)/2);
        if(index >= 0) {
            System.out.println("search hit: " + numsArr[index]);
        }else{
            System.out.println("search miss, no such number: " + searchedNum);
        }
    }

    private int search(int searchedNum){
        int lo = 0, hi = n, indexOfSearchedNum = 0;
        while (lo <= hi){
            int mid = (lo + hi)/2;
            if(numsArr[mid] == searchedNum){
                return mid;
            }else if(numsArr[mid] > searchedNum){ // go left
               hi = mid -1;
            }else if(numsArr[mid] < searchedNum) { // go right
               lo = mid + 1;
            }
        }
        return -1;
    }

    private int get(int searchedNum, int lo, int hi, int mid){
        if(lo > hi){
            return -1;
        }
        int indexOfSearchedNum = 0;
        if(numsArr[mid] == searchedNum){
           return mid;
        }else if(numsArr[mid] > searchedNum){ // go left
            hi = mid -1;
        }else if(numsArr[mid] < searchedNum) { // go right
            lo = mid + 1;
        }
       return get(searchedNum, lo, hi, (lo + hi)/2);
        //return indexOfSearchedNum;
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
