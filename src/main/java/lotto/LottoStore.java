package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    MoneyChanger moneyChanger;

    public LottoStore(MoneyChanger moneyChanger) {
        this.moneyChanger = moneyChanger;
    }

    public List<Lotto> buy(int money) {
        int lottoCount = moneyChanger.change(money);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }
}
