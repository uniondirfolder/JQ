package com.nvv.itstep.lection.l11_enum.blackjack;

public class Card {
    private Suit suit;
    private Dignity dignity;
    private int point;

    private static final int MIN_VALUE_ACE = 1;
    private static final int MAX_VALUE_ACE = 11;

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

    enum Dignity {//достоинтство
        TWO('2',2), THREE('3',3), FOUR('4',4), FIVE('5',5);
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
