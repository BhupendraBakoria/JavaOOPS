package Multithreading.AdderSubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Subrtactor implements Callable<Void> {
    private Value value;

    public Subrtactor(Value value) {
        this.value = value;
    }

    public Void call() throws InterruptedException, ExecutionException {
        for (int i =0; i<=100; i++) {
            value.setValue(value.getValue() - i);
        }
        return null;
    }
}
