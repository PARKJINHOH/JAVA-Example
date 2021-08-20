package me.java.the;

import javax.print.attribute.standard.MediaSize;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foo {
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("jpa"))
                .findFirst();
        boolean present = optional.isPresent();
        System.out.println(present);

        // 만약 찾는 값이 없으면 NoSuchElementException 발생
//        OnlineClass onlineClass = optional.get();
//        System.out.println(onlineClass.getTitle());

        // Optional - ifPresent
        // ifPresent : 값이 있으면 () 실행해라
        optional.ifPresent(onlineClass -> System.out.println(onlineClass.getTitle()));

        // orElse는 찾는게 있던 없던 createNEwClass는 실행이 된다.
        // -> orElseGet을 사용하여 있으면 실행되지 않게 만들자
        OnlineClass onlineClass = optional.orElse(createNewClass());

        OnlineClass onlineClassGet = optional.orElseGet(() -> createNewClass());


        // 만들어 줄 수 있는게 아니라면 Exception을 발생.
//        OnlineClass onlineClassThrow = optional.orElseThrow(IllegalArgumentException::new);


        // filter에 있으면 출력, 없으면 empty 출력(반환은 Optional)
        Optional<OnlineClass> onlineClassfilter = optional.filter(onlineClass1 -> !onlineClass.isClosed());

        // map
        // Optional 내부에 Optional이 들어 있을 때.
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress = progress1.orElse(Optional.empty());


    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10, "new Class", false);
    }
}
