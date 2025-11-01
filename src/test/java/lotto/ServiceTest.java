package lotto;

import lotto.Domain.*;
import lotto.Service.CompareLottoService;
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
    private CompareLottoService compareLottoService;

    @BeforeEach
    void setUp() {
        processInput = new ProcessInput();
        purchaseLottoService = new PurchaseLottoService();
        compareLottoService = new CompareLottoService();
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

    @Nested
    @DisplayName("당첨 확인 테스트")
    class 당첨_확인_테스트 {
        @Test
        void 로또_당첨_테스트() {
            Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            WinningNumbers winningLotto =
                    new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 22);

            WinningPrize winningPrize = compareLottoService.compareLotto(lotto, winningLotto);

            assertThat(winningPrize.getPrize()).isEqualTo(5000);
        }

        @Test
        void 보너스번호_당첨_테스트() {
            Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            WinningNumbers winningLotto =
                    new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

            WinningPrize winningPrize = compareLottoService.compareLotto(lotto, winningLotto);

            assertThat(winningPrize.getPrize()).isEqualTo(30000000);
        }

        @Test
        void 로또_리스트_당첨_테스트() {
            int purchaseMoney = 8000;
            WinningNumbers winningNumbers = new WinningNumbers(
                    Arrays.asList(8, 21, 1, 41, 42, 43), 23);
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        PurchaseLotto purchaseLotto
                                = new PurchaseLotto(purchaseMoney);
                        int totalPrize = compareLottoService.
                                compareLottoList(purchaseLotto, winningNumbers);
                        assertThat(totalPrize).isEqualTo(30050000);
                    },
                    List.of(8, 21, 23, 41, 42, 43), // 3천만원당첨
                    List.of(3, 5, 11, 16, 32, 38),
                    List.of(7, 11, 16, 35, 36, 44),
                    List.of(1, 8, 11, 31, 41, 42), // 5만원당첨
                    List.of(13, 14, 16, 38, 42, 45),
                    List.of(7, 11, 30, 40, 42, 43),
                    List.of(2, 13, 22, 32, 38, 45),
                    List.of(1, 3, 5, 14, 22, 45)
            );
        }
    }

}
