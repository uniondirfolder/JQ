package com.nvv.itstep.hw.d22082021.game;


import com.nvv.itstep.hw.d22082021.abstracts.Developer;

import java.util.ArrayList;

@Developer
public final class Bet {
    private Player player;
    private ArrayList<Chip> chips = new ArrayList<>();
    private ArrayList<Card> curCards = new ArrayList<>();

    public Bet(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public ArrayList<Card> getCurCards() {
        return curCards;
    }
    public String printCards(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curCards.size(); i++) {
             sb.append(curCards.get(i).toString());
        }
        return sb.toString();
    }
}
