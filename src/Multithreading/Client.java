package Multithreading;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class Client {
    public static void main(String[] args) throws Exception {
        Fibonacci fibNumber = new Fibonacci(10);
        System.out.println(fibNumber.call());
    }

}
