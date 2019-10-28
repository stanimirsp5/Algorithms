package sorting.shuffle;
import java.util.Random;

public class Shuffle {
    public static void shuffle(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = randomInt(n);
            exchange(nums, i, r);
        }
        show(nums);
    }

    private static void exchange(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    private static int randomInt(int n){
        Random rnd = new Random();
        return rnd.nextInt(n);
    }

    public static void show(int[] a){
        // print the array on the single line
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
