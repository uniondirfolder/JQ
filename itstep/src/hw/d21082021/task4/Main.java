package hw.d21082021.task4;



import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ArrayList<Projector> p = Go.getGadgets.apply(25);

        p.stream().forEach(System.out::println);

        System.out.println("-----------------------");
        Firm firm = Firm.RII;
        p.stream().filter(o -> o.firm   .equals(firm)).forEach(System.out::println);

        System.out.println("-----------------------");
        int year = 2021;
        p.stream().filter(o -> o.year == year).forEach(System.out::println);

        System.out.println("-----------------------");
        float price = 16000;
        p.stream().filter(o -> o.price == price).forEach(System.out::println);

        System.out.println("-----------------------");
        p.stream().sorted((o1, o2) -> {
            if(o1.price> o2.price)
                return -1;
            return 0;
        }).forEach(System.out::println);

        System.out.println("-----------------------");
        p.stream().sorted((o1, o2) -> {
            if(o1.price> o2.price)
                return 0;
            return -1;
        }).forEach(System.out::println);

        System.out.println("-----------------------");
        p.stream().sorted((o1, o2) -> {
            if(o1.year> o2.year)
                return -1;
            return 0;
        }).forEach(System.out::println);

        System.out.println("-----------------------");
        p.stream().sorted((o1, o2) -> {
            if(o1.year> o2.year)
                return 0;
            return -1;
        }).forEach(System.out::println);
    }

    enum Firm {
        SONY,
        LG,
        APPLE,
        SAMSUNG,
        RII
    }

    static class Projector{
        private String name;
        private int year;
        private float price;
        private Firm firm;

        public Projector(String name, int year, float price, Firm firm) {
            this.name = name;
            this.year = year;
            this.price = price;
            this.firm = firm;
        }

        @Override
        public String toString() {
            return "Projector{" +
                    "name='" + name + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    ", firm=" + firm +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Projector)) return false;
            Projector projector = (Projector) o;
            return getYear() == projector.getYear() && Float.compare(projector.getPrice(), getPrice()) == 0 && getName().equals(projector.getName()) && getFirm() == projector.getFirm();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getYear(), getPrice(), getFirm());
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

        public Firm getFirm() {
            return firm;
        }

        public void setFirm(Firm firm) {
            this.firm = firm;
        }
    }

    interface Go {
        Function<Integer, ArrayList<Projector>> getGadgets = (integer) -> {
            ArrayList<Projector> u = new ArrayList<>();
            String[] names = new String[]{"Samsung", "LG", "Apple", "Nokia"};
            Firm[] firms = Firm.values();
            final Random r = new Random();
            for (int i = 0; i < integer; i++) {
                u.add(new Projector(
                                names[r.nextInt(names.length)] + r.nextInt(2000) + 1000,
                                r.nextInt(22) + 2000,
                                r.nextInt(10000) + 10000,
                                firms[r.nextInt(firms.length)]
                        )
                );
            }
            return u;
        };
    }
}
//Задание 4
//Создайте класс «Проектор». Он должен хранить информацию о названии проектора, год выпуска, цена, производитель. Нужно создать набор проекторов и выполнить следующие задачи:
//■ Показать все проекторы;
//■ Показать все проекторы одного производителя;
//■ Показать все проекторы текущего года;
//■ Показать все проекторы дороже заданной цены;
//■ Показать все проекторы, отсортированные по цене по возрастанию;
//■ Показать все проекторы, отсортированные по цене по убыванию;
//■ Показать все проекторы, отсортированные по году выпуска по возрастанию;
//■ Показать все проекторы, отсортированные по году выпуска по убыванию.
