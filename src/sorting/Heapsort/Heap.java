package sorting.Heapsort;

import java.util.Arrays;

public class Heap {
    int nums[] = new int[2];
    int numIndex = 0;

    public void insert(int newNum){
      add(newNum);
      swim(numIndex-1);
    }
    public void delMax(){
        exchange(0,nums.length-1);
        int[] yourArray = Arrays.copyOfRange(nums, 0, nums.length-1);
        sink(0);
    }
    private void swim(int k){
        int parentPosition = k/2;
        while (k > 0 && less(parentPosition, k)){
            exchange(parentPosition,k);
            k = k/2;
        }
    }
    private void sink(int k){

    }
    private boolean less(int parentPosition, int lastAddedNum){
        return nums[parentPosition] < nums[lastAddedNum];
    }
    private void exchange(int parentPosition, int lastAddedNum){
        int t = nums[parentPosition];
        nums[parentPosition] = nums[lastAddedNum];
        nums[lastAddedNum] = t;
    }
    private void add(int newNum){
        if(nums.length == numIndex){
            resizeArray(nums);
        }
        nums[numIndex] = newNum;
        numIndex++;
    }

    private void resizeArray(int[] items){
        int newLength = items.length + 1;
        int newArr[] = new int[newLength];
        for (int i = 0; i < items.length; i++) {
            newArr[i] = items[i];
        }
        nums = newArr;
    }

    public void show(){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
