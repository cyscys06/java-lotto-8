package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.PurchaseLotto;

public class OutputView {
    public void requestPurchaseLotto() {
        System.out.println(Message.REQUEST_PURCHASELOTTO.getMessage());
    }

    public void requestWinningNumbers() {
        System.out.println(Message.REQUEST_WINNINGNUMBERS.getMessage());
    }

    public void requestBonusNumber() {
        System.out.println(Message.REQUEST_BONUSNUMBER.getMessage());
    }

    public void showPurchaseLottoList(PurchaseLotto purchaseLotto) {
        System.out.println(purchaseLotto.getPurchaseAmount() +
                Message.NOTICE_PURCHASELOTTO.getMessage());
        for (Lotto lotto : purchaseLotto.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
