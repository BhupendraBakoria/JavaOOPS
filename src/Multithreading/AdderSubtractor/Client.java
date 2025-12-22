package Multithreading.AdderSubtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();
        Adder adder = new Adder(value);
        Subrtactor subrtactor = new Subrtactor(value);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<Void> futureAdder = executor.submit(adder);
        Future<Void> futureSubtractor = executor.submit(subrtactor);

        futureAdder.get();
        futureSubtractor.get();

        System.out.println("Final value: " + value.getValue());
    }
}
