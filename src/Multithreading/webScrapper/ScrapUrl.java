package Multithreading.webScrapper;

import java.util.concurrent.Callable;

public class ScrapUrl implements Callable<Void> {
    String url;

    public ScrapUrl(String url) {
        this.url = url;
    }

    public Void call() throws Exception {
        System.out.println("Scraping " + url + "by" + Thread.currentThread().getName());
        Thread.sleep(200);
        System.out.println("Scraped Url " + url + "by" + Thread.currentThread().getName());
        return null;
    }
}
