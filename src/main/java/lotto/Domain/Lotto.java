package lotto.Domain;

import lotto.View.ErrorMessage;

import java.util.List;

public class Lotto {
    private static final int LOTTONUMBER_MIN = 1;
    private static final int LOTTONUMBER_MAX = 45;
    private static final int LOTTONUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto_NumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTONUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOTPROPERCOUNT.getErrorMessage());
        }
    }

    private void validateLotto_NumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LOTTONUMBER_MAX || number < LOTTONUMBER_MIN) {
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
