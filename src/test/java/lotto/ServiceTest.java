package lotto;

import lotto.Service.ProcessInput;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceTest {
    private ProcessInput processInput;

    @BeforeEach
    void setUp() {
        processInput = new ProcessInput();
    }

    @Nested
    @DisplayName("입력값 가공 테스트")
    class 입력값_가공_테스트 {
        @Test
        void 문자열_정수로_변환_테스트() {
            String input = "1";
            assertThat(processInput.StringtoInteger(input)).isEqualTo(1);
        }

        @Test
        void 문자열_분리_테스트() {
            String input = "1,2,3";
            String[] splitInput = processInput.splitString(input);

            assertThat(splitInput[0]).isEqualTo("1");
            assertThat(splitInput[1]).isEqualTo("2");
            assertThat(splitInput[2]).isEqualTo("3");
        }

        @Test
        void 문자열_배열_정수로_변환_테스트() {
            String[] splitInput = new String[] {"1", "2", "3"};
            List<Integer> numbers = processInput.StringtoInteger(splitInput);

            assertThat(numbers.get(0)).isEqualTo(1);
            assertThat(numbers.get(1)).isEqualTo(2);
            assertThat(numbers.get(2)).isEqualTo(3);
        }
    }
}
