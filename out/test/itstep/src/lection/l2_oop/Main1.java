package lection.l2_oop;

public class Main1 {
    public static void main(String[] args) {
        //различия между ссылочным типом данных и примитивом
//        int a = 1;
//        changeInt(a);
//        System.out.println(a);

//        int[] arrA = {1, 1, 1};
//        System.out.println(arrA);
//        changeArray(arrA);
//        System.out.println(Arrays.toString(arrA));

        int i = returnInt();
    }

    public static void changeInt(int b) {
        b++;
    }

    public static void changeArray(int[] arrB) {
        System.out.println(arrB);
        arrB[0] = 2;
        arrB[1] = 2;
        arrB[2] = 2;
    }

    public static int returnInt() {
        int i = 7;
        return i;
    }
}
