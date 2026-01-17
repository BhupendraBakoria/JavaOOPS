package Lambdas;

public class Client {
    public static void main(String[] args) {
        Test test = () -> {
            System.out.println("Hello World");
        };
        test.foo();
    }
}
