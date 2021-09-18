package lection.l21_refl_ano;

import java.security.MessageDigest;

public class Quiz {

    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }

        int a, b;
        boolean a1, b1;
        for (a = 0; a < 2; a++) {
            for (b = 0; b < 2; b++) {
                System.out.printf("%d %d  => ", a, b);
                if (a == 0) a1 = false;
                else a1 = true;
                if (b == 0) b1 = false;
                else b1 = true;

                System.out.print((a1 ^ b1) + " " + (a1 != b1) + " // ");
                System.out.print((a1 & b1) + " " + (a1 = b1) + " // ");
                System.out.print((a1 | b1) + " " + (a1 != b1) + " // ");
                System.out.println((a1 | b1) + " " + (a1 || b1));
            }
        }

        System.out.println("Таблица истинности ^");
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(false ^ false);
        System.out.println("Таблица истинности !=");
        System.out.println(true != true);
        System.out.println(true != false);
        System.out.println(false != true);
        System.out.println(false != false);

        System.out.println("-".repeat(15));

        boolean b0000 = booleanExpression(false, false, false, false);
        boolean b0001 = booleanExpression(false, false, false, true);
        boolean b0010 = booleanExpression(false, false, true, false);
        boolean b0011 = booleanExpression(false, false, true, true); //Searching for this
        System.out.println("b0000 " + b0000);
        System.out.println("b0001 " + b0001);
        System.out.println("b0010 " + b0010);
        System.out.println("b0011 " + b0011 + " <- ");

        boolean b0100 = booleanExpression(false, true, false, false);
        boolean b0101 = booleanExpression(false, true, false, true); //Searching for this
        boolean b0110 = booleanExpression(false, true, true, false); //Searching for this
        boolean b0111 = booleanExpression(false, true, true, true);
        System.out.println("b0100 " + b0100);
        System.out.println("b0101 " + b0101 + " <- ");
        System.out.println("b0110 " + b0110 + " <- ");
        System.out.println("b0111 " + b0111);

        boolean b1000 = booleanExpression(true, false, false, false);
        boolean b1001 = booleanExpression(true, false, false, true); //Searching for this
        boolean b1010 = booleanExpression(true, false, true, false); //Searching for this
        boolean b1011 = booleanExpression(true, false, true, true);
        System.out.println("b1000 " + b1000);
        System.out.println("b1001 " + b1001 + " <- ");
        System.out.println("b1010 " + b1010 + " <- ");
        System.out.println("b1011 " + b1011);

        boolean b1100 = booleanExpression(true, true, false, false); //Searching for this
        boolean b1101 = booleanExpression(true, true, false, true);
        boolean b1110 = booleanExpression(true, true, true, false);
        boolean b1111 = booleanExpression(true, true, true, true);

        System.out.println("b1100 " + b1100 + " <- ");
        System.out.println("b1101 " + b1101);
        System.out.println("b1110 " + b1110);
        System.out.println("b1111 " + b1111);

        System.out.println(leapYearCount(400));

        double m = 0x0bp3;
        System.out.println();

        System.out.println(Integer.toBinaryString(122));
        System.out.println(Integer.toBinaryString(flipBit(122,4)));
        System.out.println(charExpression(29));

        System.out.println(Integer.bitCount(Math.abs(2)));

        System.out.println('A'+"12");
        System.out.println("A"+12);
        System.out.println('A'+'1'+'2');
        System.out.println("A" + ('\t' + '\u0003'));



        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        /*
        Ваш код решения заключается в изменении того, что будете возвращать! Изменяйте возвращаемое значение
        до тех пор, пока метод выше не поздравит Вас с корректно найденным сочетанием.
        ВАЖНО!!!
        В моём примере после return - НЕПРАВИЛЬНЫЙ вариант! Ищите свой, правильный :)
        */
        return (a == b == c == d) & !(!a & !b & !c & !d) & !(a & b & c & d);
    }
    public static int leapYearCount(int year) {
        return (year/4)+(year/400)-(year/100);
    };

    public static boolean doubleExpression(double a, double b, double c) {
        return (a + b >= c - 0.0001) & (a + b <= c + 0.0001);
    }
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1)); // put your implementation here
    }

    public static char charExpression(int a) {
        return (char) ('\\'+ a);
        //return (char) (((int)'\\')+a);
    }
    public static boolean isPalindrome(String text) {
        StringBuilder sb = new StringBuilder();
        char ch = ' ';
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            if(Character.isDigit(ch) || Character.isAlphabetic(ch)){
                ch = Character.toLowerCase(ch);
                sb.append(ch);
            }
        }
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        return str1.equals(str2);
    }
}