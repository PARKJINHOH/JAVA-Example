package me.java.the;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("glidong");
        names.add("suhyung");
        names.add("jino");
        names.add("illihe");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        names.forEach(System.out::println); // 바뀌지 않는다.
        stringStream.forEach(System.out::println);

        System.out.println("================");

        // 중계형 operator(연산자)만 있으면 실행되지 않는다.
        names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        System.out.println("================");

        // 종료형 operator가 있어야 중계형 operator도 실행이 된다.
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s); // (중계형)
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);





        System.out.println("=========================");

        // 병렬 처리
        List<String> collect1 = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("=========== 심화");

        // 병렬 처리 심화
        List<String> collect2 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect2.forEach(System.out::println);
    }
}
