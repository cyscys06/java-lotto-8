package lotto.Service;

import lotto.Domain.Lotto;
import lotto.Domain.PurchaseLotto;
import lotto.Domain.WinningNumbers;
import lotto.Domain.WinningPrize;

import java.util.HashMap;

public class CompareLottoService {
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

}
