package hw.d22082021.abstracts;

import hw.d22082021.game.Wallet;
import hw.d22082021.pool.ProgramObject;

@Developer
public abstract class Participant extends ProgramObject {
    public Participant(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    public long getId(){
        return  id;
    }

    private Wallet wallet;

}
