package unionFind;

public class QuickFind {
    int[] nums= {0,1,2,3,4,5,6,7,8,9};

    void union(int firstNumIndex,int secondNumIndex) {
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == nums[firstNumIndex]){
               nums[i] = nums[secondNumIndex];
           }
        }
    }

    void find(int firstNumIndex,int secondNumIndex) {
       if(nums[firstNumIndex] == nums[secondNumIndex]){
           System.out.println("Connected");
       }else{
           System.out.println("Not connected");
       }
    }
}
