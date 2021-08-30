package com.nvv.itstep.hw.d22082021.tables;

import com.nvv.itstep.hw.d22082021.abstracts.Developer;
import com.nvv.itstep.hw.d22082021.abstracts.Participant;
import com.nvv.itstep.hw.d22082021.abstracts.Table;
import com.nvv.itstep.hw.d22082021.enums.Banknotes;
import com.nvv.itstep.hw.d22082021.enums.CasinoSaid;
import com.nvv.itstep.hw.d22082021.enums.ChipEnum;
import com.nvv.itstep.hw.d22082021.game.*;

import java.util.ArrayList;

@Developer
public class BlackJackTable extends Table {
    public BlackJackTable(Croupier croupier, Casino casino) {
        super(croupier, casino);
    }

    public void runTestMode() {
        ArrayList<Chip> alc = new ArrayList<>();
        alc.add(new Chip(ChipEnum.GREEN));
        Wallet w = new Wallet();
        w.debit(Banknotes.GREEN);
        addPlayer(new Player(w, alc));

        ArrayList<Chip> alc1 = new ArrayList<>();
        alc1.add(new Chip(ChipEnum.GREEN));
        Wallet w1 = new Wallet();
        w1.debit(Banknotes.GREEN);
        addPlayer(new Player(w1, alc1));

        newRound();
    }

    public final int MAX_USER = 2;
    public final int WIN_NUMBER = 21;


    @Override
    protected boolean changeCroupier(Croupier croupier) {
        super.croupier = croupier;
        return true;
    }

    @Override
    protected boolean addPlayer(Player player) {
        if (super.players.size() < MAX_USER) {
            super.players.add(player);
            return true;
        }
        return false;
    }

    @Override
    protected boolean removePlayer(Player player) {
        Participant pD = player;
        for (int i = 0; i < players.size(); i++) {
            Participant p = players.get(i);
            if (p.getId() == pD.getId()) {
                players.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    protected void newRound() {
        super.round = new Round(this);
        super.round.getBets().add(new Bet(players.get(0)));
        super.round.getBets().add(new Bet(players.get(1)));
        round.run();
    }


    public int getCountActivePlayers() {
        return super.players.size();
    }


    public boolean casinoIsFail() {
        return casino.getWallet().getBalance() <= 0;
    }

    public String printPlayers() {
        StringBuilder sb = new StringBuilder();
        sb.append("Фишки игроков: \n");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            sb.append("Игрок " + i + " :" + p.getWallet().getBalance() + " | ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public void autoSetBets() { // автоставка
        ArrayList<Bet> bs = round.getBets();
        for (int i = 0; i < bs.size(); i++) {
            Bet b = bs.get(i);
            b.getChips().add(b.getPlayer().autoGetBet());
        }
    }

    public void issueCards() {// первая выдача карт
        ArrayList<Bet> bs = round.getBets();
        for (int i = 0; i < bs.size(); i++) {
            Bet b = bs.get(i);
            b.getCurCards().add(croupier.issueCard());
            b.getCurCards().add(croupier.issueCard());
        }
    }

    public void issueCard(int index) { // выдать карту игроку
        ArrayList<Bet> bs = round.getBets();
        Bet b = bs.get(index);
        b.getCurCards().add(croupier.issueCard());
    }

    public String printPlayersCards(int index, String name) {
        return name + ">" + index + " карты " + round.getBets().get(index).printCards() + "\n";
    }

    public CasinoSaid getNextCard() {
        if (calculate(0) < WIN_NUMBER) {
            return CasinoSaid.YES;
        }
        return CasinoSaid.NO;
    }

    public int calculate(int index) {
        ArrayList<Bet> bs = round.getBets();
        Bet b = bs.get(index);
        ArrayList<Card> cc = b.getCurCards();
        int sum = 0;
        int countAce = 0;
        for (int i = 0; i < cc.size(); i++) {
            Card c = cc.get(i);
            if (c.getDignity() == Card.Dignity.ACE) {
                countAce++;
            } else {
                sum += c.getPoint();
            }
        }
        if (countAce > 1) {
            return sum += Card.MIN_VALUE_ACE * countAce;
        } else if (countAce == 1 && (Card.MAX_VALUE_ACE + sum) < WIN_NUMBER + 1) {
            return sum += Card.MAX_VALUE_ACE;
        }
        return sum;
    }

    public String getWinBets() { // вычисление результата
        StringBuilder sb = new StringBuilder();
        ArrayList<Bet> bs = round.getBets();
        byte[] results = new byte[bs.size()];
        int[] points = new int[results.length];


        for (int i = 0; i < results.length; i++) {

            points[i] = calculate(i); //считаем очки
            if (points[i] <= WIN_NUMBER) {
                results[i] = 1; // помечаем что не сфейлили
            } else {
                sb.append("Игрок: ");
                sb.append(i + " {" + points[i] + "}, ");
                Bet bet = bs.get(i);
                Player player = bet.getPlayer();
                ArrayList<Chip> betCip = bet.getChips();
                for (int j = 0; j < betCip.size(); j++) {
                    player.setFail(betCip.get(j)); // удаляем у участников
                    casino.remove(betCip.get(j)); // удаляем из пула
                    betCip.remove(j); // удаляем из текушей ставки
                }

                sb.append(" - ставка не сыграла\n");
            }

        }
        int pCasino = points[0];
        int pUser = 0;
        boolean casinoFail = pCasino < WIN_NUMBER;
        if (casinoFail) {
            pCasino = 0;
        }
        for (int i = 1; i < points.length; i++) {
            Bet bet = bs.get(i);
            pUser = points[i];
            if (casinoFail && pUser <= WIN_NUMBER) {
                sb.append("Казино в проигрыше {" + pCasino + "} . Победил игрок " + i + " очки {" + pUser + "} \n");
                ArrayList<Chip> playerChips = bet.getChips(); // выдаем игроку его выигрышные фишки
                for (int j = 0, w = playerChips.size(); j < w; j++) {
                    playerChips.add(casino.getNewChip(playerChips.get(j)));
                }
            } else {
                if (pUser > WIN_NUMBER) {
                    pUser = 0;
                }
                if (pCasino == pUser) {
                    sb.append("Ничья. Игрок " + i + " {" + pUser + "}" + " казино {" + pCasino + "}\n");
                } else if (pCasino < pUser) {
                    sb.append("Казино в проигрыше. Победил игрок " + i + " {" + pUser + "} казино {" + pCasino + "}\n");
                    ArrayList<Chip> playerChips = bet.getChips(); // выдаем игроку его выигрышные фишки
                    for (int j = 0, w = playerChips.size(); j < w; j++) {
                        playerChips.add(casino.getNewChip(playerChips.get(j)));
                    }
                } else if (pCasino <= WIN_NUMBER && pCasino > 0) {
                    Player player = bet.getPlayer();
                    ArrayList<Chip> betCip = bet.getChips();
                    for (int j = 0; j < betCip.size(); j++) {
                        player.setFail(betCip.get(j)); // удаляем у участников
                        casino.remove(betCip.get(j)); // удаляем из пула
                        betCip.remove(j); // удаляем из текушей ставки
                    }

                    sb.append("Игрок " + i + " в проигрыше. {" + points[i] + "} Победило казино. {" + points[0] + "}\n");
                }
            }

        }
        return sb.toString();
    }


    public void removePlayerFromRound(Player player) {
        removePlayer(player);

    }
}
