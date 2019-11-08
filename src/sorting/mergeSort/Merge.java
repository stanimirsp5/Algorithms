package sorting.mergeSort;

import java.util.Arrays;
// Merge only
public class Merge {
    private int[] num1 = {1, 3,8};
    private int[] num2 = {2,6, 7};
    private int[] aux = new int[6];

    public void merge() {
        int j = 0, k = 0, mid = 2;
        for (int i = 0; i < 6; i++) {
            if(j > mid){
                aux[i] = num2[k++];
            }else if(k > mid){
                aux[i] = num1[j++];
            }
            else if(num1[j] > num2[k]){
                aux[i] = num2[k++];
            }else if(num1[j] < num2[k]){
                aux[i] = num1[j++];
            }
        }
        System.out.println(Arrays.toString(aux));

    }
}
