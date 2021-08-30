package com.nvv.itstep.lection.l5_inner_classes.blocks;

public class Alphabet {
    private char[] letters;
    private static final int NUMBER_OF_LETTERS;
    public String test = "1";

    static {
        System.out.println("static block");
        NUMBER_OF_LETTERS = 26;
    }

    {
        test = "2";
        System.out.println("block");
        letters = new char[NUMBER_OF_LETTERS];
        for (int letter = 'a', index = 0; index < NUMBER_OF_LETTERS; letter++, index++) {
            letters[index] = (char) letter;
        }
    }

    public Alphabet() {
        //test = "3";
        System.out.println("constructor");
    }
}
