package lotto.Domain;

import lotto.View.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    WinningNumbers(List<Integer> numbers, int number) {
        validate_Unique(numbers, number);
        winningNumbers = new Lotto(numbers);
        bonusNumber = number;
    }

    private void validate_Unique(List<Integer> numbers, int number) {
        HashSet<Integer> validateUnique = new HashSet<>(numbers);
        validateUnique.add(number);
        if (validateUnique.size() != LottoInfo.LOTTONUMBER_COUNT.getInfo() + 1) {
            throw new IllegalArgumentException(ErrorMessage.NOTUNIQUE.getErrorMessage());
        }
    }
}
