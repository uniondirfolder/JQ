package lection.l15_sobes.q8;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];

        try {
            System.out.println(arr[7]);
        } finally{
            return;
        }
    }
}
