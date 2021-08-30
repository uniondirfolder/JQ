package com.nvv.itstep.hw.d22082021.abstracts;


import com.nvv.itstep.hw.d22082021.game.Chip;

@Developer
public interface PlayerInterface {
    boolean setBet(Chip chip);
    boolean setBet(Chip[] chip);
    void getWinChips(Chip chip);
    void setFail(Chip chip);
    Chip autoGetBet();
    Chip getChip(long id);
    boolean ignore();
    boolean exit();
}
