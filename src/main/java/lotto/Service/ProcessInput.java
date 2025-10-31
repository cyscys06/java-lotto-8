package lotto.Service;

import lotto.View.Message;

public class ProcessInput {
    public String[] splitString(String input) {
        return input.split(Message.SEPARATOR.getMessage());
    }
}
