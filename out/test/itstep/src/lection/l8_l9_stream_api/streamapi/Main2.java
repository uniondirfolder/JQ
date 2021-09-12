package lection.l8_l9_stream_api.streamapi;

import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getHumans();


//        final boolean allAdults = humans.stream()
//                .allMatch(human -> human.getAge() >= 18);
//        System.out.println(allAdults);

//       boolean anyMatch =  humans.stream()
//                .anyMatch(human -> human.getAge() == 18);
//        System.out.println(anyMatch);

       Human human = humans.stream()
                .min(Comparator.comparing(Human::getAge))
                .get();
        System.out.println(human);



    }
}
