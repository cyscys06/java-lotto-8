package lotto.Domain;

import lotto.Service.PurchaseLottoService;
import lotto.View.ErrorMessage;

import java.util.List;

public class PurchaseLotto {
    private final List<Lotto> lottoList;
    private final int purchaseAmount;

    public PurchaseLotto(int purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        purchaseAmount = purchaseMoney / LottoInfo.UNIT.getInfo();
        lottoList = new PurchaseLottoService().makeLottoList(purchaseAmount);
    }

    public void validatePurchaseMoney(int purchaseMoney) {
        validate_Negative(purchaseMoney);
        validate_NotUnit(purchaseMoney);
    }

    public void validate_Negative(int purchaseMoney) {
        if (purchaseMoney < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE.getErrorMessage());
        }
    }

    public void validate_NotUnit(int purchaseMoney) {
        if (purchaseMoney % LottoInfo.UNIT.getInfo() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOTUNIT.getErrorMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
