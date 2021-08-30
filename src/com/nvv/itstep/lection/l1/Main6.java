package com.nvv.itstep.lection.l1;

public class Main6 {
    public static void main(String[] args) {
        //цепочка операторов if-else-if
        int number = 3;
//        if (number == 1) {
//            System.out.println("one");
//        }
//        if (number == 2) {
//            System.out.println("two");
//        }
//        if (number == 3) {
//            System.out.println("three");
//        }//ctrl + /


//        if (number == 1) {
//            System.out.println("one");
//        } else if (number == 2) {
//            System.out.println("two");
//        } else if (number == 3) {
//            System.out.println("three");
//        }

        switch (number){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                //break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("Другая");
                break;
        }




    }
}
