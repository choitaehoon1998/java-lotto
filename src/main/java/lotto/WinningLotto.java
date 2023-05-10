package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningLottoNumbers = new ArrayList<>();

    public WinningLotto(List<Integer> winningLottoNumbers) {
        for (Integer winningLottoNumber : winningLottoNumbers) {
            this.winningLottoNumbers.add(new LottoNumber(winningLottoNumber));
        }
    }

    public Long match(Lotto lotto) {
        int matchCount = Math.toIntExact(lotto.getLottoNumbers().stream().filter(winningLottoNumbers::contains).count());
        return WinningPrice.getWiningPrice(matchCount);
    }
}
