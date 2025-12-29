/* Problem Statement
        Given an array of 1 million random numbers, divide the array into N chunks
        (N = number of available cores).
        Figure out how to find the number of available cores.



*/

package Multithreading.GetAvailableCores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int size = 1_000_000;
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(100));
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores: " + cores);

        int chunkSize =  size/cores;
        System.out.println("Chunk size: " + chunkSize);

        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Long>> futureList = new ArrayList<>();

        for (int i = 0; i < cores; i++) {
            int start = i *  chunkSize;
            int end = (i == cores - 1) ? size : (i + 1) *  chunkSize;
            futureList.add(executor.submit(new sumMultiThread(list, start, end)));

        }

        Long finalSum = 0L;
        for (Future<Long> future : futureList) {
            finalSum += future.get();
        }

        System.out.println("Final Sum: " + finalSum);
        

    }
}
