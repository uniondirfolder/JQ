package lection.l10_exc_enum;

public class Main4 {
    public static void main(String[] args) {

        System.out.println(test(2));
    }

    public static int test(int value) {
        System.out.println("start");
        try {
            if (value > 0) {
                return 1;
            }
            System.out.println("try");
            System.out.println(3 / 0);
            System.out.println("here");
        } catch (Exception e) {
            System.out.println("catch");
            //System.exit(0);
        } finally {
            System.out.println("finally");
        }
        System.out.println("finish");

        return 2;
    }
}
