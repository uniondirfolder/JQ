package com.nvv.itstep.lection.l8_stream_api.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        List<Human> data = DataBase.getHumans();
        //получить коллекцию имен в верхнем регистре
        List<String>namesUpperCase = data.stream()
                .map(v->v.getName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println(namesUpperCase);
        //получить возраст самого младшего разработчика
        int age = data.stream()
                .filter(human -> human.getSpeciality().equals(Speciality.DEVELOPER))
                .min(Comparator.comparing(Human::getAge))
                .map(Human::getAge)
                .get();

        System.out.println(age);

    }
}
