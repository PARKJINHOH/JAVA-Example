package me.java.the;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        System.out.println("======함수형 인터페이스======");
        RunSomething run = new RunSomething() {
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };

        System.out.println(run.doIt(15));
        System.out.println(run.doIt(15));



        System.out.println("======함수형 인터페이스 + 람다식======");
        RunSomething run1 = (number) -> number + 10;

        System.out.println(run1.doIt(50));
        System.out.println(run1.doIt(50));


        System.out.println("======JAVA에서 기본으로 지원하는 함수 : Function<T, R>======");
        // Function<T, R> : T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(10));

        System.out.println("======JAVA에서 기본으로 지원하는 함수 : Function<T, R> + 람다======");
        Function<Integer, Integer> multi2 = (i) -> {
            return i * 2;
        };
        System.out.println(multi2.apply(50));


        System.out.println("======JAVA에서 기본으로 지원하는 함수 : Function<T, R> + 함수 조합======");
        // 1 (compose)
        // 순서) multi2 -> plus10
        Function<Integer, Integer> plus10_3 = plus10.compose(multi2);
        System.out.println(plus10_3.apply(100));

        // 2 (andThen)
        // 순서) plus10 -> multi2
        System.out.println(plus10.andThen(multi2).apply(5));


        System.out.println("======JAVA에서 기본으로 지원하는 함수 : Consumer<Integer>======");
        // Consumer<T> : T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);


        System.out.println("======JAVA에서 기본으로 지원하는 함수 : Supplier<T>======");
        // Supplier<T> : T 타입의 값을 제공하는 함수 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        System.out.println("======JAVA에서 기본으로 지원하는 함수 : Predicate<T>======");
        // Predicate<T> : T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
        Predicate<String> status = (s) -> s.startsWith("jinho");
        System.out.println(status.test("jinho"));
        System.out.println(status.test("glidong"));

        System.out.println("======JAVA에서 기본으로 지원하는 함수 : UnaryOperator<T>======");
        // UnaryOperator<T> : Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수
        //인터페이스
//        Function<Integer, Integer> plus100 = (i) -> i + 100;
        UnaryOperator<Integer> plus1000 = (i) -> i + 1000;
        System.out.println(plus1000.apply(1));

    }
}
