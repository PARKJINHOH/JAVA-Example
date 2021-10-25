package me.java.the;

public class SingletonSetting_Sync {

    private static SingletonSetting_Sync instance;

    private SingletonSetting_Sync() {
    }

    public static synchronized SingletonSetting_Sync getInstance() {
        if (instance == null) {
            instance = new SingletonSetting_Sync();
        }

        return instance;
    }

}
