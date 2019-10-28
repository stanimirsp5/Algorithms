package sorting;

import java.util.Arrays;

public class InsertionSort2 {

    public void sort(int[] nums) throws InterruptedException {

        for (int i = 1; i < nums.length; i++) {
            int lastI = i-1;
            int curI = i;
            while (less(nums[curI], nums[lastI])){

                exchange(nums,curI,lastI);
                lastI--;
                curI--;
                if(lastI == -1 || curI == -1){
                    break;
                }
                //show(nums);
            }

        }

    }

    void exchange(int[] nums, int index2, int index1){
       int prevNum =  nums[index1];
       int curNum =  nums[index2];
        nums[index1] = curNum;
        nums[index2] = prevNum;
    }

    private boolean less(int curNum,int prevNum){
        if(prevNum > curNum){
            return true;
        }
        return false;
    }

    void show(int[] nums) throws InterruptedException {
        System.out.print("\r");
        Thread.sleep(500);
        System.out.print(Arrays.toString(nums));
    }

}
