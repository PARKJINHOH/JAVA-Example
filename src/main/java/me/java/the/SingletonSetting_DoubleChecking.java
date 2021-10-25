package me.java.the;

public class SingletonSetting_DoubleChecking {

    // volatile : java 변수를 Main Memory에 저장하겠다.
    private static volatile SingletonSetting_DoubleChecking instance;

    private SingletonSetting_DoubleChecking() {
    }

    public static SingletonSetting_DoubleChecking getInstance() {

        if (instance == null) { // ** checking 1
            synchronized (SingletonSetting_DoubleChecking.class) {
                if (instance == null) { // ** checking 2 -> 여기서 늦게 온 스레드가 checking 한다.
                    instance = new SingletonSetting_DoubleChecking();
                }
            }
        }

        return instance;

    }
}
