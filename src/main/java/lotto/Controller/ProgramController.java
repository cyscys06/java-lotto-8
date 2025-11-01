package lotto.Controller;

import lotto.Domain.PurchaseLotto;
import lotto.Service.ProcessInput;
import lotto.Service.PurchaseLottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

public class ProgramController {
    private OutputView outputView;
    private InputView inputView;
    private ProcessInput processInput;
    private PurchaseLottoService purchaseLottoService;

    public ProgramController() {
        outputView = new OutputView();
        inputView = new InputView();
        processInput = new ProcessInput();
        purchaseLottoService = new PurchaseLottoService();
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
}
