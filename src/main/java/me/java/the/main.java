package me.java.the;

public class main {
    public static void main(String[] args) {

        /**
         * 싱글톤 패턴 미적용
         */
        Setting setting1 = new Setting();
        Setting setting2 = new Setting();
        System.out.println("setting1 == setting2 : " + (setting1 == setting2));


        /**
         * 싱글톤 패턴 _ 적용
         * * 멀티스레드에서는 안전하지 않다. = 스레드 세이프하지 않다.
         */
        SingletonSetting singletonSetting1 = SingletonSetting.getInstance();
        SingletonSetting singletonSetting2 = SingletonSetting.getInstance();
        System.out.println("singletonSetting1 == singletonSetting2 : " + (singletonSetting1 == singletonSetting2));

        /**
         * 싱글톤 패턴 _ synchronized 사용.
         * * 단점으로는 동기화 작업으로, 성능이 안좋아 질 수 있다.
         */
        SingletonSetting_Sync singletonSetting_sync1 = SingletonSetting_Sync.getInstance();
        SingletonSetting_Sync singletonSetting_sync2 = SingletonSetting_Sync.getInstance();
        System.out.println("singletonSetting_sync1 == singletonSetting_sync2 : " + (singletonSetting_sync1 == singletonSetting_sync2));

        /**
         * 싱글톤 패턴 _ 이른 초기화 사용
         * 스레드 세이프하면서, 바로 초기화가 되기 때문에 성능도 괜찮다.
         * * 미리 만들기 때문에 이 자체가 단점이 될 수 있다. -> 로딩할 때 자원을 많이 소모하면서, 사용하지 않으면 쓸떼없는 자원 낭비로 이어진다.
         */
        SingletonSetting_Eager singletonSetting_eager1 = SingletonSetting_Eager.getInstance();
        SingletonSetting_Eager singletonSetting_eager2 = SingletonSetting_Eager.getInstance();
        System.out.println("singletonSetting_eager1 == singletonSetting_eager2 : " + (singletonSetting_eager1 == singletonSetting_eager2));

        /**
         * 싱글톤 패턴 _ 2중 체크 방법
         * 자원을 사용할 때, 인스턴스가 생성되어 효율적이다. 다만, 복잡하다.
         */
        SingletonSetting_DoubleChecking singletonSetting_doubleChecking1 = SingletonSetting_DoubleChecking.getInstance();
        SingletonSetting_DoubleChecking singletonSetting_doubleChecking2 = SingletonSetting_DoubleChecking.getInstance();
        System.out.println("singletonSetting_doubleChecking1 == singletonSetting_doubleChecking2 : " + (singletonSetting_doubleChecking1 == singletonSetting_doubleChecking2));

        /**
         * 싱글톤 패턴 _ static inner 클래스 사용
         */
        SingletonSetting_staticInner singletonSetting_staticInner1 = SingletonSetting_staticInner.getInstance();
        SingletonSetting_staticInner singletonSetting_staticInner2 = SingletonSetting_staticInner.getInstance();
        System.out.println("singletonSetting_staticInner1 == singletonSetting_staticInner2 : " + (singletonSetting_staticInner1 == singletonSetting_staticInner2));

    }
}
