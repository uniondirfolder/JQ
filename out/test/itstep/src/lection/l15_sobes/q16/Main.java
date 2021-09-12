package lection.l15_sobes.q16;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(args));
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        password += "2435";
        char[] result = password.toCharArray();
        System.out.println(result);
        System.out.println(Arrays.toString(result));
        password = null;
        result[0] = '1';
        result = null;



    }
}
