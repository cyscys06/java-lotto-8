package lotto.Domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    WinningNumbers(List<Integer> numbers, int number) {
        winningNumbers = new Lotto(numbers);
        bonusNumber = number;
    }

}
