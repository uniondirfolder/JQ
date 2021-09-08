package itstep.lection.l17_threads.thread.without;

import java.util.Random;

import static itstep.lection.l17_threads.thread.without.Calc.HEIGHT;
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

        Calc calc1 = new Calc(A, B);
        Calc calc2 = new Calc(C, D);
        Calc calc3 = new Calc(E, F);
        Calc calc4 = new Calc(G, H);
        calc1.calc();
        calc2.calc();
        calc3.calc();
        calc4.calc();

        Calc calc5 = new Calc(calc1.getResult(), calc2.getResult());
        Calc calc6 = new Calc(calc3.getResult(), calc4.getResult());
        calc5.calc();
        calc6.calc();

        Calc calc7 = new Calc(calc5.getResult(), calc6.getResult());
        calc7.calc();

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        //10074
        //9445
        //9233

    }
}
