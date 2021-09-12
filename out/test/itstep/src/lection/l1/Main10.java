package lection.l1;

public class Main10 {
    public static void main(String[] args) {
        //тернарный оператор
        int number = 1;
//        String result;
//        if (number >= 0) {
//            result = "positive";
//        } else {
//            result = "negative";
//        }

        String result = (number >= 0) ? "positive" : returnNegative();
        System.out.println(result);

    }

    public static String returnNegative() {
        return "negative";
    }
}
