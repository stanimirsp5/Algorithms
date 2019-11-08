package sorting.mergeSort;

import java.util.Arrays;
// Merge only
public class Merge {
    private int[] num1 = {1, 3, 4};
    private int[] num2 = {2,6, 7};
    private int[] aux = new int[6];

    public void merge() {
        int j = 0, k = 0;
        for (int i = 0; i < 6; i++) {
            if(num1.length == i-1){
                aux[i] = num2[k++];
            }else if(num2.length == i){
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
