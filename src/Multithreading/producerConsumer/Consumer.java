package Multithreading.producerConsumer;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Store store;
    private final Semaphore consumerSemaphore;
    private final Semaphore producerSemaphore;

    public Consumer(Store store, Semaphore consumerSemaphore, Semaphore producerSemaphore) {
        this.store = store;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumerSemaphore.acquire();
                if (store.getItems().size() > 0) {
                    store.removeItem();
                }
                producerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }



}
