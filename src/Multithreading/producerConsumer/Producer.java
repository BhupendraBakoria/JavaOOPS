package Multithreading.producerConsumer;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true)  {
            try {
                producerSemaphore.acquire();
                if (store.getItems().size() < store.getMaxSize()) {
                    store.addItem(new Object());
                }
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
