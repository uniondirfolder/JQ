package lection.l16_clone.clone2.simple;

public class Main {
    public static void main(String[] args) {
        //метод clone
        User original = new User("Ivan", 18);
        System.out.println(original);

        try {
            User copy = original.clone();
            copy.setAge(33);
            copy.setLogin("Petr");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(original);

    }
}
