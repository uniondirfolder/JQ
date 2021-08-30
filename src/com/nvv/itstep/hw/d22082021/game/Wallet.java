package com.nvv.itstep.hw.d22082021.game;

import com.nvv.itstep.hw.d22082021.abstracts.Developer;
import com.nvv.itstep.hw.d22082021.abstracts.MoneyOperation;
import com.nvv.itstep.hw.d22082021.abstracts.Universal;
import com.nvv.itstep.hw.d22082021.enums.Banknotes;
import com.nvv.itstep.hw.d22082021.pool.ProgramObject;

import java.util.ArrayList;

@Developer
public class Wallet extends ProgramObject implements MoneyOperation, Universal {
    private ArrayList<Banknotes> money = new ArrayList<>();
    private boolean isOnlySmaller = false;
    private int balance;


    public int getBalance() {
        return balance;
    }

    public void addBanknotes(int count, Banknotes banknote) {
        while (count > 0) {
            debit(banknote);
            count--;
        }
    }

    @Override
    public Banknotes[] credit(int count, Banknotes banknote) {
        if (balance >= banknote.val * count) {
            setSmallerOnes();
            Banknotes[] get = new Banknotes[count * banknote.val];
            for (int i = 0; i < get.length; i++) {
                get[i] = money.get(money.size() - 1);
                money.remove(money.size() - 1);
                balance -= get[i].val;
            }
        }
        return null;
    }

    @Override
    public void debit(Banknotes banknote) {
        money.add(banknote);
        balance += banknote.val;
        if (banknote != Banknotes.GREEN) {
            isOnlySmaller = false;
        }
    }

    @Override
    public boolean setBiggerOnes() {
        if (balance > 0) {
            ArrayList<Banknotes> _new = new ArrayList<>();
            int tBalance = balance;
            int tCount = 0;
            int tValue = 0;
            Banknotes curBanknote = Banknotes.RED;
            while (true) {
                switch (curBanknote) {
                    case BLUE -> {
                        tCount = tBalance /= Banknotes.BLUE.val;
                        tValue += tCount * Banknotes.BLUE.val;
                        curBanknote = Banknotes.RED;
                    }
                    case RED -> {
                        tCount = tBalance /= Banknotes.RED.val;
                        tValue += tCount * Banknotes.RED.val;
                        curBanknote = Banknotes.YELLOW;
                    }
                    case YELLOW -> {
                        tCount = tBalance /= Banknotes.YELLOW.val;
                        tValue += tCount * Banknotes.YELLOW.val;
                        curBanknote = Banknotes.GREEN;
                    }
                    case GREEN -> {
                        tCount = tBalance /= Banknotes.GREEN.val;
                        tValue += tCount * Banknotes.GREEN.val;
                    }
                }

                while (tCount > 0) {
                    _new.add(curBanknote);
                    tCount--;
                }
                if (tBalance == tValue) {
                    long smC = _new.stream().filter(f -> f == Banknotes.GREEN).count();
                    if ((long) _new.size() != smC) {
                        isOnlySmaller = false;
                    }
                    return true;
                }
                if (curBanknote == Banknotes.GREEN) { // save exit
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public boolean setSmallerOnes() {
        if (balance > 0) {
            ArrayList<Banknotes> _new = new ArrayList<>();
            int temp = balance;
            while (temp > 0) {
                _new.add(Banknotes.GREEN);
                temp--;
            }
            this.money = _new;
            isOnlySmaller = true;
            return true;
        }
        return false;
    }

    @Override
    public void optimizeCash() {
        setSmallerOnes();
        setBiggerOnes();
    }


    @Override
    public boolean add(Object obj) {
        if (obj instanceof Banknotes) {
            Banknotes b = (Banknotes) obj;
            money.add(b);
            balance += b.val;
            if (b != Banknotes.GREEN) {
                isOnlySmaller = false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Banknotes) {
            Banknotes bR = (Banknotes) obj;
            for (int i = 0; i < money.size(); i++) {
                Banknotes bL = money.get(i);
                if (bL.val == bR.val) {
                    balance -= bL.val;
                    money.remove(i);
                    long cSm = money.stream().filter(f -> f == Banknotes.GREEN).count();
                    if ((long) money.size() == cSm) {
                        isOnlySmaller = true;
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
