package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    MoneyChanger moneyChanger;

    public LottoStore(MoneyChanger moneyChanger) {
        this.moneyChanger = moneyChanger;
    }

    public LottoStore(){
        this.moneyChanger = money -> money / 1000;
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
