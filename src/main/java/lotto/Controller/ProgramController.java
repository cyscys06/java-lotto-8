package lotto.Controller;

import lotto.Domain.*;
import lotto.Service.CalculateYield;
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
    private CalculateYield calculateYield;

    public ProgramController() {
        outputView = new OutputView();
        inputView = new InputView();
        processInput = new ProcessInput();
        purchaseLottoService = new PurchaseLottoService();
        compareLottoService = new CompareLottoService();
        calculateYield = new CalculateYield();
    }

    public void run() {
        PurchaseLotto purchaseLotto = PurchaseLotto();
        WinningNumbers winningNumbers = makeWinnningNumbers();
        TotalPrize totalPrize = compareLottoListProcess(purchaseLotto, winningNumbers);
        showResult(compareLottoService, totalPrize);
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

    private int saveBonusNumber() {
        while (true) {
            try {
                outputView.requestBonusNumber();
                String bonusNumberInput = inputView.getInput();

                return  processInput.StringtoInteger(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                outputView.requestInputAgain(e);
            }
        }
    }

    private WinningNumbers makeWinnningNumbers () {
        while (true) {
            try {
                List<Integer> numbers = saveWinningNumbers();
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

        return calculateYield.calculateYield(lottoList.getPurchaseMoney(), totalPrize);
    }

    private void showResult(CompareLottoService correctLottoList, TotalPrize totalPrize) {
        outputView.showCorrectResult(correctLottoList.getCorrectLottoList());
        outputView.showYield(totalPrize);
    }
}
