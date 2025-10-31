package lotto.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.Domain.LottoInfo;
import lotto.Domain.PurchaseLotto;

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

    public List<Lotto> makeLottoList(int purchaseCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0 ; i < purchaseCount; i++) {
            lottoList.add(new Lotto(makeLotto()));
        }
        return lottoList;
    }
}
