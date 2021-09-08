package itstep.lection.l17_threads.thread.with;

public class Calc1 implements Runnable {
    public static final int HEIGHT = 10_000;
    public static final int WIDTH = 2_000;
    private int[][] first;
    private int[][] second;
    private int[][] result;

    public Calc1(int[][] first, int[][] second) {
        this.first = first;
        this.second = second;
        this.result = new int[HEIGHT][WIDTH];
    }

    public int[][] getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                result[i][j] = (int) Math.pow((first[i][j] + second[i][j]), 5);
            }
        }
    }
}
