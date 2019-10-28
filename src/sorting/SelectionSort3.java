package sorting;

import java.util.Arrays;

public class SelectionSort3 {

    //sort
    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(less(nums[j], nums[min])){
                    min = j;
                }
            }
            exchange(nums,i,min);
            System.out.println(Arrays.toString(nums));
        }
    }

    //less
    private boolean less(int num2,int num1){
        if(num2 < num1){
            return true;
        }
        return false;
    }
    //exchange
    private void exchange(int[] nums, int index, int minNumIndex){
        int biggerNum =nums[index];
        nums[index] =  nums[minNumIndex];
        nums[minNumIndex] =biggerNum;
    }

}
