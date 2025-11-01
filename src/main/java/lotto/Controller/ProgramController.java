package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Lotto;
import lotto.Domain.PurchaseLotto;
import lotto.Domain.WinningNumbers;
import lotto.Service.CompareLottoService;
import lotto.Service.ProcessInput;
import lotto.Service.PurchaseLottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class ProgramController {
    private OutputView outputView;
    private InputView inputView;
    private ProcessInput processInput;
    private PurchaseLottoService purchaseLottoService;
    private CompareLottoService compareLottoService;

    public ProgramController() {
        outputView = new OutputView();
        inputView = new InputView();
        processInput = new ProcessInput();
        purchaseLottoService = new PurchaseLottoService();
        compareLottoService = new CompareLottoService();
    }

    private PurchaseLotto PurchaseLotto() {
        while (true) {
            try {
                outputView.requestPurchaseLotto();
                String input = inputView.getInput();

                int purchaseMoney = processInput.StringtoInteger(input);
                PurchaseLotto purchaseLotto = new PurchaseLotto(purchaseMoney);

                outputView.showPurchaseLottoList(purchaseLotto);
                return purchaseLotto;
            } catch (IllegalArgumentException e) {
                outputView.requestInputAgain(e);
            }
        }
    }

    private List<Integer> saveWinningNumbers() {
        while (true) {
            try {
                outputView.requestWinningNumbers();
                String winningnumbersInput = inputView.getInput();
                return processInput.StringtoInteger(
                        processInput.splitString(winningnumbersInput));
            } catch (IllegalArgumentException e) {
                outputView.requestInputAgain(e);
            }
        }
    }

    private int compareLottoList(PurchaseLotto lottoList) {
        while (true) {
            try {
                outputView.requestWinningNumbers();
                String winningnumbersInput = inputView.getInput();
                List<Integer> numbers = processInput.StringtoInteger(
                        processInput.splitString(winningnumbersInput));

                outputView.requestBonusNumber();
                String bonusNumberInput = inputView.getInput();
                int bonusNumber = processInput.StringtoInteger(bonusNumberInput);

                WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);


            }
            catch (IllegalArgumentException e) {
                outputView.requestInputAgain(e);
            }
        }
    }
}
