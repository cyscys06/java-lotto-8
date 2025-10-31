package lotto.Service;

import lotto.View.Message;

import java.util.ArrayList;
import java.util.List;

public class ProcessInput {
    public String[] splitString(String input) {
        return input.split(Message.SEPARATOR.getMessage());
    }

    public List<Integer> StringtoInteger(String[] splitString) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : splitString) {
            numbers.add(Integer.parseInt(string));
        }
        return numbers;
    }
}
