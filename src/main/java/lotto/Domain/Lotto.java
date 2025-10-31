package lotto.Domain;

import lotto.View.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto_NumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.LOTTONUMBER_COUNT.getInfo()) {
            throw new IllegalArgumentException(ErrorMessage.NOTPROPERCOUNT.getErrorMessage());
        }
    }

    private void validateLotto_NumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LottoInfo.LOTTONUMBER_MAX.getInfo() ||
                    number < LottoInfo.LOTTONUMBER_MIN.getInfo()) {
                throw new IllegalArgumentException(ErrorMessage.NOTINRANGE.getErrorMessage());
            }
        }
    }

    public void validateLotto(List<Integer> numbers) {
        validateLotto_NumberRange(numbers);
        validateLotto_NumberCount(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
