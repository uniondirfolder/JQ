package hw.d22082021.abstracts;


import hw.d22082021.enums.Banknotes;
import hw.d22082021.game.Chip;
@Developer
public interface CasinoInterface {
    Chip[] getChips(Banknotes[] banknotes);
    Banknotes[] getWin(Chip[] chips);
    void runBlackJack();
    Chip getNewChip(Chip chip);
}
