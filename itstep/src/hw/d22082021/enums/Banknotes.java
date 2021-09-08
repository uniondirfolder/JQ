package hw.d22082021.enums;

import hw.d22082021.abstracts.Developer;

@Developer
public enum Banknotes {
    GREEN(1),
    YELLOW(10),
    RED(100),
    BLUE(1000);

    public final int val;

    Banknotes(int val) {
        this.val = val;
    }
}
