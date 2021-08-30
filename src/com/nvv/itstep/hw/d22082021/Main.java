package com.nvv.itstep.hw.d22082021;


import com.nvv.itstep.hw.d22082021.game.Casino;
import com.nvv.itstep.hw.d22082021.game.Wallet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Casino casino = new Casino(new Wallet());
        casino.runBlackJack();
    }
}
