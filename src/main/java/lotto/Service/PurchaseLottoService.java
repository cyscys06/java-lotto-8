package lotto.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.LottoInfo;

public class PurchaseLottoService {
    public List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoInfo.LOTTONUMBER_MIN.getInfo(),
                LottoInfo.LOTTONUMBER_MAX.getInfo(),
                LottoInfo.LOTTONUMBER_COUNT.getInfo());

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }
}
