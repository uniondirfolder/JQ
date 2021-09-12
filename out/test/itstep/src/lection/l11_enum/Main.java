package lection.l11_enum;

public class Main {
    public static void main(String[] args) {
        try {
            testException(-3);
        } catch (MyNumberException e) {
            e.printStackTrace();
        }

        try {
            testException(3);
        } catch (MyNumberException e) {
            e.printStackTrace();
        }

//        String s = null;//каким-то образом получаем строку
////        if (s != null) {
////            System.out.println(s.toUpperCase());
////        }
//
//
//        try {
//            System.out.println(s.toUpperCase());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("finish");
    }

    public static void testException(int value) throws MyNumberException {

        if (value > 0) {
            System.out.println("ok");
        } else {
//            try {
//                throw new MyNumberException("Число должно быть положительным");
//            } catch (MyNumberException e) {
//                e.printStackTrace();
//            }
            throw new MyNumberException("Число должно быть положительным");
        }

    }
}
