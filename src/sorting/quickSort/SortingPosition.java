package sorting.quickSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingPosition {

    public static void position(Comparable[] items){
        //{5,6,4,7,2,1,3,8,9};
        Comparable k = items[0];
        int i = 0, j = items.length; // i searches for greater than pivot, j for smaller
        while (i <= j){ // until i ang j crosses

            while(less(k, items[++i])){ // 5 < 6 true
                //if() break;
            }

            while(less(k, items[--j])){


            }
            exchange(items, i,j);

//            if(less(k, items[++i])){
//               exchange(items, i,j);
//            }
//            if(less(k, items[--j])){
//                if(){
//                    exchange();
//                }
//            }

        }
        System.out.println(Arrays.toString(items));

    }

    private static boolean less(Comparable a, Comparable b){
        // return a.compareTo(b) < 0;
       return a.compareTo(b) < 0; // a > b => 1, a = b => 0, a < b => -1
    }

    private static void exchange(Comparable[] items, int i, int j){
        Comparable t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

}
