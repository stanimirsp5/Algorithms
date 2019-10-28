package sorting;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class SortCompare {
    public static double time(String alg, Comparable[] a){
        ZonedDateTime now = ZonedDateTime.now();
        long seconds = now.until(ZonedDateTime.now(), ChronoUnit.SECONDS);

        if(alg.equals("Insertion")) InsertionSort.sort(a);
        if(alg.equals("Selection")) SelectionSort.sort(a);
        System.out.println("test " + seconds);
        return seconds;
    }

    public void timeRandomInput(String alg, Comparable[] items){
        int numTries = 10000000;
        long begTime = System.currentTimeMillis();
        for (int i = 0; i < numTries; ++i) {
            //is2.sort(nums); // 62ms
            //is.sort(nums); //160ms
            if(alg.equals("Insertion")) InsertionSort.sort(items);
            if(alg.equals("Selection")) SelectionSort.sort(items);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Total time for %10d tries: %d ms\n", numTries, (endTime-begTime));
    }

}
