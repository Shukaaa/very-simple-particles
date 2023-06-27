package rip.shukaaa.testyay.enums;

public enum Amount {
    TINY(1),
    SMALL(5),
    MEDIUM(10),
    LARGE(25),
    HUGE(50);

    private final int amount;

    Amount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
