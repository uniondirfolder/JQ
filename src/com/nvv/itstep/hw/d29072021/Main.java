package com.nvv.itstep.hw.d29072021;

public class Main {

    public static void main(String[] args) {
        // Добавить интерфейс MyList.
        //    ArrayUser должен реализовать этот интерфейс
        MyList<User> arrayUserA = new Array<>();

        arrayUserA.add(new User(12, "Bob"));
        arrayUserA.add(new User(24, "Mike"));
        arrayUserA.add(new User(33, "Lisa"));
        arrayUserA.add(new User(18, "Anna"));
        arrayUserA.add(new User(19, "Sam"));
        arrayUserA.add(new User(75, "Djo"));
        arrayUserA.add(0, new User(11, "Djo To index 0"));
        arrayUserA.add(arrayUserA.count()-1, new User(11, "Djo To index" + (arrayUserA.count()-1)));
        arrayUserA.add(arrayUserA.count() / 2, new User(11, "Djo To middle index" + arrayUserA.count() / 2));
        arrayUserA.remove(0);

        // ArrayUser доработать, чтоб можно было с ним работать в цикле foreach
        for (User user: arrayUserA) {
            System.out.println(user);
        }

        MyList arrayUserB = new Array();

        arrayUserB.add(new User(33, "Lisa"));
        arrayUserB.add(new User(18, "Anna"));
        arrayUserB.add(new User(3, "Lisa"));
        arrayUserB.add(new User(88, "Anna"));

        System.out.println(arrayUserA.contain(new User(12,"Bob")));

        System.out.println("Contains test ->");
        MyList<User> temp = arrayUserA.contains(arrayUserB);

        for (User user: temp) {
            System.out.println(user);
        }

        System.out.println(arrayUserA.freeCell());
        System.out.println(arrayUserA.size());
        System.out.println(arrayUserA.count());
    }

}
