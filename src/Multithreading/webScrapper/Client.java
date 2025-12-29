package Multithreading.webScrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String[] Urls = new String[1000];
        for (int i = 0; i < Urls.length; i++) {
            Urls[i] = "https://www.google.com" + (i+1);
        }

        // For Fixed thread pool
        ExecutorService executorFixed = Executors.newFixedThreadPool(10);
        long startfixed =  System.currentTimeMillis();
        List<Future<Void>> futuresFixed = new ArrayList<>();
        for (String url : Urls) {
            ScrapUrl scrapUrl = new ScrapUrl(url);
            Future<Void> future = executorFixed.submit(scrapUrl);
            futuresFixed.add(future);
        }

        for (Future<Void> future : futuresFixed) {
            future.get();
        }

        long endfixed =  System.currentTimeMillis();
        executorFixed.shutdown();

        // For Cached thread pool
        ExecutorService executorCache = Executors.newCachedThreadPool();
        long startcache = System.currentTimeMillis();
        List<Future<Void>> futuresCache = new ArrayList<>();
        for (String url : Urls) {
            ScrapUrl scrapUrl = new ScrapUrl(url);
            Future<Void> future = executorCache.submit(scrapUrl);
            futuresCache.add(future);
        }

        for (Future<Void> future : futuresCache) {
            future.get();
        }
        long endcache = System.currentTimeMillis();
        executorCache.shutdown();

        System.out.println("Fixed thread pool time :" + (endfixed-startfixed));
        System.out.println("Cache thread pool time :" + (endcache-startcache));

    }




}
