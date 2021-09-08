package itstep.hw.d17072021;



public class Main {
    public static void main(String[] args) {
        ArrayUser au = new ArrayUser();

        au.addFirst(new User("Jora",25));
        System.out.println(au.getFirst());

        au.addFirst(new User("Gera",21));
        System.out.println(au.get(0));

        au.addLast(new User("Anna",23));
        System.out.println(au.getLast());

        au.set(1,new User("Bob",20));
        System.out.println(au.get(1));

        System.out.println(au);
        System.out.println("Average age: " + Analytics.AverageAge(au));
    }
}
