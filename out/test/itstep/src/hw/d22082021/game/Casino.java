package hw.d22082021.game;





import hw.d22082021.abstracts.*;
import hw.d22082021.enums.Banknotes;
import hw.d22082021.enums.ChipEnum;
import hw.d22082021.pool.PoolObjects;
import hw.d22082021.tables.BlackJackTable;

import java.util.ArrayList;
@Developer
public final class Casino extends Participant implements CasinoInterface, Universal {
    private final PoolObjects issuedChips = new PoolObjects();
    private final ArrayList<Table> tables = new ArrayList<>();
    public Casino(Wallet wallet) {
        super(wallet);
    }


    @Override
    public Chip[] getChips(Banknotes[] banknotes) {
        int count = 0;
        for (int i = 0; i < banknotes.length; i++) {
            count += banknotes[i].val;
            super.getWallet().debit(banknotes[i]);
        }
        Chip[] chips = new Chip[count];
        for (int i = 0; i < chips.length; i++) {
            chips[i] = new Chip(ChipEnum.GREEN);
            issuedChips.add(chips[i]);
        }
        return chips;
    }

    @Override
    public Banknotes[] getWin(Chip[] chips) {
        boolean checkChip = true;
        for (int i = 0; i < chips.length; i++) {
            Object obj = issuedChips.get(chips[i].getId());
            if (obj == null) {
                checkChip = false;
                break;
            }
        }
        if (checkChip) {
            int count = 0;
            for (int i = 0; i < chips.length; i++) {
                count += chips[i].property.val;
            }
            return super.getWallet().credit(count, Banknotes.GREEN);
        }
        return null;
    }

    @Override
    public void runBlackJack() {
        tables.add(new BlackJackTable(new Croupier(), this));
        BlackJackTable t = (BlackJackTable) tables.get(0);
        t.runTestMode();
    }

    @Override
    public Chip getNewChip(Chip chip) {
        if(chip != null){
            return new Chip(chip.property);
        }
        return null;
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return issuedChips.remove(obj);
    }
}
