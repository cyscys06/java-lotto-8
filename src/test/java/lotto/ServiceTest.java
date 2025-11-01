package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.PurchaseLotto;
import lotto.Domain.WinningNumbers;
import lotto.Service.ProcessInput;

import static org.assertj.core.api.Assertions.*;

import lotto.Service.PurchaseLottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import java.util.Arrays;
import java.util.List;

public class ServiceTest {
    private ProcessInput processInput;
    private PurchaseLottoService purchaseLottoService;

    @BeforeEach
    void setUp() {
        processInput = new ProcessInput();
        purchaseLottoService = new PurchaseLottoService();
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

    @Nested
    @DisplayName("로또 구매 테스트")
    class 로또_구매_테스트 {
        @Test
        void 로또_생성_테스트() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        assertThat(purchaseLottoService.makeLotto())
                                .containsExactly(1, 5, 8, 23, 33, 45);
                    }, List.of(8, 23, 45, 1, 5, 33)
            );
        }

        @Test
        void 로또_리스트_생성_테스트() {
            int purchaseMoney = 14000;
            PurchaseLotto purchaseLotto = new PurchaseLotto(purchaseMoney);
            assertThat(purchaseLotto.getLottoList()).hasSize(14);
        }
    }



}
