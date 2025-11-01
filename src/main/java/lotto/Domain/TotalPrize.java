package lotto.Domain;

public class TotalPrize {
    private double yield = 0;

    public TotalPrize(int totalPrize, int purchaseMoney) {
        yield = (double) totalPrize / purchaseMoney * 100;
    }

    public double getYield() {
        return yield;
    }
}
