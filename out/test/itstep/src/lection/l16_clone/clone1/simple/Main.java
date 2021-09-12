package lection.l16_clone.clone1.simple;

public class Main {
    public static void main(String[] args) {
        //констуктор копирования
        User original = new User("Ivan", 18);
        System.out.println(original);
        //User original = user;
        User copy = new User(original);
        copy.setAge(33);
        copy.setLogin("Petr");

        System.out.println(original);

    }
}
