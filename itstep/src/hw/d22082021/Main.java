package hw.d22082021;


import hw.d22082021.game.Casino;
import hw.d22082021.game.Wallet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Casino casino = new Casino(new Wallet());
        casino.runBlackJack();
    }
}