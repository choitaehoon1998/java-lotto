package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {
    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoStorage(List<Lotto> lottoList) {
        this.lottoList.addAll(lottoList);
    }

    public int numberOfLotto() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
