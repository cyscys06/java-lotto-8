package lotto.Domain;

import lotto.View.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    private static final int UNIT = 1000;
    private final List<Lotto> LottoList;
    private int purchaseAmount;

    PurchaseLotto() {
        LottoList = new ArrayList<>();
    }

    public void validate_Negative(int purchaseMoney) {
        if (purchaseMoney < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE.getErrorMessage());
        }
    }

    public void validate_NotUnit(int purchaseMoney) {
        if (purchaseMoney % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOTUNIT.getErrorMessage());
        }
    }
}
