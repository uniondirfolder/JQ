package hw.d22082021.abstracts;


import hw.d22082021.enums.Banknotes;
@Developer
public interface MoneyOperation {
    Banknotes[] credit(int count, Banknotes banknote);
    void debit(Banknotes banknote);
    boolean setBiggerOnes();
    boolean setSmallerOnes();
    void optimizeCash();
}
