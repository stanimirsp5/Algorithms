package sorting.mergeSort;

import java.util.Arrays;

public class Mergesort2 {

    private static int[] auxiliary; // spomagatelen, pomoshten

    public static void sort(int[] nums) throws InterruptedException {
        auxiliary = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        show(nums);
    }

    public static void sort(int[] nums, int minIndex, int maxIndex){
        if(maxIndex <= minIndex) return;
        int middleOfArray = minIndex + (maxIndex - minIndex)/2;
        sort(nums, minIndex,middleOfArray);
        sort(nums, middleOfArray + 1, maxIndex);
        merge(nums, minIndex, middleOfArray, maxIndex);
    }

    public static void merge(int[] nums, int minIndex, int middleOfArray, int maxIndex){
        // Merge a[lo..mid] with a[mid+1..hi]
        int minIn = minIndex;
        int middArr = middleOfArray + 1;

        for (int k = minIndex; k <= maxIndex ; k++) { // Copy a[lo..hi] to aux[lo..hi]
            auxiliary[k] = nums[k];
        }

        for (int k = minIndex; k <= maxIndex ; k++) {
            if(minIn > middleOfArray)nums[k] = auxiliary[middArr++];
            else if(middArr > maxIndex) nums[k] = auxiliary[minIn++];
            else if(less(auxiliary[middArr], auxiliary[minIn])) auxiliary[k] = auxiliary[middArr++];
            else nums[k] = auxiliary[minIn];
        }
    }

    private static boolean less(int middArr, int minIn){
        if(middArr < minIn){
            return true;
        }
        return false;
    }

    static void show(int[] nums) throws InterruptedException {
        System.out.print("\r");
        Thread.sleep(500);
        System.out.print(Arrays.toString(nums));
    }

}
