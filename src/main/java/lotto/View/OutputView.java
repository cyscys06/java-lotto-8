package lotto.View;

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
}
