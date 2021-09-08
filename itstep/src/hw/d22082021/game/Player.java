package hw.d22082021.game;


import hw.d22082021.abstracts.Developer;
import hw.d22082021.abstracts.Participant;
import hw.d22082021.abstracts.PlayerInterface;

import java.util.ArrayList;

@Developer
public class Player extends Participant implements PlayerInterface {
    private ArrayList<Chip> current;

    public Player(Wallet wallet, ArrayList<Chip> current) {
        super(wallet);
        this.current = current;
    }


    @Override
    public boolean setBet(Chip chip) {
        return false;
    }

    @Override
    public boolean setBet(Chip[] chip) {
        return false;
    }

    @Override
    public void getWinChips(Chip chip) {
        current.add(chip);
    }

    @Override
    public void setFail(Chip chip) {
        for (int i = 0; i < current.size(); i++) {
            if (chip.getId() == current.get(i).getId()) {
                current.remove(i);
                break;
            }
        }
    }

    @Override
    public Chip autoGetBet() {
        if (current.size() > 0) {
            return current.get(0);
        }
        return null;
    }

    @Override
    public Chip getChip(long id) {
        for (int i = 0; i < current.size(); i++) {
            Chip chip = current.get(i);
            if (id == chip.getId()) {
                return chip;
            }
        }
        return null;
    }

    @Override
    public boolean ignore() {
        return false;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
