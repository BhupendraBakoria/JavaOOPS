package Multithreading.GetAvailableCores;

import java.util.List;
import java.util.concurrent.Callable;

public class sumMultiThread implements Callable<Long> {
    List<Integer> list;
    Integer start;
    Integer end;

    public sumMultiThread(List<Integer> list, Integer start, Integer end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    public Long call() throws Exception {
        Long sum = 0L;
        for (int i = start; i < end; i++) {
            sum += list.get(i);
        }
        System.out.println("Sum of the index from start: " + start + " to end: " + (end-1) + "is" + sum +
                "calculated by: " + Thread.currentThread().getName());
        return sum;
    }


}
