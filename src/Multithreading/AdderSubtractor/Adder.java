package Multithreading.AdderSubtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value) {
        this.value = value;
    }

    public Void call() throws Exception {
        for (int i=0; i<=100; i++) {
            value.setValue(value.getValue() + i);
        }
        return null;
    }
}
