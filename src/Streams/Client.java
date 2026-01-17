package Streams;

import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello Streams");

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (Integer num: list) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        List<Integer> list2 = list.stream().filter(((num) -> num % 2 == 0)).collect(Collectors.toList());
        System.out.println(list2);

//        list.stream().allMatch((num) -> num % 2 == 0);
//
//        List<String> fruits = List.of("apple", "orange", "banana", "kiwi", "grape");
//        List<String> flist = fruits.stream().filter(string -> string.c);
//        System.out.println(flist);



    }
}
