package lotto.Controller;

import lotto.Domain.*;
import lotto.Service.CalculateYield;
import lotto.Service.CompareLottoService;
import lotto.Service.ProcessInput;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class ProgramController {
    private final OutputView outputView;
    private final InputView inputView;
    private final ProcessInput processInput;
    private final CompareLottoService compareLottoService;
    private final CalculateYield calculateYield;

    public ProgramController() {
        outputView = new OutputView();
        inputView = new InputView();
        processInput = new ProcessInput();
        compareLottoService = new CompareLottoService();
        calculateYield = new CalculateYield();
    }

    public void run() {
        PurchaseLotto purchaseLotto = purchaseLottoProcess();
        WinningNumbers winningNumbers = makeWinnningNumbers();
        TotalPrize totalPrize = compareLottoListProcess(purchaseLotto, winningNumbers);
        showResult(compareLottoService, totalPrize);
    }

    private PurchaseLotto purchaseLottoProcess() {
        while (true) {
            try {
                outputView.requestPurchaseLotto();
                String input = inputView.getInput();
                inputView.validateInputisNotNumber(input);

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

                String[] splitInput = processInput.splitString(winningnumbersInput);
                inputView.validatesplitInputisNotNumber(splitInput);

                List<Integer> numbers = processInput.StringtoInteger(splitInput);
                new Lotto(numbers);

                return numbers;
            } catch (IllegalArgumentException e) {
                outputView.requestInputAgain(e);
            }
        }
    }

    private int saveBonusNumber() {
        while (true) {
            try {
                outputView.requestBonusNumber();
                String bonusNumberInput = inputView.getInput();
                inputView.validateInputisNotNumber(bonusNumberInput);

                return  processInput.StringtoInteger(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                outputView.requestInputAgain(e);
            }
        }
    }

    private WinningNumbers makeWinnningNumbers() {
        List<Integer> numbers = saveWinningNumbers();

        while (true) {
            try {
                int number = saveBonusNumber();
                return new WinningNumbers(numbers, number);
            } catch (IllegalArgumentException e) {
                outputView.requestInputAgain(e);
            }
        }
    }

    private TotalPrize compareLottoListProcess(
            PurchaseLotto lottoList, WinningNumbers winningNumbers) {
        int totalPrize = compareLottoService.compareLottoList(lottoList, winningNumbers);

        return calculateYield.calculateYield(totalPrize, lottoList.getPurchaseMoney());
    }

    private void showResult(CompareLottoService correctLottoList, TotalPrize totalPrize) {
        outputView.showCorrectResult(correctLottoList.getCorrectLottoList());
        outputView.showYield(totalPrize);
    }
}
