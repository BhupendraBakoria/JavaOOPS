package Multithreading;

import java.util.concurrent.*;

public class Fibonacci implements Callable<Integer> {
    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    public int fibNumber(int n) {
        if (n <= 1) return n;

        return fibNumber(n - 1) + fibNumber(n - 2);
    }

    public Integer call() throws Exception {
        if (n<=1) return n;

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> first = executorService.submit(new Fibonacci(n-1));
        Future<Integer> second = executorService.submit(new Fibonacci(n-2));

        int x = first.get();
        int y = second.get();

        return x + y;
    }
}