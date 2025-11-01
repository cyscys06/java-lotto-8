package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.PurchaseLotto;
import lotto.Domain.WinningNumbers;
import lotto.View.ErrorMessage;
import lotto.View.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Nested
    @DisplayName("구매 금액 테스트")
    class 구매_금액_테스트 {
        @Test
        void 구매_금액이_음수인지_테스트() {
            int purchaseMoney = -1;
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new PurchaseLotto(purchaseMoney)
            ).withMessageContaining(ErrorMessage.NEGATIVE.getErrorMessage());
        }

        @Test
        void 구매_금액이_1천원_단위인지_테스트() {
            int purchaseMoney = 1;
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new PurchaseLotto(purchaseMoney)
            ).withMessageContaining(ErrorMessage.NOTUNIT.getErrorMessage());
        }

        @Test
        void 구매_금액이_정상값인지_테스트() {
            int purchaseMoney = 14000;
            assertThatCode(
                    () -> new PurchaseLotto(purchaseMoney)
            ).doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("당첨번호 테스트")
    class 당첨번호_테스트 {
        @Test
        void 당첨번호_범위_테스트() {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 77, 87));
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Lotto(numbers)
            ).withMessageContaining(ErrorMessage.NOTINRANGE.getErrorMessage());
        }

        @Test
        void 당첨번호_개수_테스트() {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 17, 37));
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Lotto(numbers)
            ).withMessageContaining(ErrorMessage.NOTPROPERCOUNT.getErrorMessage());
        }

        @Test
        void 당첨번호_중복_테스트() {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 7, 7, 7, 7));
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Lotto(numbers)
            ).withMessageContaining(ErrorMessage.NOTUNIQUE.getErrorMessage());
        }
    }

    @Nested
    @DisplayName("보너스번호 테스트")
    class 보너스번호_테스트 {
        @Test
        void 보너스번호_범위_테스트() {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
            int bonusNumber = 77;
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new WinningNumbers(numbers, bonusNumber)
            ).withMessageContaining(ErrorMessage.NOTINRANGE.getErrorMessage());
        }

        @Test
        void 보너스번호_중복_테스트() {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
            int bonusNumber = 6;
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new WinningNumbers(numbers, bonusNumber)
            ).withMessageContaining(ErrorMessage.NOTUNIQUE.getErrorMessage());
        }
    }


}
