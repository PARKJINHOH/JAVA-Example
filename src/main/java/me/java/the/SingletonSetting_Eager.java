package me.java.the;

public class SingletonSetting_Eager {

    private static final SingletonSetting_Eager INSTANCE = new SingletonSetting_Eager();

    private SingletonSetting_Eager() {
    }

    public static SingletonSetting_Eager getInstance() {
        return INSTANCE;
    }

}
