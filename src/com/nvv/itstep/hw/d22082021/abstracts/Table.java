package com.nvv.itstep.hw.d22082021.abstracts;

import com.nvv.itstep.hw.d22082021.game.Casino;
import com.nvv.itstep.hw.d22082021.game.Croupier;
import com.nvv.itstep.hw.d22082021.game.Player;
import com.nvv.itstep.hw.d22082021.game.Round;
import com.nvv.itstep.hw.d22082021.pool.ProgramObject;

import java.util.ArrayList;

@Developer
public abstract class Table extends ProgramObject {
    protected final Casino casino;
    protected Croupier croupier;
    protected Round round;
    protected ArrayList<Player> players = new ArrayList<>();


    protected abstract boolean changeCroupier(Croupier croupier);
    protected abstract boolean addPlayer(Player player);
    protected abstract boolean removePlayer(Player player);
    protected abstract void newRound();

    protected Table(Croupier croupier,Casino casino) {
        this.croupier = croupier;
        this.casino = casino;
    }
}
