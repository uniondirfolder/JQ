package hw.d22082021.game;


import hw.d22082021.abstracts.CroupierInterface;
import hw.d22082021.abstracts.Developer;

import java.util.ArrayList;
import java.util.Collections;

@Developer
public final class Croupier implements CroupierInterface<Card> {
    private ArrayList<Card> cards;

    protected Croupier() {
        cards = new ArrayList<>();
        setNewDeck();
    }


    @Override
    public Card issueCard() {
        if(cards.size()==0){
            setNewDeck();
        }
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }

    @Override
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    @Override
    public void setNewDeck() {
        if (!cards.isEmpty()) {
            cards.clear();
        }
        cards.addAll(Card.getSet());
        shuffleDeck();
    }
}
