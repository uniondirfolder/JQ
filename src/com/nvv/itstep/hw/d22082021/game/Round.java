package com.nvv.itstep.hw.d22082021.game;


import com.nvv.itstep.hw.d22082021.abstracts.Developer;
import com.nvv.itstep.hw.d22082021.enums.CasinoSaid;
import com.nvv.itstep.hw.d22082021.tables.BlackJackTable;

import java.util.ArrayList;
import java.util.Scanner;

@Developer
public final class Round {
    private final BlackJackTable table;
    private ArrayList<Bet> bets = new ArrayList<>();

    public Round(BlackJackTable table) {
        this.table = table;
    }


    public void run() {
        String msgIn = "";
        Scanner scanner = new Scanner(System.in);

        while (!msgIn.equals("stop")) {// stop может кинуть казино, игроки могут покинуть стол, казино - банкрот
            System.out.println(table.printPlayers());

            // выдача карт
            table.issueCards();
            System.out.println(table.printPlayersCards(0, "казино"));
            for (int i = 1; i < bets.size() ; i++) {
                System.out.println(table.printPlayersCards(i, "игрок"));
            }
            // автоставка
            System.out.println("Автоставка ...");
            // Берете карту
            int count = bets.size() - 1; // счетчик игроков не сделавших выбор
            while (count > 0) {
                byte[] arrAsk = new byte[bets.size()];
                if(table.getNextCard()== CasinoSaid.YES){
                    table.issueCard(0);
                }
                for (int i = 1; i < arrAsk.length && count > 0; i++) {
                    if (arrAsk[i] == 0 && i != 0) { // опрос игорков
                        System.out.println("Игрок " + i + "  - берете еще карту? (y/n)");
                        msgIn = scanner.nextLine();
                        if (msgIn.equals("y")) {
                            table.issueCard(i); // выдаем карту
                            System.out.println(table.printPlayersCards(i, "игрок"));
                            if(table.calculate(i)> table.WIN_NUMBER){
                                arrAsk[i] = 1; // юзер перебрал карту
                                count--;
                            }
                        } else {
                            arrAsk[i] = 1;
                            count--; // помечаем отказ добрать карту в массиве, уменьшаем счетчик
                        }
                    }
                }
            }
            System.out.println(table.printPlayersCards(0, "казино"));
            for (int i = 1; i < bets.size() ; i++) {
                System.out.println(table.printPlayersCards(i, "игрок"));
            }

            // Вычисляем победителя
            System.out.println(table.getWinBets());
            for (int i = 1; i < table.getCountActivePlayers(); i++) {
                System.out.println("Игрок " + i + "  - Хотите продолжить? (y/n)");
                while (true){
                    msgIn = scanner.nextLine();
                    if (msgIn.equals("y")){
                        break;
                    }else if(msgIn.equals("n")){
                        table.removePlayerFromRound(bets.get(i).getPlayer());
                        bets.remove(i);
                        System.out.println("Игрок "+i+" покинул игру...");
                        break;
                    }
                }
            }
            if(table.getCountActivePlayers() == 1 || table.casinoIsFail()){
                msgIn ="stop";
                System.out.println("Стол пуст.");
            }

        }
    }


    public ArrayList<Bet> getBets() {
        return bets;
    }
}
