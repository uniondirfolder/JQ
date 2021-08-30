package com.nvv.itstep.hw.d21082021.task1;

import com.nvv.itstep.hw.d01082021.Developer;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Developer
public class Main {
    public static void main(String[] args) {
        Integer[] intArr = Go.getRandomArray.apply(1000);
intArr[0] = -141;
        System.out.println("Количество положительных : " + Go.getCountPositive.apply(intArr));
        System.out.println("Количество отрицательных : " + Go.getCountNegative.apply(intArr));
        System.out.println("Количество двухзначных : " + Go.getCountTwoDigit.apply(intArr));
        System.out.println("Количествозеркальныхчисел.Например,121или4224. : " + Go.getCountMirrorDigit.apply(intArr));

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("Positive:", Arrays.stream(intArr).filter(x -> Go.isPositive.apply(x)).toList());
        map.put("Negative:", Arrays.stream(intArr).filter(x -> Go.isNegative.apply(x)).toList());
        map.put("Two-digit:", Arrays.stream(intArr).filter(x -> Go.isTwoDigit.apply(x)).toList());
        map.put("Mirror:", Arrays.stream(intArr).filter(x -> Go.isMirror.apply(x)).toList());
        map.forEach((x, y) -> {
            System.out.println(x);
            y.forEach(z -> System.out.print(z.toString() + ' '));
            System.out.println();
        });


    }

    interface Go {
        Function<Integer, Boolean> isPositive = integer -> {
            return integer > 0;
        };
        Function<Integer, Boolean> isNegative = integer -> {
            return integer < 0;
        };
        Function<Integer, Boolean> isMirror = integer -> {
            if (Go.isTwoDigit.apply(integer) || Go.isOven.apply(integer)) return false;
            int t = integer;
            if (t < 0) t *= -1;
            byte[] bArr = Integer.toString(t).getBytes(StandardCharsets.UTF_8);
            int start = -1, end = bArr.length;
            while (++start < --end) {
                if (bArr[start] != bArr[end]) return false;
            }
            return true;
        };
        Function<Integer, Boolean> isOven = integer -> {
            return integer >= -9 && integer <= 9;
        };
        Function<Integer, Boolean> isTwoDigit = integer -> {
            if (isOven.apply(integer)) return false;
            return ((integer.intValue() < 0 && integer.intValue() + 100 > 0) || (integer.intValue() > 0 && integer.intValue() - 100 < 0));
        };
        Function<Integer, Integer[]> getRandomArray = integer -> {
            final Random r = new Random();
            Integer[] intArr = new Integer[integer];
            for (int i = 0; i < intArr.length; i++) {
                intArr[i] = r.nextInt(10000) - 1000;
            }
            return intArr;
        };
        Function<Integer[], Integer> getCountPositive = array -> {
            return Arrays.stream(array).filter(x -> isPositive.apply(x)).toArray().length;
        };
        Function<Integer[], Integer> getCountNegative = array -> {
            return Arrays.stream(array).filter(x -> isNegative.apply(x)).toArray().length;
        };
        Function<Integer[], Integer> getCountTwoDigit = array -> {
            return Arrays.stream(array).filter(x -> isTwoDigit.apply(x)).toArray().length;
        };
        Function<Integer[], Integer> getCountMirrorDigit = array -> {
            return Arrays.stream(array).filter(x -> isMirror.apply(x)).toArray().length;
        };
    }
}
// Задание 1
//Для набора случайно сгенерированных целых чисел нужно:
//■ Количество положительных;
//■ Количество отрицательных;
//■ Количество двухзначных;
//■ Количествозеркальныхчисел.Например,121или4224.