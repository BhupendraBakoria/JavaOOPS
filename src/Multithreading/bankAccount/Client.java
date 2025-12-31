package Multithreading.bankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable depositTask = () -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(i);
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(i);
            }
        };

        long startTime = System.currentTimeMillis();
        for (int i=0; i<5; i++) {
            executorService.submit(depositTask);
            executorService.submit(withdrawTask);
        }

        Thread.sleep(100);
        executorService.shutdown();

        long endTime = System.currentTimeMillis();

        System.out.println("Final Balance: " + account.getBalance());
        System.out.println("Total time: " + (endTime - startTime) + "ms");

    }

}
