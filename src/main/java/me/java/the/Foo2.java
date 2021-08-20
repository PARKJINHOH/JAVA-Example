package me.java.the;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foo2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring JPA", true));
        springClasses.add(new OnlineClass(3, "spring Framework", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api", false));

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        System.out.println("close 되지 않은 수정");
        springClasses.stream()
//                .filter(oc -> !oc.isClosed()) // 아래와 동일
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));


        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(oc -> oc.getTitle())
                .forEach(System.out::println);



        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "JAVA, TEST", true));
        javaClasses.add(new OnlineClass(7, "JAVA, CORE", false));
        javaClasses.add(new OnlineClass(8, "JAVA, 8 To 11", true));

        List<List<OnlineClass>> events = new ArrayList<>();
        events.add(springClasses);
        events.add(javaClasses);

        System.out.println("두 수업 목록에 있는 모든 수업 아이디 출력");
        // List를 풀어서 나열할 수 있다.
        events.stream()
//                .flatMap(list -> list.stream())
                .flatMap(Collection::stream)
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));


        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 뺴고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);


        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(onlineClass -> onlineClass.getTitle().contains("TEST"));
        System.out.println(test);


        System.out.println("스프링 수업 제목 중에 spring이 있는 것만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().contains("spring"))
                .map(onlineClass -> onlineClass.getTitle())
                .collect(Collectors.toList());
        spring.forEach(System.out::println);
    }
}
