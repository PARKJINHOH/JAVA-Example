package me.java.the;

public class SingletonSetting {

    private static SingletonSetting instance;

    private SingletonSetting() {
    }

    public static SingletonSetting getInstance() {
        if (instance == null) {
            instance = new SingletonSetting();
        }

        return instance;

    }
}
