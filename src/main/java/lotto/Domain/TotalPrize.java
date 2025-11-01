package lotto.Domain;

public class TotalPrize {
    private double yield;

    public TotalPrize(int totalPrize, int purchaseMoney) {
        if (totalPrize != 0) {
            yield = (double)totalPrize / purchaseMoney;
        }
    }

    public double getYield() {
        return yield;
    }
}
