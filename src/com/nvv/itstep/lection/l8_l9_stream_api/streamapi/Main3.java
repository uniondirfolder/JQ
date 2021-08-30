package com.nvv.itstep.lection.l8_l9_stream_api.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        List<Human> data = DataBase.getHumans();
        //сгруппировать людей по специальностям
        //в разные коллекции
        //заранее не знаем сколько у нас специальностей
        //хранить в map(ключ-специальность, значение-список из human)

        //печать всех групп

        Map<Speciality, List<Human>> specialityListMap =
                data.stream().collect(Collectors.groupingBy(Human::getSpeciality));

        specialityListMap.forEach(((speciality, humans) ->{
            System.out.println(speciality);
            humans.forEach(System.out::println);
            System.out.println();
        } ));
    }
}
