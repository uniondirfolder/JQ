package com.nvv.itstep.lection.l8_stream_api.maps;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> cities = new HashMap<>();
        cities.put("Киев", 2_884_000);
        cities.put("Запорожье", 746_749);
        cities.put("Днепр", 966_400);
        cities.put("Орехов", 14_500);
        cities.put("Вольнянск", 14_500);

        System.out.println(cities.get("Киев"));
        System.out.println(cities.get("Харьков"));

        for (String s : cities.keySet()) {
            System.out.println(s);
        }
        System.out.println();
        for (Integer value : cities.values()) {
            System.out.println(value);
        }
        System.out.println();
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
