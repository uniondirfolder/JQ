package lection.l16_clone.clone2.deep;

public class Main {
    public static void main(String[] args) {
        //метод clone
        Address address = new Address("Lenina", "102a");
        User original = new User("Ivan", 18, address);
        System.out.println(original);

        try {
            User copy = original.clone();
            copy.setAge(33);
            copy.setLogin("Petr");
            copy.getAddress().setHomeNumber("333");
            System.out.println(copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        System.out.println(original);

    }
}
