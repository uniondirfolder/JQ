package itstep.hw.d29082021;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//#2 При старте приложения запускаются три потока(помимо главного).
//        Первый поток заполняет массив случайными числами.
//        Два других потока ожидают заполнения.
//        Когда массив заполнен - остальные два потока запускаются.
//        Второй находит среднее арифметическое из этого массива,
//        третий поток находит минимальное число.
//        Эти значения необходимо отобразить в главном потоке.

        AccountsClerk clerkRnd = new AccountsClerk(new Random(), 25);

        ClerkResult resultRnd = new ClerkResult(clerkRnd);
        resultRnd.start();

        try {
            resultRnd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(clerkRnd.getArray() + " = " + "average : " + resultRnd.getAverage() + " sum :" + resultRnd.getSum() + " min :" + resultRnd.getMin() + " max :" + resultRnd.getMax());
        clerkRnd.getLogBuffer().stream().sorted().forEach(System.out::println);

        // #1 Засинхронизировать работу счетчика в двух потоках(synchornysed)
        Count count = new Count();

        new Thread(()->{
            int i=25;
            while (--i > 0){
                count.increment();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            int i=25;
            while (--i > 0){
                count.decrement();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

// #1 Засинхронизировать работу счетчика в двух потоках(synchornysed)
    static class Count {
        private int value;

        public synchronized void increment() {
            this.value++;
            System.out.println(Thread.currentThread().getId() + " ++ " + value);
        }

        public synchronized void decrement() {
            this.value--;
            System.out.println(Thread.currentThread().getId()+ " -- " + value);
        }

        public synchronized int get() {
            return value;
        }
    }
}
