package Multithreading.producerConsumer;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(10);
        Semaphore producerSemaphore = new Semaphore(10);
        Semaphore consumerSemaphore = new Semaphore(0);


        for (int i = 0; i < 100; i++ ) {
            Thread thread = new Thread(new Producer(store, producerSemaphore, consumerSemaphore));
            thread.start();
            Thread thread1 = new Thread(new Consumer(store, producerSemaphore, consumerSemaphore));
            thread1.start();
        }
    }
}
