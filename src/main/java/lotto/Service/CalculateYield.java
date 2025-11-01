package lotto.Service;

import lotto.Domain.TotalPrize;

public class CalculateYield {
    public TotalPrize calculateYield(int totalPrize, int purchaseMoney) {
        return new TotalPrize(totalPrize, purchaseMoney);
    }
}
