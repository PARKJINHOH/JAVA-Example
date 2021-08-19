package me.java.the;

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
    }
}
