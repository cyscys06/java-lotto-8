package lotto.Domain;

import lotto.View.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int number) {
        validateLotto_NumberRange(number);
        winningNumbers = new Lotto(numbers);
        validate_Unique(numbers, number);
        bonusNumber = number;
    }

    private void validate_Unique(List<Integer> numbers, int number) {
        HashSet<Integer> validateUnique = new HashSet<>(numbers);
        validateUnique.add(number);
        if (validateUnique.size() != LottoInfo.LOTTONUMBER_COUNT.getInfo() + 1) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getErrorMessage()
                    + ErrorMessage.NOTUNIQUE.getErrorMessage());
        }
    }

    private void validateLotto_NumberRange(int number) {
        if (number > LottoInfo.LOTTONUMBER_MAX.getInfo() ||
                number < LottoInfo.LOTTONUMBER_MIN.getInfo()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getErrorMessage()
                            + ErrorMessage.NOTINRANGE.getErrorMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
