package itstep.lection.l1;

public class Main13 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 7, 7, 7};
        //System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        //itar
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        int x = 5;
        int y = 6;
        //System.out.printf("x=%d; y=%d \n", x, y);
        //System.out.println(`x={x};y={y}`);

        //arr[7] = 5;
    }
}
