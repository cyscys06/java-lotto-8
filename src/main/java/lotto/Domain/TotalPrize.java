package lotto.Domain;

public class TotalPrize {
    private final double yield;

    public TotalPrize(int totalPrize, int purchaseMoney) {
        yield = (double)totalPrize / purchaseMoney;
    }

    public double getYield() {
        return yield;
    }
}
