package com.nvv.itstep.hw.d21082021.task3;



import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        ArrayList<Gadget> g = Go.getGadgets.apply(25);

        g.stream().forEach(System.out::println);

        Color color = Color.WHITE;
        g.stream().filter(o -> o.color.equals(color)).forEach(System.out::println);

        System.out.println("-----------------------");
        int year = 2017;
        g.stream().filter(o -> o.year == year).forEach(System.out::println);

        System.out.println("-----------------------");
        float price = 19000;
        g.stream().filter(o -> o.price > price).forEach(System.out::println);

        System.out.println("-----------------------");
        Type type = Type.M2;
        g.stream().filter(o -> o.type.equals(type)).forEach(System.out::println);

        System.out.println("-----------------------");
        int year1 = 2017;
        int year2 = 2021;
        g.stream().filter(o -> o.year >= year1 && o.year <= year2).forEach(System.out::println);


    }

    static class Gadget {
        private String name;
        private int year;
        private float price;
        private Color color;
        private Type type;

        public Gadget(String name, int year, float price, Color color, Type type) {
            this.name = name;
            this.year = year;
            this.price = price;
            this.color = color;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Gadget)) return false;
            Gadget gadget = (Gadget) o;
            return getYear() == gadget.getYear() && Float.compare(gadget.getPrice(), getPrice()) == 0 && getName().equals(gadget.getName()) && getColor() == gadget.getColor() && getType() == gadget.getType();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getYear(), getPrice(), getColor(), getType());
        }

        @Override
        public String toString() {
            return "Gadget{" +
                    "name='" + name + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    ", color=" + color +
                    ", type=" + type +
                    '}';
        }
    }

    enum Type {
        M1,
        M2,
        M3,
        M4,
        M5
    }

    enum Color {
        WHITE,
        BLACK
    }

    interface Go {
        Function<Integer, ArrayList<Gadget>> getGadgets = (integer) -> {
            ArrayList<Gadget> u = new ArrayList<>();
            String[] names = new String[]{"Samsung", "LG", "Apple", "Nokia"};
            Color[] colors = Color.values();
            Type[] types = Type.values();
            final Random r = new Random();
            for (int i = 0; i < integer; i++) {
                u.add(new Gadget(
                                names[r.nextInt(names.length)] + r.nextInt(2000) + 1000,
                                r.nextInt(21) +2000,
                                r.nextInt(10000) + 10000,
                                colors[r.nextInt(colors.length)],
                                types[r.nextInt(types.length)]
                        )
                );
            }
            return u;
        };

    }
}
//Задание 3
//Создайте класс «Устройство». Он должен хранить информацию о названии устройства, год выпуска, цена, цвет, тип устройства. Нужно создать набор устройств и выполнить следующие задачи:
//■ Показать все устройства;
//■ Показать все устройства заданного цвета;
//■ Показать все устройства заданного года выпуска;
//■ Показать все устройства дороже заданной цены;
//■ Показать все устройства заданного типа;
//■ Показать все устройства, чей год выпуска находится в указанном диапазоне.