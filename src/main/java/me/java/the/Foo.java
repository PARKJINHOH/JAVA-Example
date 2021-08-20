package me.java.the;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        // 메소드 래퍼런스
        UnaryOperator<String> hi = (s) -> "hi" + s;


        // 스태틱 메소드 참조, (타입::스태틱)
        UnaryOperator<String> hiToMethodRefer = Greeting::hi;

        // 특정 객체의 인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> helloToMethodRefer = greeting::hello;

        // 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;

        // 매개변수가 있는 생성자 참조
        // 담는 변수가 다르기 때문에 위 와는 다른 생성자를 사용.
        Function<String, Greeting> jinhoGreeting = Greeting::new;

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"3","2","4"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));


    }
}
