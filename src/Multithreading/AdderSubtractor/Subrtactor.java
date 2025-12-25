package Multithreading.AdderSubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

public class Subrtactor implements Callable<Void> {
    private final Value value;
    private ReentrantLock lock;

    public Subrtactor(Value value, ReentrantLock lock) {
        this.value = value;
        this.lock = lock;
    }

    public Void call() throws Exception {
        for (int i =0; i<=100; i++) {
            synchronized (value) {
                value.setValue(value.getValue() - i);
            }
        }
        return null;
    }
}
