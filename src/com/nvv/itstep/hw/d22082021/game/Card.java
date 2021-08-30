package com.nvv.itstep.hw.d22082021.game;

import com.nvv.itstep.hw.d22082021.abstracts.Developer;

import java.util.ArrayList;
@Developer
public class Card {
    public static ArrayList<Card> getSet(){
        ArrayList<Card> ac = new ArrayList<>();
        Suit[] s = Suit.values();
        Dignity[] d = Dignity.values();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < d.length; j++) {
                ac.add(new Card(s[i],d[j]));
            }

        }
        return ac;
    }
    private Suit suit;
    private Dignity dignity;
    private int point;

    public static final int MIN_VALUE_ACE = 1;
    public static final int MAX_VALUE_ACE = 11;

    public Card(Suit suit, Dignity dignity) {
        this.suit = suit;
        this.dignity = dignity;
        this.point = dignity.point;
    }

    enum Suit {
        DIAMONDS('♢'), HEARTS('♡'), CLUBS('♧'), SPADES('♤');

        Suit(char img) {
            this.img = img;
        }

        final char img;

    }

    public enum Dignity {//достоинтство
        TWO('2',2), THREE('3',3), FOUR('4',4), FIVE('5',5),
        SIX('6',6), SEVEN('7',7), EIGHT('8',8), NINE('9',9),
        TEN('1',10), JACK('J',10), QUEEN('Q',10), KING('K',10), ACE('A',11);
        final char img;
        int point;

        Dignity(char img,int point) {
            this.img = img;
            this.point = point;
        }
    }

    @Override
    public String toString() {
        return dignity.img + "" + suit.img;
    }

    public Suit getSuit() {
        return suit;
    }

    public Dignity getDignity() {
        return dignity;
    }

    public int getPoint() {
        return point;
    }
}
