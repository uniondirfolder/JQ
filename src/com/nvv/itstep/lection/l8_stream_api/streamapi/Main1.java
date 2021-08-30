package com.nvv.itstep.lection.l8_stream_api.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getHumans();
        //императивный vs декларативный

//        List<Human> developers = new ArrayList<>();
//        for (Human human : humans) {
//            if (human.getSpeciality().equals(Speciality.DEVELOPER)) {
//                developers.add(human);
//            }
//        }
//        for (Human developer : developers) {
//            System.out.println(developer);
//        }

//        List<Human>developers = humans.stream()
//                .filter((human -> human.getSpeciality().equals(Speciality.DEVELOPER)))
//                .collect(Collectors.toList());

        List<Human>developers = humans.stream()
                .filter((human -> human.getSpeciality().equals(Speciality.DEVELOPER)))
                .sorted(Comparator.comparing(Human::getName).reversed())
                .collect(Collectors.toList());
        developers.forEach(System.out::println);
    }
}
