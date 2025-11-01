package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.PurchaseLotto;
import lotto.View.ErrorMessage;
import lotto.View.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Nested
    @DisplayName("입력값 테스트")
    class 입력값_테스트 {
        @Test
        void 입력값이_빈_문자열인지_테스트1() {
            String input = "";
            assertThatIllegalArgumentException().isThrownBy(
                    () -> inputView.validateInputEmpty(input)
            ).withMessageContaining(ErrorMessage.EMPTYINPUT.getErrorMessage());
        }

        @Test
        void 입력값이_빈_문자열인지_테스트2() {
            String input = "a";
            assertThatCode(() -> new InputView().validateInputEmpty(input))
                    .doesNotThrowAnyException();
        }

        @Test
        void 입력값에_숫자_이외의_문자_포함되는지_테스트1() {
            String input = "a";
            assertThatIllegalArgumentException().isThrownBy(
                    () -> inputView.validateInputisNotNumber(input)
            ).withMessageContaining(ErrorMessage.NOTNUMBER.getErrorMessage());
        }

        @Test
        void 입력값에_숫자_이외의_문자_포함되는지_테스트2() {
            String input = "1";
            assertThatCode(() -> new InputView().validateInputisNotNumber(input))
                    .doesNotThrowAnyException();
        }
    }


}
