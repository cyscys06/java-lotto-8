package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getInput() {
        return Console.readLine();
    }

    public void validateInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getErrorMessage()
                    + ErrorMessage.EMPTYINPUT.getErrorMessage());
        }
    }

    public void validateInputisNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getErrorMessage()
                    + ErrorMessage.NOTNUMBER.getErrorMessage());
        }
    }
}
