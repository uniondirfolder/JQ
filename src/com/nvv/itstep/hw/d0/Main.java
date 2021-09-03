package com.nvv.itstep.hw.d0;

import com.nvv.itstep.hw.d0.Outer.Inner;

class Student{
    public String name;

    public Student(String name){
        this.name = name;
    }
}
public class Main {

            public static void main(String[] args) {
                int a = 45;
                int b = 15;
                Calculator.add(a, b);
                Calculator.subtract(a, b);
                Calculator.multiply(a, b);
                Calculator.divide(a, b);



                Outer outer = new Outer();
                Outer.Inner inner = outer.new Inner();
                Outer.Nested nested = new Outer.Nested();

                Student student = new Student("Амиго");
                System.out.println(student.name);
            }


    public static class Calculator {
        public static final String EQUAL = " = ";
        public static void add(int a, int b) {
            System.out.println(a + " + " + b + EQUAL + (a + b));
        }

        public static void subtract(int a, int b) {
            System.out.println(a + " - " + b + EQUAL + (a - b));
        }

        public static void multiply(int a, int b) {
            System.out.println(a + " * " + b + EQUAL + (a * b));
        }

        public static void divide(int a, int b) {
            System.out.println(a + " / " + b + EQUAL + (a / b));
        }
    }


}
