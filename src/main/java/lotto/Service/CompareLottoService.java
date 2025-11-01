package lotto.Service;

import lotto.Domain.Lotto;
import lotto.Domain.PurchaseLotto;
import lotto.Domain.WinningNumbers;
import lotto.Domain.WinningPrize;

import java.util.HashMap;

public class CompareLottoService {
    private HashMap<WinningPrize, Integer> correctLottoList;

    public CompareLottoService() {
        correctLottoList = new HashMap<>();
        correctLottoList.put(WinningPrize.FIRST, 0);
        correctLottoList.put(WinningPrize.SECOND, 0);
        correctLottoList.put(WinningPrize.THIRD, 0);
        correctLottoList.put(WinningPrize.FOURTH, 0);
        correctLottoList.put(WinningPrize.FIFTH, 0);
    }

    public WinningPrize compareLotto(Lotto lotto, WinningNumbers winningNumbers) {
        int correctNumberCount = 0;
        boolean correctBonusNumber = false;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumbers().contains(number)) {
                correctNumberCount++;
            }
            if (winningNumbers.getBonusNumber() == number) {
                correctBonusNumber = true;
            }
        }
        return WinningPrize.of(correctNumberCount, correctBonusNumber);
    }

    public void compareLottoList(
            PurchaseLotto purchaseLotto, WinningNumbers winningNumbers) {
        for (Lotto lotto : purchaseLotto.getLottoList()) {
            WinningPrize prize = compareLotto(lotto ,winningNumbers);
            correctLottoList.put(prize, 0);
            if (prize != WinningPrize.NONE) {
                correctLottoList.put(prize, correctLottoList.get(prize) + 1);
            }
        }
    }

    public HashMap<WinningPrize, Integer> getCorrectLottoList() {
        return correctLottoList;
    }
}
