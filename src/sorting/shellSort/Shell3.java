package sorting.shellSort;

import java.util.Arrays;

public class Shell3 {
    // 5,6,4,7,2,1,3,0,9
    public void sort(int[] nums) throws InterruptedException {
        int n = nums.length;
        int h = 1;
        while(h < n/3) h = h*3+1;
        while(h >=1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j-=h) {
                    exchange(nums, j, j - h);
                }
            }
            h = h/3;
        }
        show(nums);
    }

    public boolean less(int a, int b){
       if(a < b){
           return true;
       }
       return false;
    }

    public void exchange(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public void show(int[] nums) throws InterruptedException {
        System.out.print("\r");
        Thread.sleep(500);
        System.out.print(Arrays.toString(nums));

    }

}
