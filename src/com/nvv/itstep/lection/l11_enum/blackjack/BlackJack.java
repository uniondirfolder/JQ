package com.nvv.itstep.lection.l11_enum.blackjack;

public class BlackJack {
    public static void main(String[] args) {
        Card card = new Card(Card.Suit.HEARTS, Card.Dignity.TWO);
        //System.out.println(card.getDignity().point);
        System.out.println(card.getPoint());
    }
}
