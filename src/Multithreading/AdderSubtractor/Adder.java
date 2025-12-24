package Multithreading.AdderSubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Adder implements Callable<Void> {
    private Value value;
    private ReentrantLock lock;

    public Adder(Value value, ReentrantLock lock) {
        this.value = value;
        this.lock = lock;
    }

    public Void call() throws Exception {
        for (int i=0; i<=100; i++) {
            lock.lock();
            value.setValue(value.getValue() + i);
            lock.unlock();
        }
        return null;
    }
}
