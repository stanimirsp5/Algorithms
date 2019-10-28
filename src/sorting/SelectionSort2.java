package sorting;

import java.util.Arrays;

public class SelectionSort2 {

    public void sort(int[] nums) throws InterruptedException {
        // {3,2,1,5,4}
        for (int i = 0; i < nums.length; i++) {
            int min = i; // min entry
            for (int j = i + 1; j < nums.length; j++) {
                // if num2 is smaller than num1,  exchange num1 with num2
                if(less(nums[j], nums[min])){
                    min = j;
                }
            }
            exchange(min, nums, i);
            Thread.sleep(500);
            System.out.print("\r");
            System.out.print(Arrays.toString(nums));
        }
    }

    private boolean less(int num2, int num1){
        if(num2 < num1){
            return true;
        }
        return false;
    }

    private void exchange(int smallestNumberIndex, int[] allNums, int indexToPlace){
        int numToReplace = allNums[indexToPlace];
        int smallestNumber = allNums[smallestNumberIndex];
        allNums[indexToPlace] = smallestNumber;
        allNums[smallestNumberIndex] = numToReplace;
    }

}
