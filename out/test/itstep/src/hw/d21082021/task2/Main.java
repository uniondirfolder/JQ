package hw.d21082021.task2;



import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;


public class Main {
    public static void main(String[] args) {
        ArrayList<Product> arr = Go.getProducts.apply(200);
        //■ Показать все продукты;
        arr.stream().collect(groupingBy(Product::getCategory)).forEach((x, y) -> {
            System.out.println(x);
            y.forEach(z -> System.out.print(z.getName() + ' '));
            System.out.println();
        });

        //■ Показать все продукты с названием меньше пяти
        System.out.println("----------------------------");
        arr.stream()
                .filter(x -> x.name.length() < 5)
                .collect(groupingBy(Product::getCategory)).forEach((x, y) -> {
            System.out.println(x);
            y.forEach(z -> System.out.print(z.getName() + ' '));
            System.out.println();
        });
        System.out.println("----------------------------");
        //■ Посчитать сколько раз встречается продукт, чье название ввёл пользователь;
        String mach = "Num5";
        System.out.println(arr.stream().filter(x -> x.getName().equals(mach)).toArray().length);

        System.out.println("----------------------------");
        //■ Показать все продукты, которые начинаются на заданную букву;
        String userCh = "n";
        arr.stream()
                .filter(x -> {
                    byte[] ch = x.getName().toLowerCase().getBytes(StandardCharsets.UTF_8);
                    byte[] ch1 = userCh.toLowerCase().getBytes(StandardCharsets.UTF_8);
                    return ch[0] == ch1[0];
                })
                .collect(groupingBy(Product::getCategory)).forEach((x, y) -> {
            System.out.println(x);
            y.forEach(z -> System.out.print(z.getName() + ' '));
            System.out.println();
        });

        //■ Показать все продукты из категории «Молоко».
        System.out.println("----------------------------");
        arr.stream()
                .filter(x->x.getCategory().equals(Category.МОЛОКО))
                .forEach(x-> System.out.println(x));


    }

    enum Category {
        КОФЕ,
        МОЛОКО,
        ПЕЧЕНЬЕ,
        ЧАЙ

    }

    static class Product {
        private String name;
        private Category category;

        public Product(String name, Category category) {
            this.name = name;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", category=" + category +
                    '}';
        }
    }


    interface Go {
        Function<Integer, ArrayList<Product>> getProducts = integer -> {
            ArrayList<Product> p = new ArrayList<Product>();
            Category[] cat = Category.values();
            final Random r = new Random();
            for (int i = 0; i < integer; i++) {
                p.add(new Product("Num" + r.nextInt(integer), cat[r.nextInt(cat.length)]));
            }
            return p;
        };

    }
}
//Задание 2
//Для набора названий продуктов (продукты могут по- вторяться) нужно:
//■ Показать все продукты;
//■ Показать все продукты с названием меньше пяти
//символов;
//■ Посчитать сколько раз встречается продукт, чье на-
//звание ввёл пользователь;
//■ Показать все продукты, которые начинаются на за-
//данную букву;
//■ Показать все продукты из категории «Молоко».