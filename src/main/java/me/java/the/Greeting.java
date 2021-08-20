package me.java.the;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "Hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }


}
