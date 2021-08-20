package me.java.the;

import java.util.*;
import java.util.function.*;

public class Foo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("glidong");
        names.add("suhyung");
        names.add("jino");
        names.add("illihe");

        // 출력 1번째(forEach)
        System.out.println("==========1");
        names.forEach((s) -> {
            System.out.println(s);
        });
        // 출력 2번째(forEach 간결)
        System.out.println("==========2");
        names.forEach(System.out::println);

        // 출력 3번째 (Spliterator)
        System.out.println("==========3");
        Spliterator<String> spliterator = names.spliterator();
        while ( spliterator.tryAdvance(System.out::println));

        // 출력 4번째 (removeIf)
        System.out.println("==========4");
        names.removeIf(s -> s.startsWith("j"));
        names.forEach(System.out::println);

        // 출력 5번째 (Comparator)
        System.out.println("==========5");
        names.sort(String::compareToIgnoreCase);
        names.forEach(System.out::println);



        // static 메소드 및 default 메소드는 Notion 참조
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());




    }
}
