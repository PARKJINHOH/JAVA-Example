package me.java.the;

public class SingletonSetting_staticInner {

    private SingletonSetting_staticInner() {
    }

    // innerClass
    private static class SettingHolder {
        private static final SingletonSetting_staticInner INSTANCE = new SingletonSetting_staticInner();
    }

    public static SingletonSetting_staticInner getInstance() {
        return SettingHolder.INSTANCE;
    }

}
