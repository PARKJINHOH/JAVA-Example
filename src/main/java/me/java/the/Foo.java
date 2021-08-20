package me.java.the;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        // 람다 표현식 1
        Supplier<Integer> get10 = () -> 10;

        // 람다 표현식 2
        Supplier<Integer> get20 = () -> {
            return 20;
        };

        // 람다 표현식 3 ( 매개변수 )
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        // 람다 표현식 3 ( 매개변수, 타입 생략 가능 )
        BinaryOperator<Integer> sum2 = (Integer a, Integer b) -> a + b;

        // 변수 캡처 (Variable Capture)
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 15;
        IntConsumer printInt = (i) -> System.out.println(i);
        printInt.accept(baseNumber);
    }
}
