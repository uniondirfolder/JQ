package itstep.lection.l17_threads.thread.with;

import java.util.Random;

import static itstep.lection.l17_threads.thread.with.Calc1.HEIGHT;
import static itstep.lection.l17_threads.thread.without.Calc.WIDTH;


public class Main {
    public static void main(String[] args) {
        int[][] A = new int[HEIGHT][WIDTH];
        int[][] B = new int[HEIGHT][WIDTH];
        int[][] C = new int[HEIGHT][WIDTH];
        int[][] D = new int[HEIGHT][WIDTH];
        int[][] E = new int[HEIGHT][WIDTH];
        int[][] F = new int[HEIGHT][WIDTH];
        int[][] G = new int[HEIGHT][WIDTH];
        int[][] H = new int[HEIGHT][WIDTH];
        Random random = new Random();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                A[i][j] = random.nextInt(101);
                B[i][j] = random.nextInt(101);
                C[i][j] = random.nextInt(101);
                D[i][j] = random.nextInt(101);
                E[i][j] = random.nextInt(101);
                F[i][j] = random.nextInt(101);
                G[i][j] = random.nextInt(101);
                H[i][j] = random.nextInt(101);
            }
        }
        long t1 = System.currentTimeMillis();

        Calc1 calc1 = new Calc1(A, B);
        Calc1 calc2 = new Calc1(C, D);

        Calc1 calc3 = new Calc1(E, F);
        Calc1 calc4 = new Calc1(G, H);

        Thread thread1 = new Thread(calc1);
        thread1.start();
        Thread thread2 = new Thread(calc2);
        thread2.start();

        Thread thread3 = new Thread(calc3);
        thread3.start();
        Thread thread4 = new Thread(calc4);
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calc1 calc5 = new Calc1(calc1.getResult(), calc2.getResult());
        Calc1 calc6 = new Calc1(calc3.getResult(), calc4.getResult());
        Thread thread5 = new Thread(calc5);
        thread5.start();
        Thread thread6 = new Thread(calc6);
        thread6.start();

        try {
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calc1 calc7 = new Calc1(calc5.getResult(), calc6.getResult());
        Thread thread7 = new Thread(calc7);
        thread7.start();

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        //4521
        //4421
        //4391
    }
}
