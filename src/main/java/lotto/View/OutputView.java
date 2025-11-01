package lotto.View;

import lotto.Domain.*;

import java.util.HashMap;

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

    public void requestInputAgain(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        System.out.println(ErrorMessage.REQUESTAGAIN.getErrorMessage());
    }

    public void showCorrectResult(HashMap<WinningPrize, Integer> correctLottoList) {
        System.out.println(Message.STATISTICS.getMessage());
        System.out.println(Message.HR.getMessage());

        System.out.println(Message.FIFTH_PLACE.getMessage()
                + Message.HYPHEN.getMessage()
                + correctLottoList.get(WinningPrize.FIFTH)
                + Message.COUNT.getMessage());
        System.out.println(Message.FOURTH_PLACE.getMessage()
                + Message.HYPHEN.getMessage()
                + correctLottoList.get(WinningPrize.FOURTH)
                + Message.COUNT.getMessage());
        System.out.println(Message.THIRD_PLACE.getMessage()
                + Message.HYPHEN.getMessage()
                + correctLottoList.get(WinningPrize.THIRD)
                + Message.COUNT.getMessage());
        System.out.println(Message.SECOND_PLACE.getMessage()
                + Message.HYPHEN.getMessage()
                + correctLottoList.get(WinningPrize.SECOND)
                + Message.COUNT.getMessage());
        System.out.println(Message.FIRST_PLACE.getMessage()
                + Message.HYPHEN.getMessage()
                + correctLottoList.get(WinningPrize.FIRST)
                + Message.COUNT.getMessage());
    }

    public void showYield(TotalPrize totalPrize) {
        double result = (double) Math.round(totalPrize.getYield());
        System.out.println(Message.YIELD.getMessage()
                + result + Message.PERCENT.getMessage());
    }
}
