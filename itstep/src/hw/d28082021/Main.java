package hw.d28082021;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String letter = "П";
        byte[] bytes = letter.getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(Byte.toUnsignedInt(bytes[0]));
        System.out.println(Byte.toUnsignedInt(bytes[1]));

        int[] arr = {208, 159};//есть массив из двух byte(unsigned)
//нужно проебразовать их в символ Unicode - "П"
        //https://docs.oracle.com/javase/tutorial/i18n/text/string.html
        try {
            char result = new String(new byte[]{(byte)arr[0],(byte)arr[1]},"UTF8").charAt(0);
            System.out.println(result);
            System.out.println(Character.isUnicodeIdentifierPart(result));
            System.out.println(Character.UnicodeBlock.of(result));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
