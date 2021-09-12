package hw.d23082021;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CustomException {

        String exs = "(1 + 2) - 3 * 4 / 5 - (6 + 7)0";
        //exs = "(1 + 2) - 3 * 4 / 5 - (6 + 7)-";
        //exs = "(1 + 2) - 3 * 4 / 5 - (6 + 7))";
       // exs = "0(1 + 2) - 3 * 4 / 5 - (6 + 7)";
        //exs = "((1 + 2) - 3 * 4 / 5 - (6 + 7)";
        //exs = "(1 + 2) - 3 * 4 / 0 - (6 + 7)";
        //exs = "(1 + 2) - -3 * 4 / 5 - (6 + 7)";
        //exs = "(1 + 2) -3 * 4 / 5 - (6 + 7)";
        //exs = "(1 + 2) +3 * 4 / 5 - (6 + 7)";
        //exs = "(1 + 2)- -3 * 0 / 5 - (6 + 7)";
        //exs = "";
        //exs = "2 + 2";
        //exs = "()()()((()))))(()";
        //  (-3) + 1 + 1
        //  1 + 1  + (-3)
        //  1 + (-3) + 1
        //  (-3.0) + 1 + 1.0
        //  1.0 + 1 + (-3.0)
        //  1.0 + (-3.0) + 1.0
        //  (1.0) + (-3.0) + (1.0)
        //  ((1.02) + (-3.03) + (1.01)) = - 0.9
        //  ((1.02) + (-3.03 + 1) * 2 + (1.01)) = -3.
        // ((1.02) + (-3.03) + (1.01)) / ((1.02) + (-3.03 + 1) * 2 + (1.01))
        // ((1.02) + ((-3.03) + 1) * 2 + (1.01))

        Scanner sc = new Scanner(System.in);
        System.out.println("for esc type exit");
        while (!exs.equals("exit")){
            System.out.println("$>");
            exs = sc.nextLine();
            Items items = new Items();
            try {
                items = items.toItems(exs);
                Item i = items.toItem();
                System.out.println(i.getItemValue());
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
}
